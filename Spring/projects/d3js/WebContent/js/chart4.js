/**
 * 
 */

window.addEventListener("load", function(){
	
	//1. 데이터 준비
	var dataSet = [300, 150, 10, 80, 230];
	d3.select("#myGraph")
		.selectAll("rect")
		.data(dataSet) //데이터 설정
		.enter()
		.append("rect")
		.attr("x", 0)
		.attr("y", function(d, i){
			return i * 30;
		})
		.attr("width", function(d, i){
			return d + "px";
		})
		.attr("height", "20px");
	
	d3.select("#updateButton")
		.on("click", function() {
			dataSet = [20, 230, 150, 10, 20];
			d3.select("#myGraph")
			.selectAll("rect")
			.data(dataSet)
			.attr("width", function(d, i){
				return d + "px";
			});
		});

}, false);
			
	



