<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>后台管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div class="header">

			<div class="dl-title">
			</div>

			<div class="dl-log">欢迎您，<span class="dl-log-user">root</span>
				<a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
			</div>
		</div>
		<div class="content">
			<div class="dl-main-nav">
				<div class="dl-inform">
					<div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
				</div>
				<ul id="J_Nav" class="nav-list ks-clear">
					<li class="nav-item dl-selected">
						<div class="nav-item-inner nav-home">系统管理</div>
					</li>
					<li class="nav-item dl-selected">
						<div class="nav-item-inner nav-order">业务管理</div>
					</li>

				</ul>
			</div>
			<ul id="J_NavContent" class="dl-tab-conten">

			</ul>
		</div>
		<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
		<script type="text/javascript" src="assets/js/bui-min.js"></script>
		<script type="text/javascript" src="assets/js/common/main-min.js"></script>
		<script type="text/javascript" src="assets/js/config-min.js"></script>
		<script>
			BUI.use('common/main', function() {
				var config = [{
					id: '1',
					menu: [{
						text: '系统管理',
						items: [{
							id: '1',
							text: '公告管理',
							href: 'Notice/index.jsp'
						}, {
							id: '3',
							text: '留言管理',
							href: 'Tbl_Messages/index.jsp'
						}, {
							id: '4',
							text: '新闻管理',
							href: 'News/index.jsp'
						}, {
							id: '6',
							text: '类型管理',
							href: 'Types/index.jsp'
						},{
							id: '7',
							text: '作品管理',
							href: 'Opus/index.jsp'
						}]
					}]
				}, {
					id: '7',
					homePage: '9',
					menu: [{
						text: '业务管理',
						items: [{
							id: '9',
							text: '查询业务',
							href: 'Node/index.html'
						}]
					}]
				}];
				new PageUtil.MainPage({
					modulesConfig: config
				});
			});
		</script>
		<div style="text-align:center;">
			<p>
				<a href="http://www.mycodes.net/" target="_blank">zh</a>
			</p>
		</div>
	</body>

</html>