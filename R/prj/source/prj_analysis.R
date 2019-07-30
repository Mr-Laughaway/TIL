#ºÐ¼®
library(rJava)
library(DBI)
library(RJDBC) 
library(geojsonio)
library(broom)
library(viridis)
library(ggplot2)
library(dplyr)


#env
setwd("c:/R/workspace_R")
register_google(key = 'AIzaSyCItPLGKviKSVW7XP-PS-L8N0dHegoxfkA')
options(digits=16)


#condition-----------------------
bounds <- c(
  126.9002922042051, 
  37.63328837459856, 
  126.94731575472879,
  37.609438871986
)
names(bounds) <- c("left", "top", "right", "bottom")
lat <- mean(bounds['bottom'], bounds['top'])
lon <- mean(bounds['left'], bounds['right'])

vector_h <- seq(bounds['left'], bounds['right'], length.out = 101)
vector_v <- seq(bounds['top'], bounds['bottom'], length.out = 51)


#get DB data in bounds
drv <- JDBC("oracle.jdbc.driver.OracleDriver","D:/dev/env/oracle/product/11.2.0/dbhome_1/jdbc/lib/ojdbc6.jar")
conn <- dbConnect(drv, "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle")

stations <- dbGetQuery(conn, paste("SELECT ps_id as id, 0 as type, longitude, latitude FROM prj_pstations WHERE (longitude between", bounds["left"], "and", bounds["right"], ") and (latitude between", bounds["bottom"], "and", bounds["top"], ") order by id"))

cctvs <- dbGetQuery(conn, paste("SELECT cctv_id as id, 1 as type, longitude, latitude FROM prj_cctvs WHERE (longitude between", bounds["left"], "and", bounds["right"], ") and (latitude between", bounds["bottom"], "and", bounds["top"], ") order by id"))

spots <- rbind(stations, cctvs)
rm(list = c("stations", "cctvs"))


# make geojson
sink("tmp.geojson")
cat("{\"type\": \"FeatureCollection\", \"features\": [");

i <- 0
lenI <- length(vector_v)
lenJ <- length(vector_h)
nID <- 0
for(v in vector_v){
  i <- i + 1
  
  if(i == lenI) break;
  
  j <- 0
  for(h in vector_h) {
    j <- j + 1
    if(j == lenJ) break;
    
    nID <- nID + 1;
    cat("\n{ \"type\": \"Feature\", \"properties\": { \"code\": \"")
    cat(nID)
    cat("\", \"name\": \"n\", \"name_eng\": \"n\", \"base_year\": ")
    cat("\"2019\" }, \"geometry\": { \"type\": \"Polygon\", ")
    cat("\"coordinates\": [ [")
    
    cat("["); cat(vector_h[j]); cat(", "); cat(vector_v[i]); cat("],");
    cat("["); cat(vector_h[j+1]); cat(", "); cat(vector_v[i]); cat("],");
    cat("["); cat(vector_h[j+1]); cat(", "); cat(vector_v[i+1]); cat("],");
    cat("["); cat(vector_h[j]); cat(", "); cat(vector_v[i+1]); cat("],");
    cat("["); cat(vector_h[j]); cat(", "); cat(vector_v[i]); cat("]");
    
    if( i == lenI-1 && j == lenJ-1)
      cat("] ] } }\n")
    else
      cat("] ] } },")
  }
}
cat("] }")
sink()

# read geojson what I've
spdf <- geojson_read("tmp.geojson",  what = "sp")
spdf_fortified <- tidy(spdf, region = "code")

#ggplot() +
#  geom_polygon(data = spdf_fortified, aes( x = long, y = lat, group = group)) +
#  theme_void() +
#  coord_map()

# read data
data=read.csv("./density2.csv", colClasses=c("character","numeric"))

# Make the merge
spdf_fortified = spdf_fortified %>% left_join(. , data, by=c("id"="ID")) 

world <- map_data("world") 




map <- get_map(location=c(left=bounds["left"],  bottom=bounds["bottom"]), right=bounds["right"], top=bounds["top"], maptype="roadmap", zoom=13, scale=2, color="bw")


ggplot() +
geom_polygon(data = world, aes(x=long, y = lat, group = group)) +
geom_polygon(
  data = spdf_fortified, 
  aes(
    alpha = 0.3,
    fill = density, 
    x = long, 
    y = lat, 
    group = group
  )
) +  
theme_void() +  
coord_map()

ggsave("output.png", device="png", dpi=600)
