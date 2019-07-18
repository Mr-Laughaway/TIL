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