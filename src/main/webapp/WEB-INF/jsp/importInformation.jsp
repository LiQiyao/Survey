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
    <title>Import Information</title>
</head>

<body>
<div class="nav-menu">
    <span class="nav-menu-text">导入信息</span>
</div>
<div style="margin:0 15px;">
    <form enctype="multipart/form-data" action="" method="post">
        <p><span>上传学生信息Excel表</span><input type="file" name="file"></p>
        <p><button type="submit">上传</button></p>
    </form>
</div>
</body>
<script src="/plugins/layui/layui.js"></script>
<script>
</script>

</html>
