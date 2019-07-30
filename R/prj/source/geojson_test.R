library(rgdal)
if (!require(geojsonio)) {
  install.packages("geojsonio")
  library(geojsonio)
}
library(sp)
library(maps)
library(ggmap)
library(maptools)

#UTF8 변경
#utf8 <- readr::read_lines("seoul_neighborhoods_juso.geojson")
#native <- enc2native(utf8)
#writeLines(native, "new_file.geojson")

#data_url <- "https://data.openupstate.org/maps/swamp-rabbit-trail/parking/geojson.php"
#data_file <- "srt_parking.geojson"
data_file <- "./seoul_municipalities.geojson"
data_file2 <- "./seoul_municipalities_juso.geojson"
data_file3 <- "./seoul_submunicipalities.geojson"
#download.file(data_url, data_file)




data_json <- geojson_read(data_file, what = "sp")
data_json2 <- geojson_read(data_file2, what = "sp")
data_json3 <- geojson_read(data_file3, what = "sp")

dev.new()
plot(data_json)
dev.new()
plot(data_json2)
dev.new()
plot(data_json3)

