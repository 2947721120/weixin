<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>微信端信息查询</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>
<div data-role="header" data-position="fixed" data-theme="a">
    <div data-role="navbar">
        <ul>
            <li><a href="#index" data-prefetch="true" data-transition="none" data-icon="calendar">仓库类</a></li>
            <li><a href="#product" data-prefetch="true" data-transition="flip" data-icon="grid">生产类</a></li>
            <li><a href="#finance" data-prefetch="true" data-transition="turn" data-icon="shop">财务类</a></li>
            <li><a href="#purchase" data-prefetch="true" data-transition="slide" data-icon="navigation">采购类</a></li>
        </ul>
    </div><!-- /navbar -->
</div><!-- /header -->

<div data-role="page" id="index">
    <div class="ui-content" role="main">
        <ul data-role="listview" data-theme="a" data-dividertheme="b">
            <li data-role="list-divider">胚布类查询</li>
            <li data-icon="arrow-d-l"><a href="${pageContext.request.contextPath}/asmIn" target="_top">胚布入库查询</a></li>
            <li data-icon="arrow-u-r"><a href="${pageContext.request.contextPath}/asmOut" target="_top">胚布出库查询</a></li>
            <li data-icon="gear"><a href="${pageContext.request.contextPath}/asmSave" target="_top">胚布库存查询</a></li>
            <li data-role="list-divider">成品类查询</li>
            <li data-icon="arrow-d-l"><a href="${pageContext.request.contextPath}/fabIn" target="_top">成品入库查询</a></li>
            <li data-icon="arrow-u-r"><a href="${pageContext.request.contextPath}/fabOut" target="_top">成品出库查询</a></li>
            <li data-icon="gear"><a href="${pageContext.request.contextPath}/fabSave" target="_top">成品库存查询</a></li>
        </ul>
    </div><!-- /content -->
</div><!-- /page -->

<div data-role="page" id="product">
    <div class="ui-content" role="main">
        <ul data-role="listview" data-theme="a" data-dividertheme="b">
            <li data-role="list-divider">生产类查询</li>
            <li data-icon="refresh"><a href="${pageContext.request.contextPath}/woHead" target="_top">生产进度查询</a></li>
        </ul>
    </div><!-- /content -->
</div><!-- /page -->

<div data-role="page" id="finance">
    <div class="ui-content" role="main">
        <ul data-role="listview" data-theme="a" data-dividertheme="b">
            <li data-role="list-divider">财务类查询</li>
        </ul>
    </div><!-- /content -->
</div><!-- /page -->

<div data-role="page" id="purchase">
    <div class="ui-content" role="main">
        <ul data-role="listview" data-theme="a" data-dividertheme="b">
            <li data-role="list-divider">采购类查询</li>
        </ul>
    </div><!-- /content -->
</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
<script>
    $(function(){
        $("[data-role='navbar']").navbar();
        $("[data-role='header'], [data-role='footer']").toolbar();
    });
</script>
</body>
</html>
