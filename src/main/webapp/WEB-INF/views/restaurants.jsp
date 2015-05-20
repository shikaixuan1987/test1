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
<link rel="stylesheet" href="resources/css/filterstyle.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />
<link rel="stylesheet" href="resources/css/style-noscript.css" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.dropotron.min.js"></script>
<script src="resources/js/jquery.scrolly.min.js"></script>
<script src="resources/js/jquery.onvisible.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-layers.min.js"></script>
<script src="resources/js/init.js"></script>
<script src="resources/js/jquery.mixitup.min.js"></script>
<style type="text/css">

#portfoliolist .portfolio {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-o-box-sizing: border-box;
	display:none;
	overflow:hidden;
}
.portfolio .label {
	position: absolute;
	width: 100%;
	height:40px;
	bottom:-40px;
}
.portfolio .label-bg {
	background: black;
	width: 100%;
	height:100%;
	position: absolute;
	top:0;
	left:0;
}
.portfolio .label-text {
	color:black;
	position: relative;
	z-index:500;
	padding:5px 8px;
}
.portfolio .text-category {
	display:block;
	font-size:9px;
	font-size: 12px;
	text-transform:uppercase;
}

#filters {
	margin: 1em 0 1em 0;
	padding: 0;
	list-style: none;
	text-align: center;
}
#filters li span{
	display: block;
	padding: 5px 	10px;
	text-decoration: none;
	color: black;
	cursor: pointer;
	font-family: 'Open Sans', sans-serif;
	font-size: 0.8em;
	text-transform:uppercase;
	font-weight: 400;	
	margin: 0 0.3em;
	border:1px solid #FFD670;	
}
#filters li span.active {
	color: black;	
	font-weight: 500;
	 border:1px solid purple;	
}
#filters li span.filter:hover{
	color: purple;
    border:1px solid purple;	
}
#filters li span.active:hover{
	border: 1px solid purple;
	color: #F3F3F3;
}						  
#filters li {
	display: -webkit-inline-box;
}

</style>

<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<body>
	<!-- Header -->
	<div id="header">

		<div class="inner">
			<header>
				<h1>
					<a href="/usshike/" id="logo">食客</a>
				</h1>
			</header>
		</div>
		<input type="text" placeholder="关键字查找"
			style="font-weight: 400; font-family: 'Open Sans', sans-serif; width: 250px; height: 40px; outline: none; font-size: 0.9125em; border: none; -webkit-appearance: none; border-radius: 10px; -webkit-border-radius: 10px; -o-border-radius: 10px; -moz-appearance: none; appearance: none;"
			required> <select id="select"
			style="font-weight: 400; font-family: 'Open Sans', sans-serif; width: 250px; height: 40px; outline: none; font-size: 0.9125em; border: none; -webkit-appearance: none; border-radius: 10px; -webkit-border-radius: 10px; -o-border-radius: 10px; -moz-appearance: none; appearance: none;"
			required>
			<option value="">所在地</option>
			<option value="Pittsburgh">匹兹堡(Pittsburgh,PA)</option>
			<option value="New York">纽约(Great New York)</option>
			<option value="DC">华盛顿(Great Washington DC)</option>
		</select> 查找
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
					</ul></li>
			</ul>
		</nav>
	</div>
	<div class="container">
	<div class="portfolio-section" id="WORK">
			<div class="portfolio-section-bottom-row" id="portfolio">
			<div class="container">
		 <ul id="filters" >
						<li><span class="filter active" data-filter="app card icon web logo1">所有</span></li>
						<li><span class="filter" data-filter="app">中餐</span></li>
						<li><span class="filter" data-filter="card">西餐</span></li>
						<li><span class="filter" data-filter="icon">亚洲</span></li>
						</ul>
					<div id="portfoliolist">
					<div class="portfolio app mix_all  wow bounceIn">
						    <a href="#" class="hvr-border-fade button2">早茶</a>
					</div>				
					<div class="portfolio app mix_all  wow bounceIn" >
						     						<a href="#" class="hvr-hollow button2">麻辣</a>
					</div>		
					<div class="portfolio app mix_all  wow bounceIn" >	
						     						<a href="#" class="hvr-trim button2">川菜</a>
					</div>				
					<div class="portfolio app mix_all  wow bounceIn" >	
						<a href="#" class="hvr-overline-from-left button2">广东菜</a>
					</div>
					<div class="portfolio app mix_all  wow bounceIn" >	
						    <a href="#" class="hvr-overline-from-center button2">中式海鲜</a>
					</div>
					<div class="portfolio app mix_all  wow bounceIn" >		
						  					<a href="#" class="hvr-overline-from-right button2">东北菜</a>
					</div>			
					<div class="portfolio app mix_all  wow bounceIn" >		
						  						<a href="#" class="hvr-round-corners button2">湖南菜</a>
					</div>	
					<div class="portfolio app mix_all  wow bounceIn" >
						 	<a href="#" class="hvr-underline-from-left button2">港台</a>
					</div>	
										<div class="portfolio app mix_all  wow bounceIn" >		
						  					<a href="#" class="hvr-overline-from-right button2">所有中餐</a>
					</div>	
										<div class="portfolio icon mix_all  wow bounceIn" >
						     						<a href="#" class="hvr-hollow button2">韩国</a>
					</div>		
					<div class="portfolio icon mix_all  wow bounceIn" >	
						     						<a href="#" class="hvr-trim button2">日本</a>
					</div>				
										<div class="portfolio icon mix_all  wow bounceIn" >		
						  					<a href="#" class="hvr-overline-from-right button2">所有亚洲</a>
					</div>	
					<div class="portfolio card mix_all  wow bounceIn" >	
						<a href="#" class="hvr-overline-from-left button2">快餐</a>
					</div>
					<div class="portfolio card mix_all  wow bounceIn" >	
						    <a href="#" class="hvr-overline-from-center button2">西式海鲜</a>
					</div>
					<div class="portfolio card mix_all  wow bounceIn" >		
						  					<a href="#" class="hvr-overline-from-right button2">墨西哥</a>
					</div>			
					<div class="portfolio card mix_all  wow bounceIn" >		
						  						<a href="#" class="hvr-round-corners button2">欧洲</a>
					</div>	
										<div class="portfolio card mix_all  wow bounceIn" >		
						  					<a href="#" class="hvr-overline-from-right button2">所有西餐</a>
					</div>	
											
				</div>
						
		  
					<script type="text/javascript">
					$(function () {
						
						var filterList = {
						
							init: function () {
							
								// MixItUp plugin
								// http://mixitup.io
								$('#portfoliolist').mixitup({
									targetSelector: '.portfolio',
									filterSelector: '.filter',
									effects: ['fade'],
									easing: 'snap',
									// call the hover effect
									onMixEnd: filterList.hoverEffect()
								});				
							
							},
							
							hoverEffect: function () {
							
								// Simple parallax effect
								$('#portfoliolist .portfolio').hover(
									function () {
										$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');		
									},
									function () {
										$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');							
									}		
								);				
							
							}
				
						};
						
						// Run the show!
						filterList.init();
						
						
					});	
					</script>
			
		</div>
	  </div>
	</div>
	
	</div>
</body>
</html>