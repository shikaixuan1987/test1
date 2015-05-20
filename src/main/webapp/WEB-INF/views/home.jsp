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
<meta charste="utf-8">
<title>beafoodie.com</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/skel.css" />
<link rel="stylesheet" href="resources/css/style.css" />
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
<script>
	$(document)
			.ready(
					function() {
						$(".bhide").click(function() {
							$(".hideObj").slideDown();
							$(this).hide(); //.attr()
							return false;
						});
						$(".bhide2").click(function() {
							$(".container.hideObj2").slideDown();
							$(this).hide(); // .attr()
							return false;
						});

						$('.heart').mouseover(
								function() {
									$(this).find('i').removeClass('fa-heart-o')
											.addClass('fa-heart');
								}).mouseout(
								function() {
									$(this).find('i').removeClass('fa-heart')
											.addClass('fa-heart-o');
								});

						function sdf_FTS(_number, _decimal, _separator) {
							var decimal = (typeof (_decimal) != 'undefined') ? _decimal
									: 2;
							var separator = (typeof (_separator) != 'undefined') ? _separator
									: '';
							var r = parseFloat(_number)
							var exp10 = Math.pow(10, decimal);
							r = Math.round(r * exp10) / exp10;
							rr = Number(r).toFixed(decimal).toString().split(
									'.');
							b = rr[0].replace(
									/(\d{1,3}(?=(\d{3})+(?:\.\d|\b)))/g, "\$1"
											+ separator);
							r = (rr[1] ? b + '.' + rr[1] : b);

							return r;
						}

						setTimeout(function() {
							$('#counter').text('0');
							$('#counter1').text('0');
							$('#counter2').text('0');
							setInterval(function() {

								var curval = parseInt($('#counter').text());
								var curval1 = parseInt($('#counter1').text()
										.replace(' ', ''));
								var curval2 = parseInt($('#counter2').text());
								if (curval <= 397) {
									$('#counter').text(curval + 1);
								}
								if (curval1 <= 3112) {
									$('#counter1').text(
											sdf_FTS((curval1 + 20), 0, ' '));
								}
								if (curval2 <= 168) {
									$('#counter2').text(curval2 + 1);
								}
							}, 2);

						}, 500);
					});
