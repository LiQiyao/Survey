<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>毕业要求达成度及毕业生跟踪调查问卷</h2>
<div>姓名：${answerSheetVo.student.name}</div>
<div>学号：${answerSheetVo.student.username}</div>
<div>专业：${majorTable[answerSheetVo.student.majorId]}</div>
<div>班级：${answerSheetVo.student.klasse}</div>

<h4>一、毕业要求达成度调查</h4>
<c:forEach var="item" items="${answerSheetVo.part1}" varStatus="status">
    <div>${status.count}. ${item.questionContent}</div>
    <div>${item.answer}</div>
</c:forEach>


<h4>二、毕业生跟踪调查</h4>
<c:forEach var="item" items="${answerSheetVo.part2}" varStatus="status">
    <div>${status.count}. ${item.questionContent}</div>
    <div>${item.answer}</div>
</c:forEach>

<h4>三、您的意见及建议</h4>
<div>${answerSheetVo.suggestionContent}</div>
</body>
</html>