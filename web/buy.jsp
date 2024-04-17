<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>贵美商城-商品购买页</title>
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <script type="text/JavaScript" defer="true">
        //添加地址
        window.addEventListener('load', function () {
            // 监听message事件
            window.addEventListener('message', function (event) {
                // 检查发件人是否是的子窗口
                if (event.origin !== 'http://localhost:8080/shop/address.jsp') {
                    // 如果不是预期的源，则拒绝接收消息
                    return;
                }
                // 获取从子窗口发送来的地址信息
                var address = event.data;
                // 将地址信息设置到输入框中
                document.getElementById('address').value = address;
            }, false);
        });

        function openWindow() {
            var newWindow = window.open("address.jsp", "_blank", "width=340,height=270");
        }

        window.addEventListener('message', function (event) {
            var address = event.data;
            document.getElementById("address").value = address;
        }, false);


    </script>
</head>
<body>

<c:set var="totalPrice" value="0.0" scope="session"/>
<div id="container">
    <iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
    <div class="buy">
        <h4><img src="images/mycart.gif" alt="alt"/> <a href="#">全场运费一律2元</a> <a href="#" class="b"
                                                                                        onclick="JavaScript:window.open('calc.jsp','计算器','width=200,height=200,toolbar=no,scrollbars=no,menubar=no,screenX=100,screenY=100')">简易计算器</a>
        </h4>
        <table class="buy" cellpadding="0" cellspacing="0">
            <tbody id="priceTable">
            <tr class="buytitle">
                <td colspan="6" class="b">确认商品价格与交易条件</td>
            </tr>
            <tr>
                <td class="w364 b">&nbsp;&nbsp;&nbsp;&nbsp;商品名</td>
                <td class="w100 b">原价</td>
                <td class="w100 b">优惠价</td>
                <td class="w100 b">打折</td>
                <td class="w100 b">数量</td>
                <td class="w40 b">保存</td>
                <td class="w81 b">删除</td>
            </tr>
            <c:if test="${not empty sessionScope.cart}">
                <!--totalPrice为算上折扣后的总价格，初始化为0-->
                <c:set var="totalPrice" value="0.0" scope="session"/>
                <!--totalSavings为减少的价钱，初始化为0-->
                <c:set var="totalSavings" value="0.0" scope="session"/>

                <c:forEach items="${sessionScope.cart}" var="cart">
                    <tr class="h26 blue">

                        <td><a href="info.jsp"
                               title="${cart.product_name}">&nbsp;&nbsp;&nbsp;&nbsp;${cart.product_name}</a></td>
                        <td><span class="c9">￥${cart.product_price}</span></td>

                        <c:if test="${cart.discounts==1}">
                            <!--判断是否打折，1为打折-->
                            <td><span class="red">￥${cart.discount_price}</span></td>
                            <td><span class="black">${cart.discount}折</span></td>
                        </c:if>

                        <c:if test="${cart.discounts==0}">
                            <td><span class="red">&nbsp;</span></td>
                            <td><span class="black">无折扣</span></td>
                        </c:if>
                        <!--将每个商品价钱加到totalPrice中-->
                        <c:set var="totalPrice" value="${totalPrice + cart.product_price}" scope="session"/>

                        <c:if test="${cart.discounts==1}">
                            <c:set var="totalPrice"
                                   value="${totalPrice - cart.product_amount*(cart.product_price - cart.discount_price)}"
                                   scope="session"/>
                            <c:set var="totalSavings"
                                   value="${totalSavings + cart.product_amount*(cart.product_price - cart.discount_price)}"
                                   scope="session"/>
                        </c:if>
                        <!-- 建立表单来提交购买商品的数量product_amount -->
                        <form action="http://localhost:8080/shop/cartController?action=updateCart" method="post">
                            <td><input name="productAmount" type="text" value="${cart.product_amount}" maxlength="4"
                                       size="3"/></td>
                            <input type="hidden" name="product_id" value="${cart.product_id}"/>
                            <td>
                                <button type="submit" id="myButton" name="action" value="save">保存
                                </button>
                            </td>
                        </form>
                        <!-- 点击删除，在数据库中删除数据 -->
                        <form action="http://localhost:8080/shop/cartController?action=deleteCart" method="post">
                            <input type="hidden" name="product_id" value="${cart.product_id}"/>
                            <td>
                                <button type="submit" id="delete" name="action" value="delete">删除</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </c:if>


            <tr class="h26">
                <!--catlist2.jsp为展示所有商品的页面-->
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<a
                        href="catlist2.jsp">继续挑选商品</a></td>
                <td class="a_c" colspan="2" id="sum" class="pl58">￥${totalPrice}</td>
                <td colspan="2">你共节省：￥${totalSavings}</td>
            </tr>
            </tbody>
        </table>
        <form id="buyForm" method="post" action="">
            <table class="buy">
                <tbody>
                <tr class="buytitle">
                    <td colspan="2">补充您的邮件地址和联系人基本信息</td>
                </tr>
                <tr>
                    <td class="a_r"><label for="username">收件人：</label></td>
                    <td><input type="text" name="username" id="username"/>
                </tr>
                <tr>
                    <td class="a_r"><label for="address">地&nbsp;&nbsp;&nbsp;址： </label></td>
                    <td id="selectPlace">
                        <input type="text" name="address" id="address"/>
                        <a href="javascript:openWindow()" class="b">请点击填写地址</a>
                    </td>
                </tr>
                <tr>
                    <td class="a_r"><label for="tel">电&nbsp;&nbsp;&nbsp;话：</label></td>
                    <td><input class="w30" type="text" name="code" size="4" id="tel"/>-<input class="w81" type="text"
                                                                                              name="telnumber"
                                                                                              size="8"/>-<input
                            class="w30" type="text" name="branchnumber" size="4"/><span class="red b"></span>（区号-电话号码-分机）
                    </td>
                </tr>
                <tr>
                    <td class="h65">&nbsp;</td>
                    <td><input class="imginput" type="image" src="images/submit.gif"/></td>
                </tr>
                </tbody>
            </table>
        </form>
        <iframe id="footer" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
    </div><!--container	end-->
</div>
</body>
