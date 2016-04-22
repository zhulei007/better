<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<!-- im_start-->
<!-- 
<script type="text/javascript" src="im/main.js"></script>
<link rel="stylesheet" type="text/css" href="im/css/conversation.css" />
 -->
<!-- im_end -->
<script type="text/javascript">

	$(document).ready(function() {
		$("#b01").click(function() {
		alert(1);

			$.ajax({
				type:"get",
				url:"/betterssm/IOSLogin.do?act=login&phoneNo=13088888881&password=000000",
				dataType:"json",
				success:function(data){
				
				alert(data.result.phoneNo);
				}
	
			});
		});
	});

	/*融云IM插件_初始化*/
	/*
	 WebIMWidget.init(config);
	
	 $(function(){
		 WebIMWidget.init({
			 appkey:"qd46yzrf47ycf",
			 token:"****"
		 });
	 });
	/**
	 * 注册
	 * 手机号\密码
	 * 首先获得新用户的token
	 */
	 
	function reg() {

		$.ajax({
			type : "get",
			url : "/betterssm/IOSLogin.do?act=reg&phoneNo=13088888882&password=000000",
			dataType : "json",
			success : function(data) {

				alert(data.token);
			}

		});

	};
	
</script>
</head>
<body>
<input id="b01" type="button" value="getIOS">
<input onclick="reg();"  type="button" value="IMNToken">
<div id="myDiv"></div>
	good!
	<!-- 
	<rong-widget></rong-widget>
	 -->
</body>
</html>