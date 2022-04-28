/**
 * 
 */
 $(function(){
 $('#formsubmit').on('click',function(){
	postAjax();
	return false;
	})
	/*formsubmit 이라는 id의 버튼을 클릭시에 함수 동작*/
})
function postAjax(){
	/* Ajax를 보내기 위한 함수*/
	
	var title = $("#title").val();
	var content = $("#content").val();
	
	var  inputData = {
		"Title":title,
		"Content":content
	};/*데이터를 보낼 때 그냥 보내면 에러 발생. JSON.stringify() 사용해야 함.*/
	
	/* form.serialize 를 json형식으로 바꿔서 보내야 하는데 모르겟음*/
	
	$.ajax({
		type:"post", /*데이터 타입*/
		url:"/board",	/*보낼 url*/
		data:JSON.stringify(inputData),
		 /* 
		 	JSON.stringify – 객체를 JSON으로 바꿔줌
			JSON.parse – JSON을 객체로 바꿔쥼
		  */
		dataType:'json', /* 보내고 받는 데이터 타입*/
		contentType:'application/json', /*없을 경우 405 에러 발생*/
		/* 
			contentType으로 application/json 과 application/x-www-form-urlencoded 가 존재함.
			
			contentType:'application/x-www-form-urlencoded'
			js의 ajax를 통해서 json을 보낼경우 contentType을 따로 기입하지 않으면 디폴트값인  
			application/x-www-form-urlencoded 로 전송됨.
			이경우 전송되는 데이터의 페이로드 값은 "key=value&key2=value2" 형태를 가짐.
			
			contentType:'application/json'
			Android나 IOS앱을 위한 RestAPI를 개발하는 경우 사용되며 HTTP Request Message의 Payload를 보내는 것으로
			데이터 페이로드는 {"key":"value","key2":"value2"} 의 형태로 json객체가 될 수 있음.
			정리하면, 클라이언트에서 Content-Type을 application/json로 세팅해서 데이터를 송신하고, 
			서버에서는 @RequestBody를 사용해서 데이터를 받도록 코드를 작성하면 Json 데이터를 송수신할 수 있는 상태가 된다.
		*/
		success:function(vo){
			console.log(vo);
			alert("성공");
		},
		 error: function(error){
	       console.log(error);
	    }
		
		
	});
}
