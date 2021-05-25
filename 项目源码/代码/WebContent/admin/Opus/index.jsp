<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css/bootstrap-responsive.css" />
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

@media ( max-width : 980px) {
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
	<form class="form-inline definewidth m20"
		action="${pageContext.request.contextPath}/OpusManagerServlet"
		method="get">
		作品名：<input type="text" name="name" id="name"
			class="abc input-default" placeholder="请输入作品名" value="${ntName}">&nbsp;&nbsp;
		<input type="hidden" value="showpage" name="operate" />
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id = "addnew">添加作品</button>
	</form>

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
		<tr>
			<td>编号</td>
			<td>作者</td>
			<td>作品</td>
			<td>点击量</td>
			<td>上传时间</td>
			<td>图片</td>
			<td>大类</td>
			<td>小类</td>
			<td>介绍</td>
			<td>操作</td>
		</tr>
		</thead>

		<c:forEach items="${opusList}" var="nt">
			<tr>
				<td>${nt.getId()}</td>
				<td>${nt.getAuthor()}</td>
				<td>${nt.getName()}</td>
				<td>${nt.getCk()}</td>
				<td>${nt.getUtime()}</td>
				<td>
					<img width="50px" height="50px" alt="" src="${pageContext.request.contextPath}/images/${nt.getImg()}">
				</td>
				<td>${nt.getTname()}</td>
				<td>${nt.getSname()}</td>
				<td>${nt.getIntroduce()}</td>
				<td><a
					href="${pageContext.request.contextPath}/OpusManagerServlet?id=${nt.getId()}&operate=delete&name=${ntName}">删除</a>
					<a
					href="${pageContext.request.contextPath}/OpusManagerServlet?id=${nt.getId()}&operate=queryId">修改</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	
	<div class = "inline pull-right page">
		${ntCounts}条记录${ntPage}/${ntTotalPage}页
		<a href = '${pageContext.request.contextPath}/OpusManagerServlet?operate=showpage&page=${1}&name=${ntName}'>首页</a>
		<a href = '${pageContext.request.contextPath}/OpusManagerServlet?operate=showpage&page=${ntPage-1}&name=${ntName}'>上一页</a>
		<c:forEach begin = "1" end = "${ntTotalPage}" step = "1" var = "p">
			<c:if test = "${p == ntPage}">
				<span class = 'current'>${p}</span>
			</c:if>
			<c:if test = "${p != ntPage}">
				<a href = "${pageContext.request.contextPath}/OpusManagerServlet?operate=showpage&page=${p}&name=${ntName}">${p}</a>
			</c:if>
		</c:forEach>
		<a href = '${pageContext.request.contextPath}/OpusManagerServlet?operate=showpage&page=${ntPage+1}&name=${ntName}'>下一页</a>
		<a href = '${pageContext.request.contextPath}/OpusManagerServlet?operate=showpage&page=${ntTotalPage}&name=${ntName}'>最后一页</a>
	</div>


	<script>
	
		$(function() {
			$('#addnew').click(function() {
				window.location.href="add.jsp";
			});
		});
		
		function del(id) {
			if (comfirm("确定要删除吗？")) {
				var url = "index.jsp";
				window.location.href = url;
			}
		}
		
	</script>

</body>
</html>
