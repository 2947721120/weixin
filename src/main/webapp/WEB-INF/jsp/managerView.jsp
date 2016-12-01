<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>总经理报表</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>

<div data-role="page" id="index">

    <div data-role="header" data-position="fixed" data-tap-toggle="false">
        <h1>报表查询</h1>
        <a href="${pageContext.request.contextPath}/#finance" target="_top" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-home ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <div data-role="collapsibleset" data-theme="a" data-content-theme="a" data-collapsed-icon="carat-l" data-expanded-icon="carat-d" data-iconpos="right">
            <div data-role="collapsible" data-collapsed="false">
                <h3>查询条件</h3>
                <form method="post">
                    <fieldset>
                        <div class="ui-grid-a">
                            <div class="ui-block-a">
                                <input type="date" name="date" id="beginDate" value="">
                            </div>
                            <div class="ui-block-b">
                                <input type="date" name="date" id="endDate" value="">
                            </div>
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
        <ul data-role="listview" data-inset="true" id="asmInHeadResult">

        </ul>
    </div><!-- /content -->
</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/js/jquery.ext.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
    $(function () {
        var now = new Date();
        now.setDate(now.getDate() -1);
        var time = now.Format("yyyy-MM-dd");
        $("#beginDate").val(time);
        $("#endDate").val(time);
        buttonData();
    });
    function cancelData() {
        $("#beginDate").val("");
        $("#endDate").val("");
        buttonData();
    }
    function buttonData() {
        findAsmInHeadData(false);
    }
    function findAsmInHeadData(page, rows, isAppend) {
        var params = {};
        if ($("#beginDate").val() != '') {
            params.beginDate = $("#beginDate").val();
        }
        if ($("#endDate").val() != '') {
            params.endDate = $("#endDate").val();
        }
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/manager/view",
            dataType: "JSON",
            data: params,
            success: function (data) {
                appendHtml(data, isAppend);
            }
        });
    }
    function appendHtml(dataList, isAppend) {
        var appendHtml = "";
        if (dataList && dataList.length > 0) {
            $.each(dataList, function (index, value) {
                //appendHtml += "<li data-role='list-divider'></li>";
                appendHtml += "<li>";
                appendHtml += "<p><strong>" + value.name + "：" + value.total + "</strong></p>";
                appendHtml += "</li>";
            });
            $("#asmInHeadResult").html(appendHtml);
        } else {
            $("#asmInHeadResult").html("<li data-role='list-divider'>当前条件没有更多数据！</li>");
        }
        $("#asmInHeadResult").listview("refresh");
    }
</script>
</body>
</html>
