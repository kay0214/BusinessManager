// 监听回车事件
function keyPress(obj){
    if (obj.keyCode == 13) {
        document.getElementById("login").click();
        obj.returnValue = false;
    }
}
layui.use(['form', 'layedit', 'laydate'], function() {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$;
    //监听提交
    form.on('submit(login)', function(data) {
        $.ajax({
            type: 'POST',
            url: "/system/login/login?validateCode=" + data.field.validateCode,
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function(result){
                if(result.status === 'S001'){
                    // 登录成功 - 跳转
                    layer.msg("登录成功",{icon: 6});
                    location.href = "/index";
                }else{
                    // 登录失败 - 给出错误提示并刷新验证码
                    layer.msg(result.statusDesc,{icon: 5});
                    $("img[name='verifyImg']").click();
                }
            }
        });
        return false;
    });
});