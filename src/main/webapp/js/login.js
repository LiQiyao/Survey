/**
 * Created by asus on 2017/8/20.
 */

layui.use(["form"], function()
{
    var form = layui.form;

    //选项卡切换
    $("ul.login-tab-title li").click(function()
    {
        //第几个li
        var index = $("ul.login-tab-title li").index(this);
        //击中的选项卡添加class
        $(this).addClass("login-this").siblings().removeClass("login-this");
        //显示对应的内容
        $(".login-tab-content").children(".login-tab-item").eq(index).addClass("login-show").siblings().removeClass("login-show");
    });

    //表单检验
    form.verify({
        id: function(value, item)
        {
            if(!/\d/.test(value))
            {
                return "学号必须都是数字";
            }
        }
    })
});
