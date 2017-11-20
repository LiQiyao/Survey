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
    <button class="layui-btn" style="float:right;">新建问卷</button>
</div>
<div style="margin:0 15px;">
    <table class="layui-table" lay-skin="line">
        <thead>
        <tr>
            <th>问卷名称</th>
            <th>修改时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${questionnaireCatalog}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.updateTime}</td>
                <td>
                    <button class="layui-btn layui-btn-mini">修改</button>
                    <button class="layui-btn layui-btn-mini layui-btn-danger">删除</button>
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