</script>
<script type="text/javascript">
	var w, h, className;
	function getSrceenWH() {
		w = $(window).width();
		h = $(window).height();
		$('#dialogBg').width(w).height(h);
	}
	window.onresize = function() {
		getSrceenWH();
	}
	$(window).resize();
	$(function() {
		getSrceenWH();
		//显示弹框
		$('.box a').click(
				function() {
					className = $(this).attr('class');
					$('#dialogBg').fadeIn(300);
					$('#dialog').removeAttr('class').addClass(
							'animated ' + className + '').fadeIn();
				});
		//关闭弹窗
		$('.closeDialogBtn').click(function() {
			$('#dialogBg').fadeOut(300, function() {
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
		});
	});
</script>
</head>
<div id="dialogBg"></div>
<div id="dialog" class="animated">
	<div class="dialogTop">
		<a href="javascript:;" class="closeDialogBtn"><font COLOR="######"><strong>关闭</strong></font></a>
		</div>
		<h1 style="color:white; padding-left: 85px;">欢迎回来！</h1>
		<br>
		<form action="#">
		<label id="user-label2">
				<i class="fa fa-user"></i><input type="text" class="form-control" style="padding-left: 35px;width:300px;" placeholder="用户名">
				</label>
					<label id="user-label2">
				<i class="fa fa-lock"></i><input type="password" class="form-control" style=" padding-left: 35px; width:300px;"placeholder="密码">
				</label>
				<br></br>
			<button type="submit" class="float"
				style="background-color: #EF8376; width: 100px; height: 50px; position:relative; color:white; font-size:20px;">登录</button>
				
		</form>
	</div>
<body class="homepage">

	<!-- Header -->
	<div id="header">
		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<a href="/usshike/" id="logo">食客</a>
				</h1>
				<hr />
				<p>beafoodie.com</p>
			</header>
			<footer>
				<div class="box">
					<div class="button circled flipInX">
						<a href="javascript:;">登录</a>
					</div>
				</div>
			</footer>
		</div>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="/usshike/">主页</a></li>
				<li><a href="restaurants">去哪吃</a></li>
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

	<!-- Banner -->
	<section id="banner">
		<header>
			<h2>你好！食客终于等到了你！</h2>
			<p>在这里，你可以找到美味的食物，新奇的餐厅，志同道合的朋友还有为你私人订制的美食评论！</p>
		</header>
		<div style="margin-right: -15px; margin-left: -15px;">
			<div
				style="display: inline-block; position: relative; min-height: 1px; padding-right: 100px; padding-left: 100px;">
				<h3 id="counter">0</h3>
				<h4>
					<strong>认证餐厅</strong>
				</h4>
			</div>
			<div
				style="display: inline-block; position: relative; min-height: 1px; padding-right: 100px; padding-left: 100px;">
				<h3 id="counter1">0</h3>
				<h4>
					<strong>食客成员</strong>
				</h4>
			</div>
			<div
				style="display: inline-block; position: relative; min-height: 1px; padding-right: 100px; padding-left: 100px;">
				<h3 id="counter2">0</h3>
				<h4>
					<strong>精美食评</strong>
				</h4>
			</div>
		</div>
	</section>

	<!-- Carousel -->
	<section class="carousel">
		<div class="reel">

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic01.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Pulvinar sagittis congue</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic02.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Fermentum sagittis proin</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic03.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Sed quis rhoncus placerat</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic04.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Ultrices urna sit lobortis</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic05.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Varius magnis sollicitudin</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic01.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Pulvinar sagittis congue</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic02.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Fermentum sagittis proin</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic03.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Sed quis rhoncus placerat</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic04.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Ultrices urna sit lobortis</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

			<article>
				<a href="#" class="image featured"><img
					src="resources/images/pic05.jpg" alt="" /></a>
				<header>
					<h3>
						<a href="#">Varius magnis sollicitudin</a>
					</h3>
				</header>
				<p>Commodo id natoque malesuada sollicitudin elit suscipit
					magna.</p>
			</article>

		</div>
	</section>

	<!-- Main -->
	<div class="wrapper style2">

		<article id="main" class="container special">
			<a href="#" class="image featured"><img
				src="resources/images/pic06.jpg" alt="" /></a>
			<header>
				<h2>
					<a href="#">Sed massa imperdiet magnis</a>
				</h2>
				<p>Sociis aenean eu aenean mollis mollis facilisis primis ornare
					penatibus aenean. Cursus ac enim pulvinar curabitur morbi
					convallis. Lectus malesuada sed fermentum dolore amet.</p>
			</header>
			<p>Commodo id natoque malesuada sollicitudin elit suscipit. Curae
				suspendisse mauris posuere accumsan massa posuere lacus convallis
				tellus interdum. Amet nullam fringilla nibh nulla convallis ut
				venenatis purus sit arcu sociis. Nunc fermentum adipiscing tempor
				cursus nascetur adipiscing adipiscing. Primis aliquam mus lacinia
				lobortis phasellus suscipit. Fermentum lobortis non tristique ante
				proin sociis accumsan lobortis. Auctor etiam porttitor phasellus
				tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat
				integer interdum integer purus sapien. Nibh eleifend nulla nascetur
				pharetra commodo mi augue interdum tellus. Ornare cursus augue
				feugiat sodales velit lorem. Semper elementum ullamcorper lacinia
				natoque aenean scelerisque.</p>
			<footer>
				<a href="#" class="button">Continue Reading</a>
			</footer>
		</article>

	</div>

	<!-- Features -->
	<div class="wrapper style1">

		<section id="features" class="container special">
			<header>
				<h2>Morbi ullamcorper et varius leo lacus</h2>
				<p>Ipsum volutpat consectetur orci metus consequat imperdiet
					duis integer semper magna.</p>
			</header>
			<div class="row">
				<article class="4u special">
					<a href="#" class="image featured"><img
						src="resources/images/pic07.jpg" alt="" /></a>
					<header>
						<h3>
							<a href="#">Gravida aliquam penatibus</a>
						</h3>
					</header>
					<p>Amet nullam fringilla nibh nulla convallis tique ante proin
						sociis accumsan lobortis. Auctor etiam porttitor phasellus tempus
						cubilia ultrices tempor sagittis. Nisl fermentum consequat integer
						interdum.</p>
				</article>
				<article class="4u special">
					<a href="#" class="image featured"><img
						src="resources/images/pic08.jpg" alt="" /></a>
					<header>
						<h3>
							<a href="#">Sed quis rhoncus placerat</a>
						</h3>
					</header>
					<p>Amet nullam fringilla nibh nulla convallis tique ante proin
						sociis accumsan lobortis. Auctor etiam porttitor phasellus tempus
						cubilia ultrices tempor sagittis. Nisl fermentum consequat integer
						interdum.</p>
				</article>
				<article class="4u special">
					<a href="#" class="image featured"><img
						src="resources/images/pic09.jpg" alt="" /></a>
					<header>
						<h3>
							<a href="#">Magna laoreet et aliquam</a>
						</h3>
					</header>
					<p>Amet nullam fringilla nibh nulla convallis tique ante proin
						sociis accumsan lobortis. Auctor etiam porttitor phasellus tempus
						cubilia ultrices tempor sagittis. Nisl fermentum consequat integer
						interdum.</p>
				</article>
			</div>
		</section>

	</div>

	<!-- Footer -->
	<div id="footer">
		<div class="container">
			<div class="row">

				<!-- Tweets -->
				<section class="4u">
					<header>
						<h2 class="icon fa-twitter circled">
							<span class="label">Tweets</span>
						</h2>
					</header>
					<ul class="divided">
						<li>
							<article class="tweet">
								Amet nullam fringilla nibh nulla convallis tique ante sociis
								accumsan. <span class="timestamp">5 minutes ago</span>
							</article>
						</li>
						<li>
							<article class="tweet">
								Hendrerit rutrum quisque. <span class="timestamp">30
									minutes ago</span>
							</article>
						</li>
						<li>
							<article class="tweet">
								Curabitur donec nulla massa laoreet nibh. Lorem praesent montes.
								<span class="timestamp">3 hours ago</span>
							</article>
						</li>
						<li>
							<article class="tweet">
								Lacus natoque cras rhoncus curae dignissim ultricies. Convallis
								orci aliquet. <span class="timestamp">5 hours ago</span>
							</article>
						</li>
					</ul>
				</section>

				<!-- Posts -->
				<section class="4u">
					<header>
						<h2 class="icon fa-file circled">
							<span class="label">Posts</span>
						</h2>
					</header>
					<ul class="divided">
						<li>
							<article class="post stub">
								<header>
									<h3>
										<a href="#">Nisl fermentum integer</a>
									</h3>
								</header>
								<span class="timestamp">3 hours ago</span>
							</article>
						</li>
						<li>
							<article class="post stub">
								<header>
									<h3>
										<a href="#">Phasellus portitor lorem</a>
									</h3>
								</header>
								<span class="timestamp">6 hours ago</span>
							</article>
						</li>
						<li>
							<article class="post stub">
								<header>
									<h3>
										<a href="#">Magna tempus consequat</a>
									</h3>
								</header>
								<span class="timestamp">Yesterday</span>
							</article>
						</li>
						<li>
							<article class="post stub">
								<header>
									<h3>
										<a href="#">Feugiat lorem ipsum</a>
									</h3>
								</header>
								<span class="timestamp">2 days ago</span>
							</article>
						</li>
					</ul>
				</section>

				<!-- Photos -->
				<section class="4u">
					<header>
						<h2 class="icon fa-camera circled">
							<span class="label">Photos</span>
						</h2>
					</header>
					<div class="row 25% no-collapse">
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic10.jpg" alt="" /></a>
						</div>
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic11.jpg" alt="" /></a>
						</div>
					</div>
					<div class="row 25% no-collapse">
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic12.jpg" alt="" /></a>
						</div>
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic13.jpg" alt="" /></a>
						</div>
					</div>
					<div class="row 25% no-collapse">
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic14.jpg" alt="" /></a>
						</div>
						<div class="6u">
							<a href="#" class="image fit"><img
								src="resources/images/pic15.jpg" alt="" /></a>
						</div>
					</div>
				</section>

			</div>
			<hr />
			<div class="row">
				<div class="12u">

					<!-- Contact -->
					<section class="contact">
						<header>
							<h3>Nisl turpis nascetur interdum?</h3>
						</header>
						<p>Urna nisl non quis interdum mus ornare ridiculus egestas
							ridiculus lobortis vivamus tempor aliquet.</p>
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span
									class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span
									class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span
									class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-pinterest"><span
									class="label">Pinterest</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span
									class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span
									class="label">Linkedin</span></a></li>
						</ul>
					</section>

					<!-- Copyright -->
					<div class="copyright">
						<ul class="menu">
							<li>&copy; Untitled. All rights reserved.</li>
							<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>

				</div>

			</div>
		</div>
	</div>

</body>
</html>
