<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>设计成功</title>
</head>
<body>

</body>
<script src="/plugins/layui/layui.js"></script>
<script>
    layui.use(['layer'], function () {
        var layer = layui.layer;
        layer.alert('操作成功！', {icon: 1});
    });
    setTimeout("window.location.href='/admin/questionnaires/list'",1000);
</script>
</html>
