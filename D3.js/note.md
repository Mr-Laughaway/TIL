### D3.js

- 일단 해보기

  ```javascript
  //1. 데이터 준비
  	var dataSet = [300, 150, 10, 80, 230];
  	d3.select("#myGraph")
  		.append("rect")
  		.attr("x", 0)
  		.attr("y", 0)
  		.attr("width", dataSet[0])
  		.attr("height", "20px");
  ```

  

- 여러개 처리하기 

  ***selectAll(), data(), enter()***

  ```javascript
  var dataSet = [300, 150, 10, 80, 230];
  	d3.select("#myGraph")
  		.selectAll("rect")
  		.data(dataSet) //데이터 설정
  		.enter()
  		.append("rect")
  		.attr("x", 0)
  		.attr("y", function(d, i){
  			return i*30;
  		})
  		.attr("width", function(d, i){
  			return d+"px";
  		})
  		.attr("height", "20px");
  ```



- CSV 읽어오기 / 에니메이션

  ```javascript
  d3.csv("data.csv").then(function(data){
  		for(var i = 0; i < data.length; i++){
  			dataSet.push(data[i].item1);
  		}
  	
  	
  	d3.select("#myGraph")
  		.selectAll("rect")
  		.data(dataSet) //데이터 설정
  		.enter()
  		.append("rect")
  		.attr("x", 0)
  		.attr("y", function(d, i){
  			return i * 30;
  		})
  		.attr("width", "0px")
  		.attr("height", "20px")
  		.transition()
  		.delay(function(d, i){
  			return i*500;
  		})
  		.duration(2000)
  		.attr("width", function(d, i){
  			return d + "px";
  		});
  		
  		d3.select("#myGraph")
  		.selectAll("rect")
  		.on("click", function(){
  			d3.select(this)
  				.style("fill", "cyan");
  		});
  		
  	
  	d3.select("#updateButton")
  		.on("click", function() {
  			for(var i = 0; i < dataSet.length; i++) {
  				dataSet[i] = Math.floor(Math.random()*320);
  			}
  
  			d3.select("#myGraph")
  			.selectAll("rect")
  			.data(dataSet)
  			.transition()
  			.attr("width", function(d, i){
  				return d + "px";
  			});
  		});
  
  	});
  ```

  