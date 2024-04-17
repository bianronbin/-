<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>贵美商城</title>
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <script type="text/JavaScript">
        function multiCheck(oThis) {
            var oInput = document.getElementsByClassName("product-checkbox");
            for (var i = 0; i < oInput.length; i++) {
                oInput[i].checked = oThis.checked;
            }
        }
    </script>
</head>
<body>

<div id="container">
    <iframe id="header" runat="server" src="header.jsp" width="980" height="136" frameborder="0"
            scrolling="no"></iframe>
    <div class="catlist a_c">

        <c:if test="${not empty applicationScope.products}">
            <ul class="w20p check">
                <h3><input type="checkbox" name="checkall" onclick="multiCheck(this)"/>全选</h3>
                <c:forEach items="${applicationScope.products}" var="product">

                    <li><input type="checkbox" class="product-checkbox"/></li>

                </c:forEach>
            </ul>
            <ul class="w20p">
                <h3>商品图片</h3>
                <c:forEach items="${applicationScope.products}" var="product">

                    <li><a href="info.jsp"><img width="100px" height="100px" src="${product.imagine}"
                                                alt="${product.product_name}"/> <!-- 显示图片 -->
                    </a></li>

                </c:forEach>
            </ul>
            <ul class="w50p info">
                <h3>商品名称/出售者/联系方式</h3>
                <c:forEach items="${applicationScope.products}" var="product">

                    <!--商品名称/出售者/联系方式 -->
                    <li><a href="info.jsp">${product.product_name}</a><br/>出售者：<a
                            href="#">${product.seller_name}<br/><img src="images/contactme.gif" alt="alt"/>
                        <a href="http://localhost:8080/shop/cartController?product_id=${product.product_id}&amount=1">
                            <img src="images/addfav.gif" alt="收藏"/>收藏</a></li>

                </c:forEach>
            </ul>
            <ul class="w10p price">
                <h3>价格</h3>
                <c:forEach items="${applicationScope.products}" var="product">

                    <li>一口价：<br/>${product.product_price}</li>

                </c:forEach>
            </ul>

        </c:if>
        <c:if test="${empty applicationScope.products}">
            <p>没有找到产品。</p>
        </c:if>
    </div>
    <iframe id="footer" runat="server" src="footer.jsp" width="980" height="136" frameborder="0"
            scrolling="no"></iframe>
</div> <!--container end-->
</body>
</html>
