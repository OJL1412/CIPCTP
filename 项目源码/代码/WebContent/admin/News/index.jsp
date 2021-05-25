<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻管理</title>

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
	<form class="form-inline definewidth m20" 
		action="${pageContext.request.contextPath}/NewsManagerServlet" method="get">  
		
		新闻内容:<input type="text" name="content" id="content"
			class="abc input-default" placeholder="请输入新闻内容" value="${newsContent}">
			&nbsp;&nbsp;  
	
		<input type="hidden" value="showpage" name="operate" />
   	 
   		<button type="submit" class="btn btn-primary" id="selectnew">查询新闻</button>
   		&nbsp;&nbsp; 
    	<button type="button" class="btn btn-success" id="addnew">添加新闻</button>
	</form>
	
	<table class="table table-bordered table-hover definewidth m10" >
    	<thead>
    		<tr>
        		<td>编号</td>
       	 		<td>标题</td>
        		<td>作者</td>
        		<td>类型</td>
        		<td>内容</td>
        		<td>相关图片</td>
        		<td>发布时间</td>
        		<td>点击量</td>
        		<td>操作</td>
   			</tr>
    	</thead>
    	
    	<c:forEach items="${newsList}" var="n">						
    		<tr>
    			<td>${n.getId()}</td>
    			<td>${n.getTitle()}</td>
    			<td>${n.getAuthor()}</td>
    			<td>${n.getState() == 1? "行业动态" : "新闻资讯"}</td>
    			<td>${n.getContent()}</td>
    			<td>
					<img width="50px" height="50px" alt="" src="${pageContext.request.contextPath}/Images/${n.getImg()}">
				</td>
    			<td>${n.getPubdate()}</td>
    			<td>${n.getCk()}</td>
    			<td> 
    				<a href="${pageContext.request.contextPath}/NewsManagerServlet?id=${n.getId()}&operate=delete">删除</a>
					<a href="${pageContext.request.contextPath}/NewsManagerServlet?id=${n.getId()}&operate=queryId">修改</a>
				</td>    		
    		</tr>
    	</c:forEach>
    </table>
	    
	<div class="inline pull-right page">
        ${newsCounts} 条记录 ${newsPage}/${newsTotalPage}页  
        <a href='${pageContext.request.contextPath}/NewsManagerServlet?operate=showpage&page=${newsPage-1}&content=${newsContent}'>上一页</a>
        <c:forEach begin="1" end="${newsTotalPage}" step="1" var="p">
        			<c:if test="${p == newsPage}">
        				<span class = 'current'>${p}</span>
        			</c:if>
        			
        			<c:if test="${p != newsPage}">
        				<a href="${pageContext.request.contextPath}/NewsManagerServlet?operate=showpage&page=${p}&content=${newsContent}">${p}</a>
        			</c:if>
        </c:forEach>
        
        <a href="${pageContext.request.contextPath}/NewsManagerServlet?operate=showpage&page=${newsPage+1}&content=${newsContent}">下一页</a>
        <a href="${pageContext.request.contextPath}/NewsManagerServlet?operate=showpage&page=${newsTotalPage}&content=${newsContent}">最后一页</a>
   	</div>

   	
<script>
	$(function() {
			$('#addnew').click(function() {
			window.location.href = "add.jsp";
		});
});


	function del(id) {
			if (confirm("确定要删除吗？")) {
			var url = "admin/News/index.jsp";
			window.location.href = url;
		}
}
</script>

  </body>
</html>
