<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成品入库明细</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>

<div data-role="page" id="index">

    <div data-role="header" data-position="fixed" data-tap-toggle="false">
        <h1>入库单：${fabInNO} 详情</h1>
        <a href="${pageContext.request.contextPath}/" target="_top" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-home ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
        <a href="${pageContext.request.contextPath}/fabIn" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-back ui-nodisc-icon ui-alt-icon ui-btn-right">返回</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <div class="ui-body ui-body-a ui-corner-all">
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>入库编号：</label>
                        <label>${head.FabInNO}</label>
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
                        <label>${fn:substring(head.FabInDT, 0, 10)}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>缸　　号：</label>
                        <label>${head.ManuCrock}</label>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>门　　幅：</label>
                        <label>${head.WideSize}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>克　　重：</label>
                        <label>${head.FndHeight}</label>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>布　　类：</label>
                        <label>${head.ProdNameC}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>色　　名：</label>
                        <label>${head.SName}</label>
                    </div>
                </div>
            </div>
            <div class="ui-grid-a">
                <div class="ui-block-a">
                    <div class="ui-bar ui-bar-a">
                        <label>入库匹数：</label>
                        <label>${head.TotalPieces}</label>
                    </div>
                </div>
                <div class="ui-block-b">
                    <div class="ui-bar ui-bar-a">
                        <label>入库重量：</label>
                        <label>${head.TotalWeights}</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui-body ui-body-a ui-corner-all">
            <table data-role="table" class="ui-responsive table-stroke">
                <thead>
                    <tr>
                        <th>匹号</th>
                        <th>匹长</th>
                        <th>数量</th>
                        <th>缸号</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty detail}">
                        <c:forEach var="item" items="${detail}" varStatus="status">
                            <tr>
                                <th>${item.PieceNO}</th>
                                <td>${item.PieceLen}</td>
                                <td>${item.Quan}</td>
                                <td>${item.ManuCrock}</td>
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
