<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>微信端信息查询</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
</head>
<body>
<div data-role="page">

    <div data-role="header" data-position="fixed">
        <h1>胚布入库查询</h1>
        <a href="#nav-panel" class="ui-btn ui-btn-icon-notext ui-corner-all ui-icon-bars ui-nodisc-icon ui-alt-icon ui-btn-left">菜单</a>
    </div><!-- /header -->

    <div role="main" class="ui-content">
        <div data-role="collapsibleset" data-theme="a" data-content-theme="a" data-collapsed-icon="carat-l" data-expanded-icon="carat-d" data-iconpos="right">
            <div data-role="collapsible">
                <h3>查询条件</h3>
                <form method="post">
                    <fieldset>
                        <div class="ui-grid-a">
                            <div class="ui-block-a">
                                <label for="beginDate">开始日期</label>
                                <input type="date" name="date" id="beginDate" value="">
                            </div>
                            <div class="ui-block-b">
                                <label for="endDate">结束日期</label>
                                <input type="date" name="date" id="endDate" value="">
                            </div>
                        </div>
                        <button type="submit" class="ui-btn ui-btn-b ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all" onclick="findAsmInHeadData();">查询</button>
                    </fieldset>
                </form>
            </div>
        </div>
        <ul data-role="listview" data-inset="true" id="asmInHeadResult">
            <%--<li data-role="list-divider">E16060001<span class="ui-li-count">入库匹数：12</span></li>
            <li><a href="index.html">
                <h2>Stephen Weber</h2>
                <p><strong>You've been invited to a meeting at Filament Group in Boston, MA</strong></p>
                <p>Hey Stephen, if you're available at 10am tomorrow, we've got a meeting with the jQuery team.</p>
                <p class="ui-li-aside"><strong>6:24</strong>PM</p>
            </a></li>
            <li><a href="index.html">
                <h2>jQuery Team</h2>
                <p><strong>Boston Conference Planning</strong></p>
                <p>In preparation for the upcoming conference in Boston, we need to start gathering a list of sponsors and speakers.</p>
                <p class="ui-li-aside"><strong>9:18</strong>AM</p>
            </a></li>
            <li data-role="list-divider">Thursday, October 7, 2010 <span class="ui-li-count">1</span></li>
            <li><a href="index.html">
                <h2>Avery Walker</h2>
                <p><strong>Re: Dinner Tonight</strong></p>
                <p>Sure, let's plan on meeting at Highland Kitchen at 8:00 tonight. Can't wait!</p>
                <p class="ui-li-aside"><strong>4:48</strong>PM</p>
            </a></li>--%>
        </ul>
    </div><!-- /content -->

    <div data-role="panel" data-position-fixed="true" data-display="push" data-theme="b" id="nav-panel">

        <div data-role="collapsibleset" data-theme="b" data-content-theme="b" data-collapsed-icon="carat-l" data-expanded-icon="carat-d" data-iconpos="right">
            <div data-role="collapsible">
                <h3>库存类</h3>
                <ul data-role="listview">
                    <li><a href="#" data-rel="close">胚布入库查询</a></li>
                    <li><a href="#">胚布出库查询</a></li>
                </ul>
            </div>
        </div>

    </div><!-- /panel -->

</div><!-- /page -->

<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
<script>
    var page = 1;
    var rows = 10;
    var order = "a.AsmDT desc";
    $(function () {
        findAsmInHeadData();
    });
    function findAsmInHeadData() {
        var params = {
            "page": page,
            "rows": rows,
            "order": order
        };
        if ($("#beginDate").val() != '') {
            params.beginDate = $("#beginDate").val();
        }
        if ($("#endDate").val() != '') {
            params.beginDate = $("#endDate").val();
        }
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/asmIn/findAsmInHead",
            dataType: "JSON",
            data: params,
            success: function (data) {
                if (data && data.size > 0) {
                    //去掉更多加载
                    appendHtml(data);
                    //加上加载更多
                    page += 1;
                } else {
                    $("#asmInHeadResult").append("<li data-role='list-divider'>数据已全部加载完成！</li>");
                }
            }
        });
    }

    function appendHtml(dataList) {
        $.each(dataList, function (data) {
            $("#asmInHeadResult").append("<li data-role='list-divider'>" + data.asmInNo + "<span class='ui-li-count'>入库匹数：12</span></li>");
            $("#asmInHeadResult").append("<li><a href='#'><h2>客户a</h2>");
            $("#asmInHeadResult").append("<p><strong>加强描述</strong></p>");
            $("#asmInHeadResult").append("<p>小写描叙</p>");
            $("#asmInHeadResult").append("<p class='ui-li-aside'><strong>6:24</strong>PM</p>");
            $("#asmInHeadResult").append("</a></li>");
        });
    }
</script>
</body>
</html>
