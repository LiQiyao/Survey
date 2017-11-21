<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/choosePage.css" />
    <title>Choose Design Model</title>
</head>

<body>
<div class="nav-menu">
    <span class="nav-menu-text">选择问卷</span>
</div>
<div style="margin:0 15px;">
    <table class="layui-table" lay-skin="line">
        <thead>
        <tr>
            <th>问卷名称</th>
            <th>年级</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="item" items="${displayFormList}">
            <tr>
                <td>${item.currentQuestionnaireIdChoice}</td>
                <td>${item.grade}</td>
                <td>
                    <button class="layui-btn layui-btn-mini" onclick="window.location.href='/admin/statistics/questionnaireId/${item.currentQuestionnaireIdChoice}/grade/${item.grade}'">查看统计结果</button>
                    <button class="layui-btn layui-btn-mini" onclick="window.location.href='/admin/answerSheets/batchExport/${item.grade}'">批量下载word文档</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="/plugins/layui/layui.js"></script>
<script>
</script>

</html>