<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
	<title>登录成功 贵美商城</title>
	<link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
	<link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
	<script type="text/javascript">
		var countdown = 10;

		// 更新倒计时并显示在页面上
		function updateCountdown() {
			document.getElementById('countdown').innerText = countdown;
		}

		// 设置定时器，每秒更新一次倒计时
		var timer = setInterval(function(){
			countdown--; // 递减倒计时
			updateCountdown(); // 更新显示

			// 当倒计时结束时停止定时器并跳转到index.jsp
			if (countdown < 0) {
				clearInterval(timer);
				window.location.href = "/shop/index.jsp";
			}
		}, 1000);


	</script>
</head>
<body>
<div id="container">
	<iframe src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<p class="a_c lh24"><img src="./images/logo.jpg" alt="alt" /><br />
		祝贺 !!! <br />
		您已经成功登录！！！<br />
		欢迎来到 拍卖天堂<br/>
		<span id="countdown">10</span>秒后自动跳转到首页，</p>

	<iframe src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
</div><!--container	end-->
</body>
</html>		
