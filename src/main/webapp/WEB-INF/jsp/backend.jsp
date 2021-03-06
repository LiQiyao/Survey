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
    <link rel="stylesheet" href="/css/backend.css" />
    <title>Document</title>
</head>

<body>
    <div class="top-nav">
        <div class="top-nav-left">毕业要求达成度及毕业生跟踪调查系统 | 后台管理</div>
        <div class="top-nav-right">
            <span>管理员：${currentUser.username}&nbsp;&nbsp;专业：${majorTable[currentUser.majorId]}</span>
                <button class="layui-btn layui-btn-danger layui-btn-mini" style="margin:0 12px;" onclick="window.location.href='/admin/logout'">退出系统</button>
        </div>
    </div>
    <div class="left-nav">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-this"><a href="/admin/questionnaires/list" target="frame">设计调查表</a></li>
            <li class="layui-nav-item"><a href="/admin/statistics/list" target="frame">统计数据</a></li>
            <li class="layui-nav-item"><a href="/admin/displayForms/list" target="frame">年级管理</a></li>
            <li class="layui-nav-item"><a href="/admin/excel/import" target="frame">信息导入</a></li>
        </ul>
    </div>
    <div class="main">
        <iframe name="frame" src="/admin/questionnaires/list" frameborder="0"></iframe>
    </div>
</body>

<script src="/plugins/layui/layui.js"></script>
<script>
    layui.use(['element', 'form'], function () {
        var form = layui.form;
        var element = layui.element;
    });
</script>

</html>