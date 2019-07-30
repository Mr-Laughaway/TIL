#install.packages("rJava")
#install.packages("DBI")
#install.packages("RJDBC")

#library-------------------------
library(rJava)
#Sys.setenv(JAVA_HOME='C:\\Program Files\\Java\\jre1.8.0_161')
library(DBI)
library(RJDBC) 
library(ggplot2)
library(ggmap)
library(grid)

#driver--------------------------
drv <- JDBC("oracle.jdbc.driver.OracleDriver","D:/dev/env/oracle/product/11.2.0/dbhome_1/jdbc/lib/ojdbc6.jar")

#connection 
conn <- dbConnect(drv, "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle")

#condition-----------------------
bounds <- c(
    126.9002922042051, 
    37.63328837459856, 
    126.94731575472879,
    37.609438871986)

#bounds <- c(
#    126.89636573432396, 
#    37.62233458322356, 
#    126.95230773066204,
#    37.59847952281934)

names(bounds) <- c("left", "top", "right", "bottom")

lat <- mean(bounds['bottom'], bounds['top'])
lon <- mean(bounds['left'], bounds['right'])

#query---------------------------
stations <- dbGetQuery(conn, paste("SELECT ps_id as id, 0 as type, longitude, latitude FROM prj_pstations WHERE (longitude between", bounds["left"], "and", bounds["right"], ") and (latitude between", bounds["bottom"], "and", bounds["top"], ") order by id"
))

cctvs <- dbGetQuery(conn, paste("SELECT cctv_id as id, 1 as type, longitude, latitude FROM prj_cctvs WHERE (longitude between", bounds["left"], "and", bounds["right"], ") and (latitude between", bounds["bottom"], "and", bounds["top"], ") order by id"
))

spots <- rbind(stations, cctvs)
rm(list = c("stations", "cctvs"))

register_google(key = 'AIzaSyCItPLGKviKSVW7XP-PS-L8N0dHegoxfkA')

map <- get_map(location=c(left=bounds["left"],  bottom=bounds["bottom"]), right=bounds["right"], top=bounds["top"], maptype="roadmap", zoom=13, scale=2, color="bw")

#map <- get_map(location=c(lon=long, lat=lat), maptype="roadmap", zoom=12, scale=2)



#area <- ggmap(map, extent = "device") + coord_fixed(ylim=c(bounds["bottom"], bounds["top"]), ratio=1/cos(pi*41.39/180))

#ggmap(map, extent = "device") + coord_fixed(xlim=c(bounds["left"], bounds["right"]), ratio=1/cos(pi*41.39/180))

lats <- c(bounds["bottom"], bounds["top"])
lons <- c(bounds["left"], bounds["right"])
area <- ggmap(map, extent="device") + xlim(lons) + ylim(lats)


#area <- area + scale_y_continuous(limits=c(bounds["bottom"], bounds["top"]))
#area <- area + scale_x_continuous(limits=c(bounds["left"], bounds["right"]))

width =  max(area$data$lon) - min(area$data$lon)
height = max(area$data$lat) - min(area$data$lat)
ratio = width / height


#width = bounds["right"] - bounds["left"]
#height = bounds["top"] - bounds["bottom"]
#ratio = width / height

ggsave("test.jpg", area, dpi = 300, device="jpeg", width=ratio*3, height=3)


print(3/1.92 )





###example

hpars<-read.table("https://sites.google.com/site/arunsethuraman1/teaching/hpars.dat?revision=1")

positions <- data.frame(lon=rnorm(20000, mean=lon, sd=0.05),lat=rnorm(5000,mean=lat, sd=0.05))#Simulate some geographical coordinates #Switch out for your data that has real GPS coords

positions <-cbind(positions, hpars$V2)

map <- get_map(location=c(lon=lon, lat=lat), zoom=13, maptype='roadmap', color='bw')#Get the map from Google Maps

map <- get_map(location=c(left=bounds["left"],  bottom=bounds["bottom"]), right=bounds["right"], top=bounds["top"], maptype="roadmap", zoom=13, scale=2, color="bw")

lats <- c(bounds["bottom"], bounds["top"])
lons <- c(bounds["left"], bounds["right"])
area <- ggmap(map, extent="device") + xlim(lons) + ylim(lats)

#Plot
result <- print(area, extent = "device") + 
#geom_density2d(
#    data = positions
#    , aes(x = lon, y = lat)
#    , size = 0.3) + 
stat_density2d(
    data = spots
    , aes(
        x = spots$LONGITUDE
        , y = spots$LATITUDE
        , fill = ..level..
        , alpha = ..level..

    )
    , size = 0.01
    , bins = 16
    , geom = "polygon"
) + 
scale_fill_gradient(
    low = "red"
    , high = "green"
) + 
scale_alpha(
    range = c(0, 0.3)
    , guide = FALSE
)

ggsave("test.jpg", result, dpi = 300, device="jpeg", width=3, height=2)

