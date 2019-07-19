/**
 * 
 */

var barElements;

window.addEventListener("load", function(){
	
	d3.selectAll("button").on("click", function(){
		var csvFile = this.getAttribute("data-src");
		
		//CSV 파일을 불러와 그래프 표시
		var dataSet = [];
		d3.csv(csvFile).then(function(data){
			for(var i = 0; i < data.length; i++) {
				dataSet.push(data[i]["상품A"]);
			}
			
			d3.select("#myGraph")
			.selectAll("rect").remove();
			
			//그래프 그리기
			barElements = d3.select("#myGraph")
			.selectAll("rect")
			.data(dataSet)
			
			barElements
			.enter() //데이터 갯수만큼 반복
			.append("rect") //데이터 갯수만큼 rect 요소가 추가됨
			.attr("class", "bar")
			.attr("width", function(d, i){
				return d;
			})
			.attr("height", 20)
			.attr("x", 0)
			.attr("y", function(d, i){
				return i * 25;
			})
			.attr("width", function(d, i){
				return d;
			});
			
			barElements
			.exit() //삭제 대사 요소 추출
			.remove();
			
		});
	});
	
	

});
			
	



