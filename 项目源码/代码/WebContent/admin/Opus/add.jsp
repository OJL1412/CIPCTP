<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	padding-bottom: 40 px;
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
	<form action="${pageContext.request.contextPath}/OpusUploadImgServlet"
		method="post" enctype="multipart/form-data" class="definewidth m20">
		<table class="table table-bordered talbe-hover definewidth m10">
			<input type="hidden" name="operate" value="add" />
			<tr>
				<td width="10%" class="talbeleft">名称</td>
				<td><input type="text" id="title" name="name" /></td>
			</tr>

			<tr>
				<td width="10%" class="tableleft">作者</td>
				<td><input type="text" id="author" name="author" /></td>
			</tr>
			
			<tr>
   			<td width="10%" class="tableleft">作品图片</td>
   				<td>
   					<input type="file" name="img">
   				</td>
   			</tr>

			<tr>
				<td width="10%" class="tableleft">一级分类</td>
				<td><select id="tid" name="tid">
					<option></option>
				</select></td>
			</tr>

			<tr>
				<td width="10%" class="tableleft">二级分类</td>
				<td><select id="sid" name="sid">
						<option></option>
				</select></td>
			</tr>

			<tr>
				<td class="tableleft">介绍</td>
				<td><textarea name="introduce"
						style="width: 380px; height: 150px"></textarea></td>
			</tr>

			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>

		</table>

	</form>


	<script>
		//jquery程序的入口
		$(function() {
			$('#backid').click(function() {
				window.location.href = "index.jsp";
			});

			//页面加载事件
			window.onload = function() {
				//ajax技术， 页面的局部刷新$.ajax({参数名:参数值});
				$
						.ajax({
							url : "${pageContext.request.contextPath}/TypesManagerServlet?operate=query&param=json",
							type : 'GET', // 请求方式 get ， doGet
							dateType : 'json', //请求的响应数据类型    json  {"属性名" : "属性值"}
							success : function(data) { //正确 ，执行这个函数    data 就是接受请求的返回值 
								$("#tid").empty(); //将 id = tid的元素内容 清空
								var html = ""; //声明变量

								$.each(data, function(index, item) {
									html += "<option value = '" + index + "'>"
											+ item + "</option>";
								});
								$("#tid").append(html);
							}
						});
				$("#tid").change();
			}

			//当select 发生变化的时候，会触发的事情
			$("#tid").change(function() {
// 					alert("this.value = " + this.value)
					var pid = 1;
					if (this.value != '') {
						pid = this.value;
					}
					console.log("this.value=" + this.value);
					console.log(pid);
					$.ajax({
						url : "${pageContext.request.contextPath}/TypesManagerServlet?operate=query&param=json&pid="+pid,
						type : 'GET',
						dataType : 'json',
						success:function(data) {
							$("#sid").empty();
							var html = "";
							$.each(data, function(index,item) {
								html += "<option value = '" + index + "'>" + item + "</option>";
							});
							$("#sid").append(html);
						}
						
					})
						
			});
						
		});
	</script>

</body>

</html>







