<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>排缸查询</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>

<div data-role="page" id="index">

    <div data-role="header" data-position="fixed" data-tap-toggle="false">
        <h1>排缸查询</h1>
        <a href="${pageContext.request.contextPath}/#product" target="_top" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-home ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <div data-role="collapsibleset" data-theme="a" data-content-theme="a" data-collapsed-icon="carat-l" data-expanded-icon="carat-d" data-iconpos="right">
            <div data-role="collapsible" data-collapsed="false">
                <h3>查询条件</h3>
                <form method="post">
                    <fieldset>
                        <div class="ui-grid-a">
                            <input type="text" name="manuCrock" id="manuCrock" value="" placeholder="计划缸号">
                        </div>
                        <div class="ui-grid-a">
                            <div class="ui-block-a">
                                <button type="button" class="ui-btn ui-btn-a ui-icon-back ui-btn-icon-left ui-shadow ui-corner-all" onclick="cancelData();">取消</button>
                            </div>
                            <div class="ui-block-b">
                                <button type="button" class="ui-btn ui-btn-b ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all" onclick="buttonData();">查询</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <ul data-role="listview" data-inset="true" id="matInHeadResult">

        </ul>
    </div><!-- /content -->

</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/js/jquery.ext.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
    var defaultPage = 1;
    var defaultRows = 10;
    var order = "a.Manu desc";
    $(function () {
        buttonData();
    });
    function cancelData() {
        $("#manuCrock").val("");
        buttonData();
    }
    function buttonData() {
        defaultPage = 1;
        defaultRows = 10;
        findAsmInHeadData(defaultPage, defaultRows, false);
    }
    function clickMore() {
        defaultPage += 1;
        defaultRows += 10;
        findAsmInHeadData(defaultPage, defaultRows, true);
    }
    function findAsmInHeadData(page, rows, isAppend) {
        var params = {
            "page": page,
            "rows": rows,
            "order": order
        };
        if ($("#manuCrock").val() != '') {
            params.manuCrock = $("#manuCrock").val();
        }
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/dye/findDyeMachineD",
            dataType: "JSON",
            data: params,
            success: function (data) {
                appendHtml(data, isAppend);
            }
        });
    }
    function appendHtml(dataList, isAppend) {
        var appendHtml = "";
        $("#clickMore").remove();
        if (dataList && dataList.length > 0) {
            $.each(dataList, function (index, value) {
                appendHtml += "<li data-role='list-divider'>计划缸号：" + value.Manu + "<span class='ui-li-count'>" + value.CrockKind + "缸号 &nbsp &nbsp &nbsp" + value.MHName + "</span></li>";
                appendHtml += "<li>";
                appendHtml += "<h2>客户简称：" + value.ParSingleName + "</h2>";
                appendHtml += "<p><strong>布类名称：" + value.ProdNameC + "</strong></p>";
                appendHtml += "<p><strong>色号：" + value.ColorCode + "</strong></p>";
                appendHtml += "<p><strong>颜色：" + value.SName + "</strong></p>";
                appendHtml += "<p class='ui-li-aside'><strong>匹数：" + value.Pieces + "</strong></p>";
                appendHtml += "<p class='ui-li-count'><strong>重量：" + value.SubQuan + "</strong></p>";
                appendHtml += "</li>";
            });
            if (isAppend) {
                $("#matInHeadResult").append(appendHtml);
            } else {
                $("#matInHeadResult").html(appendHtml);
            }
            $("#matInHeadResult").append("<li id='clickMore'><a href='javascript:clickMore();'><h2><strong>点击加载更多数据</strong></h2></a></li>");
        } else {
            if (isAppend) {
                $("#matInHeadResult").append("<li data-role='list-divider'>数据已全部加载完成！</li>");
            } else {
                $("#matInHeadResult").html("<li data-role='list-divider'>当前条件没有更多数据！</li>");
            }
        }
        $("#matInHeadResult").listview("refresh");
    }
</script>
</body>
</html>
