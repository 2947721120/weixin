<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>系统登录</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/demos/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>
<div data-role="page">

    <div data-role="header" data-position="fixed">
        <h1>欢迎登录微信端系统</h1>
        <a href="#" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-home ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <form action="index.html" method="post">

            <h2>登录验证</h2>

            <label for="name">用户名:</label>
            <input type="text" name="name" id="name" value="" placeholder="登录用户名" data-clear-btn="true">

            <label for="password">密　码:</label>
            <input type="password" name="password" id="password" value="" placeholder="登录密码" data-clear-btn="true" autocomplete="off">

            <button type="submit" class="ui-btn ui-btn-b ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all">登录</button>
        </form>
    </div><!-- /content -->

</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
</body>
</html>
