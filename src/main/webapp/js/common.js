/**
 * Created by asus on 2017/8/20.
 */
$(
    function()
    {
        fitHeight();
        $(window).resize(fitHeight);
    }
);

//更改背景大小
function fitHeight()
{
    var h = $(window).height()>390?$(window).height():390;
    $(".container-fluid").height(h);
}
