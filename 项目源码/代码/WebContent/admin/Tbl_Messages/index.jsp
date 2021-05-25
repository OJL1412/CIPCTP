<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		action="${pageContext.request.contextPath}/Tbl_MessagesServlet"
		method="get">
		留言内容： <input type="text" name="content" id="content"
			class="abc input-default" placeholder="请输入内容" value="${msgContent}">&nbsp;&nbsp;
		<input type="hidden" value="showpage" name="operate" />
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">添加留言</button>
	</form>
	
	
	
	
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>电话号码</td>
				<td>留言内容</td>
				<td>留言日期</td>
				<td>操作</td>
			</tr>
		</thead>

		<c:forEach items="${messageList}" var="nt">
			<tr>
				<td>${nt.getId()}</td>
				<td>${nt.getName() }</td>
				<td>${nt.getPhone() }</td>
				<td>${nt.getContent()}</td>
				<td>${nt.getMtime()}</td>
				<td><a
					href="${pageContext.request.contextPath}/MessagesManagerServlet?id=${nt.getId()}&operate=delete">删除</a>
					<a
					href="${pageContext.request.contextPath}/MessagesManagerServlet?id=${nt.getId()}&operate=queryId">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="inline pull-right page">
		${msgCounts} 条记录 ${msgPage}/${msgTotalPage} 页 
		<a href='${pageContext.request.contextPath}/MessagesManagerServlet?operate=showpage&page=${msgPage-1}&content=${msgContent}'>上一页</a> 
		<c:forEach begin="1" end="${msgTotalPage}" step="1" var="p">
			<c:if test="${p == msgPage}">
				<span class='current'>${p}</span>
			</c:if>
			<c:if test="${p != msgPage }">
				<a href="${pageContext.request.contextPath}/NoticesManagerServlet?operate=showpage&page=${p}&content=${msgContent}">${p}</a>
			</c:if>
		</c:forEach>
		<a href='${pageContext.request.contextPath}/MessagesManagerServlet?operate=showpage&page=${msgPage+1}&content=${msgContent}'>下一页</a> 
		<a href='${pageContext.request.contextPath}/MessagesManagerServlet?operate=showpage&page=${msgTotalPage}&content=${msgContent}'>最后一页</a>
	</div>
</body>
</html>
<script>
	$(function() {
		$('#addnew').click(function() {
			window.location.href = "add.jsp";
		});
	});

	function del(id) {
		if (confirm("确定要删除吗？")) {
			var url = "index.jsp";
			window.location.href = url;
		}
	}
</script>