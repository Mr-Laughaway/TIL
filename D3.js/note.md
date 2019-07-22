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






- 세로 막대 그래프

  bar3.html

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Sample</title>
  <script src="https://d3js.org/d3.v5.min.js"></script>
  <script src="https://d3js.org/d3-dsv.v1.min.js"></script>
  <script src="https://d3js.org/d3-fetch.v1.min.js"></script>
  <script src="js/bar3.js"></script>
  <style>
    svg { width: 320px; height: 240px; border: 1px solid black; }
    .bar { fill: orange; }
    .barNum { font-size: 9pt; text-anchor : middle; }
    .axis text { font-family: sans-serif; font-size: 11px; }
    .axis path, .axis line { fill: none; stroke: black; }
    .axis_x line { fill: none; stroke: black; }
  </style>
  </head>
  <body>
    <h1>세로형 막대그래프 - csv파일로부터 데이터와 레이블 읽어와서 표시</h1>
    <svg id="myGraph"></svg><br>
    
    ticks() - 누금 간격 지정, 기본값 10 <br>
    ticks()는 모두가 지정한 값과 같은 간격이 됩니다 <br>
    tickValues()는 서로 다른 간격으로 표기합니다.<br>
    tickFormat()는 눈금에 표시할 숫자에 서식 지정합니다<br>
  
  </body>
  </html>
  ```

  

  bar3.js

  ```javascript
  /**
   * 
   */
  
  window.addEventListener("load", function(){
  	
  	var dataSet = [];
  	var labelName = [];
  	d3.csv("datas/mydata4.csv").then(function(data){
  		for(var i in data[0]) {
  			dataSet.push(data[0][i]);
  			labelName.push(i);
  		}
  		
  		
  		var svgEle = document.getElementById("myGraph");
  		var svgWidth = window.getComputedStyle(svgEle, null).getPropertyValue("width");
  		var svgHeight = window.getComputedStyle(svgEle, null).getPropertyValue("height");
  		svgWidth = parseFloat(svgWidth);
  		svgHeight = parseFloat(svgHeight);
  		
  		
  		var barElements;	//막대그래프의 막대 요소를 저장할 변수
  		var offsetX = 30;
  		var offsetY = 15;
  		var dataMax = 300;
  		var barWidth = 20;
  		var barMargin = 15;
  		
  		barElements = d3.select("#myGraph")
  		.selectAll("rect") //rect 요소를 지정
  		.data(dataSet);	//ㄷ이터를 요소에 연결
  		
  		
  		
  		barElements.enter()	//데이터 수 만큼 반복
  		.append("rect")		//데이터 수 만큼 rect 요소가 추가됨
  		.attr("class", "bar") //CSS 클래스 설정
  		.attr("height", 0)
  		.attr("width", barWidth)	//넒이 지정
  		.attr("x", function(d, i) {
  			return i * (barWidth + barMargin) + offsetX;	//X 좌표를 표시 순서 x25로 함
  		})
  		.attr("y", svgHeight - offsetY)	//Y 좌표를 계산 
  		.on("mouseover", function(){
  			d3.select(this).style("fill", "red")
  		})
  		.on("mouseout", function(){
  			d3.select(this).style("fill", "orange")
  		})
  		//에니메이션 처리
  		.transition()
  		.duration(3000)
  		.attr("y", function(d, i){
  			return svgHeight - d - offsetY;
  		})
  		.attr("height", function(d, i){
  			return d;
  		})
  		
  		barElements.enter()
  		.append("text")
  		.attr("class", "barNum")
  		.attr("x", function(d, i){
  			return i * (barWidth + barMargin)+ 10 + offsetX;
  		})
  		.attr("y", svgHeight - 5 - offsetY)
  		.text(function(d, i){
  			return d;
  		});
  		
  		//눈금을 표시하기 위한 스케일 설정
  		var yScale = d3.scaleLinear()
  		.domain([0, dataMax])
  		.range([dataMax, 0])
  		
  		//눈금의 표시 위치를 왼쪽으로 지정
  		var axis = d3.axisLeft(yScale)
  		.ticks(10)
  		.tickValues([0, 10, 20, 30, 50, 100, 1500, 200])
  		//.tickFormat(d3.format(".2f"));
  		
  		//눈금을 설정하여 표시
  		d3.select("#myGraph").append("g")
  		.attr("class", "axis")
  		.attr("transform", "translate("+ offsetX +", " + ((svgHeight-300-offsetY))+ ")")
  		.call(axis)
  		
  		d3.select("#myGraph")
  		.append("rect")
  		.attr("class", "axis_x")
  		.attr("width", 320)
  		.attr("height", 1)
  		.attr("transform", "translate("+ offsetX + ", " + (svgHeight-offsetY)+")")
  		
  		barElements.enter()
  		.append("text")
  		.attr("class", "barNum")
  		.attr("x", function(d, i){
  			return i * (barWidth + barMargin) + 10 + offsetX;
  		})
  		.attr("y", svgHeight - offsetY + 15)
  		.text(function(d, i){
  			//return d;
  			return labelName[i];
  		});
  	})
  	
  	
  	
  }, false);
  
  ```

  