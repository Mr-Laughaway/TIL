/**
 * 
 */

window.addEventListener("load", function(){
	var dataSet = [];
	
	//1. 데이터 준비
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
	
}, false);
			
	



