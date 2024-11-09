

// let data = "https://zylalabs.com/api/1751/container+tracking+api/1367/create+request?blContainersRef="+$("#a").val()+
// "&shippingLine=" + $("#b").val();

$(function(){

	$('#submitBtn').on('click',init);
	
});

function init(){
	console.log("잘되고있는가?");
	console.log($("#a").val());
	console.log(data);
	var blContainersRef = $("#a").val(); // bl 컨테이너 번호
 	 var shippingLine = $("#b").val(); // 회사 이름

	      // URL 생성
      var url = "https://zylalabs.com/api/1751/container+tracking+api/1367/create+request?blContainersRef=" 
	          + encodeURIComponent(blContainersRef) 
	          + "&shippingLine=" 
	          + encodeURIComponent(shippingLine);
	      
	      console.log(url); // 생성된 URL을 콘솔에 출력

	var settings = {
	"url": url,
	"method": "POST",
	"timeout":5000,
	"headers": {
	    "Authorization": "Bearer 5430|iBLKKQJEvL6isVVwBnSTsopaMwhDQKPhTYKeg2sM"
	}
	};

	$.ajax(settings).done(function (response) {
	console.log(response);
	console.log("잘되는가?");
	console.log($("#a").val());
	console.log($("#b").val());
	init2(response);
	});


	
	
}
function init2(id){

	var settings = {
	"url": "https://zylalabs.com/api/1751/container+tracking+api/1368/retrieve+response?requestId="+id,
	"method": "GET",
	"timeout": 5000,
	"headers": {
	    "Authorization": "Bearer 5430|iBLKKQJEvL6isVVwBnSTsopaMwhDQKPhTYKeg2sM"
		}
	};

	$.ajax(settings).done(function (response) {
	console.log(response);
	});

}


