<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<title>my page</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="resources/css/skel.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />
<link rel="stylesheet" href="resources/css/style-noscript.css" />
<link rel="stylesheet" href="resources/css/mypagestyle.css" />
<link rel="stylesheet" href="resources/css/clndr.css" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.dropotron.min.js"></script>
<script src="resources/js/jquery.scrolly.min.js"></script>
<script src="resources/js/jquery.onvisible.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-layers.min.js"></script>
<script src="resources/js/init.js"></script>
<script src="resources/js/Chart.js"></script>
<script src="resources/js/clndr.js"></script>
<script src="resources/js/underscore-min.js"></script>
<script src="resources/js/moment-2.2.1.js"></script>
<script src="resources/js/site.js"></script>

<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<body
	style="background: url('resources/images/bg.jpg'); background-size: cover; background-position: center center; background-attachment: fixed;">
	<!-- Header -->
	<div id="header1">

		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<a href="/usshike/" id="logo">食客</a>
				</h1>
			</header>
		</div>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="/usshike/">主页</a></li>
				<li><a href="left-sidebar.html">去哪吃</a></li>
				<li><a href="right-sidebar.html">食客榜</a></li>
				<li><a href="no-sidebar.html">食客圈</a></li>
				<li><a href="no-sidebar.html">食客新闻</a></li>
				<li><a href="">美食地图</a>
					<ul>
						<li><a href="#">纽约</a></li>
						<li><a href="#">华盛顿 DC</a></li>
						<li><a href="#">匹兹堡</a></li>
						<!-- <li><a href="">And a submenu &hellip;</a>
							<ul>
								<li><a href="#">Lorem ipsum dolor</a></li>
								<li><a href="#">Phasellus consequat</a></li>
								<li><a href="#">Magna phasellus</a></li>
								<li><a href="#">Etiam dolore nisl</a></li>
							</ul></li>
						<li><a href="#">Veroeros feugiat</a></li>-->
					</ul></li>
			</ul>
		</nav>

	</div>
	<!-- start grids_of_3 -->
	<div class="grids_of_3">
		<div class="grid1_of_3">
			<div class="btn_style bg2">
				<ul>
					<li>
						<p>食客积分</p> <span>85</span>
					</li>
					<li>
						<p>本月积分</p> <span>21</span>
					</li>
				</ul>
			</div>
			<div class="chart">
				<canvas id="canvas" height="250" width="295"
					style="margin-top: 30px;"></canvas>
				<script>
					var lineChartData = {
						labels : [ "January", "February", "March", "April",
								"May", "June", "July" ],
						datasets : [ {
							fillColor : "rgba(220,220,220,0.5)",
							strokeColor : "rgba(220,220,220,1)",
							pointColor : "rgba(220,220,220,1)",
							pointStrokeColor : "#fff",
							data : [ 65, 59, 90, 81, 56, 55, 40 ]
						}, {
							fillColor : "rgba(151,187,205,0.5)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							data : [ 0, 0, 0, 0, 0, 0, 0 ]
						} ]

					}

					var myLine = new Chart(document.getElementById("canvas")
							.getContext("2d")).Line(lineChartData);
				</script>
			</div>
		</div>
		<div class="grid1_of_3 left">
			<div class="btn_style bg">
				<h4>我的话题</h4>
			</div>
			<div class="login_form"></div>
		</div>
		<div class="grid1_of_3 left">
			<div class="btn_style bg1">
				<h4>个人资料</h4>
			</div>
			<div class="grid_img1">
				<img src="resources/images/pic2.jpg" alt="" />
			</div>
			<div class="grid_user">
				<div class="grid_list">
					<div class="list_img">
						<a href="#"><img src="resources/images/user.jpg" alt="" /></a>
					</div>
					<div class="list_text">
						<h4>
							<a href="#">豆豆</a>
						</h4>
						<h6>特级食客</h6>
					</div>
				</div>
			</div>
			<div class="grids_left">
				<div class="articles_list">
					<ul>
						<li><a href="#" class="red"> <img
								src="resources/images/loc.png" alt="" /> 23
						</a></li>
						<li><a href="#" class="purple"> <img
								src="resources/images/comments.png" alt="" /> 841
						</a></li>
						<li><a href="#" class="yellow"> <img
								src="resources/images/likes.png" alt="" /> 49
						</a></li>
					</ul>
				</div>
				<div class="clear"></div>
				<div style="display: inline;">
					<div class="follow">
						<a href="#">更改密码</a>
					</div>
					<div class="follow">
						<a href="#">更换头像</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="grid1_of_3">
		<div class="btn_style bg2">
			<ul>
				<li>
					<p>goal</p> <span>85</span>
				</li>
			</ul>
		</div>
		<div class="chart"></div>
	</div>
	<div class="grid1_of_3 left">
		<div class="btn_style bg3">
			<h4>挑战食客</h4>
		</div>
		<div class="loader_main">
			<div class="buttons">
				<button id="playGame" class="bg1">食客游戏</button>
				<button onclick="location.href = 'addRestaurantPage';" class="bg2">添加餐厅</button>
				<button id="verifyRestaurant"class="bg3">验证餐厅</button>
				<button class="bg4">嗷嗷嗷</button>
			</div>
		</div>
	</div>
	<div class="grid1_of_3 left">
		<div class="cal1"></div>
	</div>
</body>
</html>