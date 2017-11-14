<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
    int part1count=0;
    int part2count=0;

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/plugins/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/statistics.css" />
    <title>statistics</title>
</head>

<body>
    <div class="main">
        <blockquote class="layui-elem-quote layui-quote-nm">
            <p>专业名称：${majorTable[currentUser.majorId]}</p>
            <p>该专业参与调查的总人数：${studentCount}人</p>
            <p>已答题人数：${answerCount}人</p>
            <p>未答题人数：${studentCount - answerCount}人</p>
            <p>已答题人数所占比例：<fmt:formatNumber type="number" value="${answerCount*100.0/studentCount}" maxFractionDigits="2"/>%</p>
        </blockquote>
        <div>
            <div class="layui-form">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>一、毕业要求达成度调查</legend>
                </fieldset>
                <c:forEach var="question" items="${questionnaireModel.part1}">
                    <div class="question-block">
                        <div class="question-title"><%=++part1count%>. ${question.questionContent}</div>
                        <div class="choice">
                            <c:forEach var="answer" items="${question.answers}">
                                <div class="choice-item">
                                    <span>${answer.answerContent}</span>
                                    <span class="statis">选择人数<span class="num-choose">${resultMap.get(answer.id)}</span> | 占比<span class="percent"><fmt:formatNumber type="number" value="${resultMap.get(answer.id)*100.0/answerCount}" maxFractionDigits="2"/>%</span></span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div class="layui-form">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>二、毕业生跟踪调查</legend>
                </fieldset>
                <c:forEach var="question" items="${questionnaireModel.part2}">
                    <div class="question-block">
                        <div class="question-title"><%=++part2count%>. ${question.questionContent}</div>
                        <div class="choice">
                            <c:forEach var="answer" items="${question.answers}">
                                <div class="choice-item">
                                    <span>${answer.answerContent}</span>
                                    <span class="statis">选择人数<span class="num-choose">${resultMap.get(answer.id)}</span> | 占比<span class="percent"><fmt:formatNumber type="number" value="${resultMap.get(answer.id)*100.0/answerCount}" maxFractionDigits="2"/>%</span></span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div class="layui-form">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>三、您的意见及建议</legend>
                </fieldset>

                <table lay-filter="advises">
                    <thead>
                        <tr>
                            <th lay-data="{field:'username', width:100}">姓名</th>
                            <th lay-data="{field:'studentId', width:140, sort:true}">学号</th>
                            <th lay-data="{field:'advise',width:800}">意见及建议</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="suggestion" items="${suggestionTable}">
                        <c:if test="${suggestion.suggestionContent!=null && suggestion.suggestionContent!=''}" >
                            <tr>
                                <td>${suggestion.student.name}</td>
                                <td>${suggestion.student.username}</td>
                                <td>${suggestion.suggestionContent}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</body>
<script src="/plugins/layui/layui.js"></script>
<script>
    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;
        table.init('advises', {
            
            page: true
            
        });
    });
</script>

</html>