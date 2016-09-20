<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>物料入库明细</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>

<div data-role="page" id="index">

    <div data-role="header" data-position="fixed" data-tap-toggle="false">
        <h1>入库单：${matInNo} 详情</h1>
        <a href="${pageContext.request.contextPath}/#purchase" target="_top" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-home ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
        <a href="${pageContext.request.contextPath}/mat/matIn" target="_top" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-back ui-nodisc-icon ui-alt-icon ui-btn-right">返回</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <div class="ui-body ui-body-a ui-corner-all">
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>入库编号：</label>
                        <label>${head.MatInNO}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>客户简称：</label>
                        <label>${head.ParSingleName}</label>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>入库日期：</label>
                        <label>${fn:substring(head.CreateDT, 0, 10)}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>入库仓库：</label>
                        <label>${head.Name}</label>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>入库件数：</label>
                        <label>${head.pieces}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>总数量　：</label>
                        <label>${head.InQuan}</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui-body ui-body-a ui-corner-all">
            <table data-role="table" class="ui-responsive table-stroke">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>物料名称</th>
                        <th>数量</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty detail}">
                        <c:forEach var="item" items="${detail}" varStatus="status">
                            <tr>
                                <th>${item.ItemNO}</th>
                                <td>${item.ProdNameC}</td>
                                <td>${item.InQuanDetail}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div><!-- /content -->

</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
<script>

</script>
</body>
</html>
