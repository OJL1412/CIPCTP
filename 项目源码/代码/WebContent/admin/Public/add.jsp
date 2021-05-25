<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>添加用户登录信息</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

	 <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }


        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
        </style>      
</head>
<body>
		<form action="${pageContext.request.contextPath}/UserInfoManagerServlet" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
		<input type="hidden" name="operate" value="add"/>
		
		
		<tr>
			<td width="10%" class="tableleft">用户名</td>
			<td><input type="text" name="username"/></td>
		</tr>
		
		
		<tr>
			<td width="%10" class="tableleft">密码</td>
			<td><input type="text" name="pwd"/></td>
		</tr>
		
		
		<tr>
			<td width="%10" class="tableleft">联系方式</td>
			<td><input type="text" name="phone"/></td>
		</tr>
		
		
		<tr>
			<td width="%10" class="tableleft">角色</td>
			<td>
				<select name="role_id">
						<option value="1">管理员</option>
						<option value="2">普通用户</option>
				</select>
			</td>
		</tr>
		
		
		<tr>
			<td class="tableleft"></td>
			<td>
				<button type="submit" class="btn btn-primary" type="button">保存</button>
				&nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
			</td>
		</tr>
	</table>
</form>


<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });

    });
</script>

</body>
</html>