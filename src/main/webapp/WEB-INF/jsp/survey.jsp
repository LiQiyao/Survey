<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="/css/survey.css" />
    <link rel="stylesheet" href="/plugins/layui/css/layui.css" />
    <title>调查问卷</title>
</head>

<body>
    <div class="main">
        <blockquote class="layui-elem-quote">
            <p>姓名：${currentUser.name}</p>
            <p>学号：${currentUser.username}</p>
            <p>专业：${majorTable[currentUser.majorId]}</p>
            <p>班级：${currentUser.klasse}</p>
        </blockquote>

        <div class="title">毕业要求达成度及毕业生跟踪调查问卷</div>

        <form action="/student/answer" method="post" class="layui-form">
            <div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>一、毕业要求达成度调查</legend>
                </fieldset>
                <c:forEach var="question" items="${questionnaireModel.part1}">
                    <div class="question-block">
                        <div class="question-title"><%=++part1count%>. ${question.questionContent}</div>
                        <div class="choice">
                            <div style="display:none;"><input lay-ignore type="radio" name="${question.id}" value="EMPTY_TAG" title="EMPTY_TAG"></div>
                            <c:forEach var="answer" items="${question.answers}">
                                <div><input type="radio" name="${question.id}" value="${answer.id}" title="${answer.answerContent}"></div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>二、毕业生跟踪调查</legend>
                </fieldset>
                <c:forEach var="question" items="${questionnaireModel.part2}">
                    <div class="question-block">
                        <div class="question-title"><%=++part2count%>. ${question.questionContent}</div>
                        <div class="choice">
                            <div style="display:none;"><input lay-ignore type="radio" name="${question.id}" value="EMPTY_TAG" title="EMPTY_TAG"></div>
                            <c:forEach var="answer" items="${question.answers}">
                                <div><input type="radio" name="${question.id}" value="${answer.id}" title="${answer.answerContent}"></div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>三、您的意见及建议</legend>
                </fieldset>
                <textarea name="suggestionContent" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
            <div style="text-align: center; margin:20px 0 100px;">
                <button class="layui-btn layui-btn-big layui-btn-danger" lay-submit lay-filter="sub">提交问卷</button>
            </div>
        </form>
    </div>
</body>


<script src="/plugins/layui/layui.js"></script>
<script>
    function* objectEntries(obj) {
        let propKeys = Reflect.ownKeys(obj);
        for (let propKey of propKeys) {
            yield [propKey, obj[propKey]];
        }
    }
    layui.use(['form','layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
        form.on('submit(sub)', function (data) {
            for(var [k,v] of objectEntries(data.field)){
                console.log(v);
                if(v=="EMPTY_TAG"){
                    layer.alert('您还有为空的选项，请填写完再提交！', {icon: 2});
                    return false;
                }
            }
        });
    });
</script>

</html>