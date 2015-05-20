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
<title>add restaurant</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="resources/css/skel.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/style-desktop.css" />
<link rel="stylesheet" href="resources/css/style-noscript.css" />
<link rel="stylesheet" href="resources/css/mypagestyle.css" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery.dropotron.min.js"></script>
<script src="resources/js/jquery.scrolly.min.js"></script>
<script src="resources/js/jquery.onvisible.min.js"></script>
<script src="resources/js/skel.min.js"></script>
<script src="resources/js/skel-layers.min.js"></script>
<script src="resources/js/init.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#select').css('color', 'gray');
		$('#select').change(function() {
			var current = $('#select').val();
			if (current != 'null') {
				$('#select').css('color', 'black');
			} else {
				$('#select').css('color', 'gray');
			}
		});
	});
</script>

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
	<div style="margin-left: auto; margin-right: auto; width: 33%">
		<div class="grid2_of_3">
			<div class="btn_style bg">
				<h4>添加餐厅</h4>
			</div>
			<div class="login_form">
				<form id="restaurantForm">
					<span>中文名</span> <input type="text" placeholder="新龙门" required>
					<span>英文名</span> <input type="text" placeholder="New Gragon"
						required> <span>电话</span> <input type="tel"
						pattern="[0-9]{10}" placeholder="2462731822"
						title="Please input phone number!" required/> <span>地址1</span> <input
						type="text" placeholder="Adress1" required> <span>地址2</span>
					<input type="text" placeholder="Adress2" required> <span>城市</span>
					<input type="text" placeholder="City" required> <span>选择所在州</span><select
						id="select" required>
						<option value="">Please select</option>
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select>
				</form>
				<button type="submit" form="restaurantForm"
					style="background: #62AE7B; font-family: 'Open Sans', sans-serif; cursor: pointer; width: 88%; height: 50px; border: none; outline: none; margin-top: 20px; padding: 20px; font-size: 1em; font-weight: 200; color: #ffffff; border-radius: 10px; -webkit-border-radius: 10px; -moz-border-radius: 10px; -o-border-radius: 10px; box-shadow: inset 0px 1px 0 rgba(255, 255, 255, 0.28); -webkit-box-shadow: inset 0px 1px 0 rgba(255, 255, 255, 0.28); -moz-box-shadow: inset 0px 1px 0 rgba(255, 255, 255, 0.28); -o-box-shadow: inset 0px 1px 0 rgba(255, 255, 255, 0.28); -webkit-transition: all 0.3s ease-in-out; -moz-transition: all 0.3s ease-in-out; -o-transition: all 0.3s ease-in-out; transition: all 0.3s ease-in-out;" value="Submit">提交</button>
			</div>
		</div>
	</div>
	

</body>
</html>