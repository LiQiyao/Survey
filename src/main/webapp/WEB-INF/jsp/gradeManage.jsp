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
    <script src="/js/plugins/jquery-3.1.1.min.js"></script>
    <title>Grade Manage</title>
</head>

<body>
<div class="nav-menu">
    <span class="nav-menu-text">年级管理</span>
</div>
<div style="margin:0 15px;">
    <table class="layui-table" lay-skin="line">
        <thead>
        <tr>
            <th>年级</th>
            <th>问卷名称</th>
            <th>第一部分</th>
            <th>第二部分</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${displayFormList}" var="lineItem" varStatus="status">
        <tr>
            <form id="line${status.count}">
                <input type="hidden" name="grade" value="${lineItem.grade}">
                <td>${lineItem.grade}</td>
                <td>
                    <select name="questionnaireId" onchange="changed(${status.count})">
                        <option value="null">-未选择-</option>
                        <c:forEach items="${lineItem.questionnaires}" var="questionnaire">
                            <option value="${questionnaire.id}" ${lineItem.currentQuestionnaireIdChoice eq questionnaire.id ? "selected" : ""}>${questionnaire.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input name="part1" value="1" type="checkbox" onchange="changed(${status.count})" ${lineItem.part1IsDisplay?"checked":""}></td>
                <td><input name="part2" value="1" type="checkbox" onchange="changed(${status.count})" ${lineItem.part2IsDisplay?"checked":""}></td>
            </form>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="/plugins/layui/layui.js"></script>
<script>
    function changed(formId) {
        var formName = '#line'+formId;
        $.ajax({
            cache: true,
            type: "POST",
            url: "/admin/displayForms",
            data: $(formName).serialize(),
            async: false,
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {

            }
        });
    }
</script>

</html>