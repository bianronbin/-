<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>贵美商城</title>
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <script type="text/JavaScript">
        var strHome = 'http://www.gmgw.com';

        function addFav() {
            switch (getNav()) {
                case 1:
                    window.external.addFavorite(strHome, '贵美商城');
                    break;
                case 2:
                    window.sidebar.addPanel('贵美商城', strHome, '');
                    break;
                case 0:
                    alert("加入收藏失败");
                    break;
            }

            function getNav() {
                if (navigator.userAgent.indexOf("MSIE") != -1) return 1;
                if (navigator.userAgent.indexOf("Firefox") != -1) return 2;
                return 0;
            }
        }

        function setHome(oThis) {
            oThis.style.behavior = 'url(#default#homepage)';
            oThis.setHomePage(strHome);
            return false;
        }

        function showTime() {
            now = new Date;
            document.write(now.getFullYear() + "年" + (now.getMonth() + 1) + "月" + now.getDate() + "日" + now.getHours() + "点" + now.getMinutes() + "分");

        }
    </script>
</head>
<body>
<div id="header">
    <div id="logo"></div>
    <div class="menu">
        <ul>
            <li class="pic pic1"></li>
            <li class="txt"><a href="buy.jsp" target="_parent">购物车</a></li>
            <li class="pic pic2"></li>
            <li class="txt"><a href="help.jsp" target="_parent">帮助中心</a></li>
            <li class="pic pic3"></li>
            <li class="txt"><a href="JavaScript:void(0);" onclick="addFav();">加入收藏</a></li>
            <li class="pic pic4"></li>
            <li class="txt"><a href="JavaScript:void(0);" onclick="setHome(this);">设为首页</a></li>
            <li class="pic btn txt"><a href="login.jsp" target="_parent">登录</a></li>
            <li class="pic btn txt"><a href="register.jsp" target="_parent">注册</a></li>
        </ul>
    </div>

    <!--menu end-->
    <div class="f_r w62p">
        <c:choose>
            <c:when test="${empty username}">
                <li class="txt hello">你好，欢迎访问贵美商城！
                    <script type="text/javascript">showTime();</script>
                </li>
            </c:when>
            <c:otherwise>
                <li class="txt hello">你好，${username}，欢迎访问贵美商城！
                    <script type="text/javascript">showTime();</script>
                </li>
            </c:otherwise>
        </c:choose>

    </div>
    <div class="nav f_l w100p">
        <ul>
            <li><a href="index.jsp" target="_parent">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a></li>
            <c:if test="${not empty applicationScope.categories}">
                <c:forEach items="${applicationScope.categories}" var="category">
                    <!-- 在href中返回 category_id,保存到param中-->
                    <li><a href="catlist.jsp?category_id=${category.category_id}"
                           target="_parent">${category.category_name}</a></li>
                </c:forEach>
            </c:if>
            <li><a href="help.jsp" target="_parent">帮助中心</a></li>
            <li><a href="help.jsp" target="_parent">免费开店</a></li>
            <li><a href="help.jsp" target="_parent">全球咨询</a></li>
        </ul>
    </div> <!--nav end-->
</div> <!--header end-->
</body>
</html>
