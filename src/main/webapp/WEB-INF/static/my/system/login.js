function checkFields(loginForm){
	email = $("#userName").val();
	var emailExp = /^[\w\-\.\+]+\@nokia(-sbell)?\.com$/;
	if (email.match(emailExp)){
       return true;
   }else{
	   $("#messageInfo").css('visibility','visible').fadeIn().removeClass('hidden');
	   $("#error").text("无效的Nokia邮箱");
	   return false;
   }
	
}