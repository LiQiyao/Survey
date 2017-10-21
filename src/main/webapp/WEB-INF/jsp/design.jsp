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
    <link rel="stylesheet" href="/css/design.css" />
    <title>design</title>
</head>

<body>
    <div class="main" id="main">
        <blockquote class="layui-elem-quote" style="border-left-color:#ff5722;">警告：设计完毕后请点击本页最下方的“保存设计”按钮，否则将丢失本次设计所做的修改。</blockquote>
        <div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>一、毕业要求达成度调查 - 设计</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">注意：该部分题目选项已被固定为“完全达到”，“基本达到”，“未达到”，“差距很大”。</blockquote>
            
            <div class="part1-ask" v-for="(item,index) in part1">
                <span>{{index+1}}. </span>
                <input class="long-input" type="text" name="title" placeholder="请输入问题" v-model="part1[index]">
                <button class="i-b layui-btn layui-btn-mini layui-btn-danger" @click="remove(part1,index)">删除</button>
            </div>

            <div>
                <button class="layui-btn layui-btn-small" @click="part1Add()">增加问题</button>
            </div>
        </div>

        <div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>二、毕业生跟踪调查 - 设计</legend>
            </fieldset>
            <blockquote class="layui-elem-quote">该部分题目和选项均可以自定义，每个题目至少需要两个选项。</blockquote>

            <div class="part2-ask" v-for="(problem,indexx) in part2">
                <div>
                    <span>{{indexx+1}}. </span>
                    <input class="long-input" type="text" name="title" placeholder="请输入问题" v-model="problem.questionContent">
                    <button class="i-b layui-btn layui-btn-mini layui-btn-danger" @click="remove(part2,indexx)">删除</button>
                </div>
                <div class="part2-ask-items">
                    <div v-for="(ansItem,index) in problem.answerContent">
                        <input class="short-input" type="text" name="item" placeholder="请输入选项内容" v-model="problem.answerContent[index]">
                        <button class="i-b" @click="remove(problem.answerContent,index)" v-bind="{'disabled':problem.answerContent.length<=2}">删除</button>
                    </div>

                    <div>
                        <button class="layui-btn layui-btn-mini" @click="itemAdd(problem)">增加选项</button>
                    </div>
                </div>
            </div>

            <div>
                <button class="layui-btn layui-btn-small" @click="part2Add">增加问题</button>
            </div>

        </div>

        <div>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>三、毕业生意见及建议反馈 - 设计</legend>
            </fieldset>
            <blockquote class="layui-elem-quote layui-quote-nm">本部分无须设计。有一个文本框，供毕业生输入反馈意见。</blockquote>
        </div>
        <div>
            <button class="layui-btn layui-btn-big layui-btn-normal" onclick="submitDesign()">保存设计</button>
        </div>
    </div>
</body>
<script src="/plugins/layui/layui.js"></script>
<script src="/js/plugins/vue.js"></script>
<script>
    var layer;
    layui.use(['form','layer'], function () {
        var form = layui.form;
        layer = layui.layer;
    });
    var app = new Vue({
        el: "#main",
        data: ${design},
        methods:{
            remove:function(arr,index){
                arr.splice(index,1);
            },
            part1Add:function(){
                app.part1.push("");
            },
            part2Add:function(){
                app.part2.push({questionContent:"",answerContent:["",""]});
            },
            itemAdd:function(problem){
                problem.answerContent.push("");
            }
        }
    });
    function submitDesign(){
        if(checkData(app.$data)==false){
            layer.alert('有输入框内容为空！提交失败！', {icon: 2});
        } else{
            var url = "${newDesignModel==1?'/admin/question/addQuestion':'/admin/question/modifyQuestion'}";
            var k="jsonString";
            var v = JSON.stringify(app.$data);
            var myForm = document.createElement("form");
            myForm.method = "post";
            myForm.action = url;
            var myInput = document.createElement("input");
            myInput.setAttribute("name", k);
            myInput.setAttribute("value", v);
            myForm.appendChild(myInput);
            document.body.appendChild(myForm);
            myForm.submit();
        }
    }

    function checkData(data) {
        for(var i in data.part1){
            if(data.part1[i]==''){
                return false;
            }
        }
        for(var i in data.part2){
            var o = data.part2[i];
            if(o.questionContent==''){
                return false;
            }
            for(var j in o.answerContent){
                if(o.answerContent[j]==''){
                    return false;
                }
            }
        }
        return true;
    }
</script>

</html>