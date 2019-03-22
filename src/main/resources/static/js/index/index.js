function joinRoom(){
	var url = "/user/joinRoom/" + roomid;
	alert(roomid);
	$.ajax({
		type: "GET",
		url: url,
		dataType: "json",
		 success: function(data, status, xhr){  
		        console.log(data);//返回值  
		        console.log(status);//状态  
		        console.log(xhr);//obj  
		        console.log(xhr.getResponseHeader("Content-Type"));//application/octet-stream  
		        console.log(xhr.getResponseHeader("Center-Length"));//null  
		    }
	});
}