/**
 * map.js
 */
var bDebug = true;

var g_map = null;
var g_overlay = null;
var g_stations = [];
var g_cctvs = [];



window.addEventListener("load", function(){
	
	loadMap();
	
	addBtnEvent();
	addMapEvent();
	
	
	
}, false);





function loadMap() {
	kakao.maps.load(function() {
		debug("maps.load");
		setTimeout(function(){
			loadSpot()
		}, 500);
	});
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.50121991746371, 127.03946043730475), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	g_map = new kakao.maps.Map(mapContainer, mapOption); 
	
	
}



function addBtnEvent() {
	
	$('#map_type_base').children().each(function(i){
		this.addEventListener("click", function(){
			
			var changeMaptype;
			switch($(this).html()) {
			case 'Roadmap' :
				changeMaptype = kakao.maps.MapTypeId.ROADMAP;
				break;
			case 'Skyview' :
				changeMaptype = kakao.maps.MapTypeId.SKYVIEW;
				break;
			case 'Hybrid' :
				changeMaptype = kakao.maps.MapTypeId.HYBRID;
				break;
			}
			g_map.setMapTypeId(changeMaptype);
		}, false);
		
	});
	
	
	$('#map_type_overlay').children().each(function(i){
		this.addEventListener("click", function(){
			
			if(g_overlay != null) {
				 g_map.removeOverlayMapTypeId(g_overlay);
			}
			
			switch($(this).html()) {
			case 'Roadview' :
				g_overlay = kakao.maps.MapTypeId.ROADVIEW;
				break;
			case 'Traffic' :
				g_overlay = kakao.maps.MapTypeId.TRAFFIC;
				break;
			case 'Use District' :
				g_overlay = kakao.maps.MapTypeId.USE_DISTRICT;
				break;
			default:
				return;
			}
			g_map.addOverlayMapTypeId(g_overlay);
		}, false);
		
	});
}


function addMapEvent() {
	kakao.maps.event.addListener(g_map, 'idle', function() {
	    loadSpot();
	});
}



function loadSpot() {
	let mapBounds = g_map.getBounds();
	let latLngNE = mapBounds.getNorthEast();
	let latLngSW = mapBounds.getSouthWest();
	
	var bounds = {
        left : latLngSW.getLng() - 0.002,
        top : latLngNE.getLat() + 0.002,
        right : latLngNE.getLng() + 0.002,
        bottom : latLngSW.getLat() - 0.002
    };
	
	debug(bounds);


	//경찰서 가져오기
    $.ajax({
        url: 'apis/getStations',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function(data){
        	drawSpot(data, 'station');
        },
        data: JSON.stringify(bounds)
    });
    
    //CCTV 가져요기 (범위가 너무 크면 가져오지 않는다)
    //안내 배너 띄워야 할 듯
    if(g_map.getLevel() < 7) {
	    $.ajax({
	        url: 'apis/getCCTVs',
	        type: 'post',
	        dataType: 'json',
	        contentType: 'application/json',
	        success: function(data){
	        	drawSpot(data, 'cctv');
	        },
	        data: JSON.stringify(bounds)
	    });
    }
	
	
}


function drawSpot(list, type ){
	
	//그려놓은 모든 방법시설을 삭제한다
	if(type == 'station') {
		g_stations.forEach(function(d, i){ d.setMap(null)	});
		for(var i = g_stations.length; i > 0; i--) { g_stations.pop(); /*g_stations = [];*/ }
	} else {
		g_cctvs.forEach(function(d, i){ d.setMap(null)	});
		for(var i = g_cctvs.length; i > 0; i--) { g_cctvs.pop(); /*g_cctvs = [];*/ }

	}
	
	//새로 그린다
	list.forEach(function(d, i){
		let colorStationStroke = 'blue'
		let colorStationFill = 'blue'
		let colorCCTVStroke = 'magenta'
		let colorCCTVFill = 'magenta'

		var circle = new kakao.maps.Circle({
			center : new kakao.maps.LatLng(d.latitude, d.longitude),  // 원의 중심좌표 입니다 
			radius: type == 'station' ? 200 : Math.ceil(Math.sqrt(d.count) * 10), // 미터 단위의 원의 반지름입니다 
			strokeWeight: type == 'station'? 2 : 1, // 선의 두께입니다 
			strokeColor: type == 'station' ? colorStationStroke : colorCCTVStroke, // 선의 색깔입니다
			strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			strokeStyle: 'solid', // 선의 스타일 입니다
			fillColor: type == 'station' ? colorStationFill : colorCCTVFill, // 채우기 색깔입니다
			fillOpacity: 0.5  // 채우기 불투명도 입니다   
		}); 

		// 지도에 원을 표시합니다 
		circle.setMap(g_map); 

		if(type == 'station') {
			g_stations.push(circle);
		} else {
			g_cctvs.push(circle);
		}

	});
}


function debug(obj) {
	if(bDebug ) {
		console.log(obj);
	}
}




