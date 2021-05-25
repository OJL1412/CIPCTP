<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改信息</title>

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
<form action="${pageContext.request.contextPath}/NewsManagerServlet" method="post" class="definewidth m20">
		<input type="hidden" name="id" value="${news.getId()}" />
		<table class="table table-bordered table-hover ">
   	
   		<tr>
       	 	<td width="10%" class="tableleft">标题</td>
       	 	<td><input type="text" id="title" name="title" value=${news.getTitle()}></td>
    	</tr>
    
     
     	<tr>
        	<td width="10%" class="tableleft">作者</td>
        	<td><input type="text" id="author" name="author" value=${news.getAuthor()}></td>
    	</tr>
     
     
   		<tr>
        	<td width="10%" class="tableleft">类型</td>
        	<td>
        		<select name="state">
        				<option value="1">行业资讯</option>
        				<option value="2">新闻资讯</option>
        		</select>
        	</td>
    	</tr>
    
  
    	<tr>
     		<td width="10%" class="tableleft">内容</td>
        	<td><textarea name="content" style="width:380px; height:150px">${news.getContent()}</textarea>
        	</td>
    	</tr>
  

		<tr>
   			<td width="10%" class="tableleft">相关图片</td>
   			<td>
   				<input type="file" name="img">
   			</td>
   		</tr>


		<tr>
       		<td width="10%" class="tableleft">点击量</td>
        	<td><input type="text" id="ck" name="ck" value=${news.getCk()}></td>
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