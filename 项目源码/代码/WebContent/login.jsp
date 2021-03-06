<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>登录界面</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css"href="css/bootstrap-responsive.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.sorted.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/ckform.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	
	<style type="text/css">
	body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
	</style>
</head>


<body>
	<div class = "container">
	
		<form class="form-signin" method="post" action="">
			<h2 class="form-signin-heading">登陆系统</h2>
			<span style = "font-size:9px; color:red" id="show"></span>
			<input type = "text" id="username" name="username" class="input-block-level" placeholder="账号">
			<input type = "password" id="pwd" name="pwd" class="input-block-level" placeholder="密码">
			
			<p><button id="btn" class="btn btn-large btn-primary" type="button">登录</button></p>
		</form>
		
	<script type="text/javascript">
				$(function(){
				$("#btn").click(function(){
					
					var username = $("#username").val();
					var pwd = $("#pwd").val();
					
					$.ajax({
								url:"${pageContext.request.contextPath}/ShowServlet",
								type:"POST",
								data:{"username":username, "pwd":pwd},
								dataType:"json",
								success:function(data){
									if(data.msg == "ok"){
										window.location.href="admin/MyIndex.jsp";
										
									}else{
										$("#show").html(data.msg);
									}
								}
						  })
					})
			})
	</script>

</div>
</body>
</html>