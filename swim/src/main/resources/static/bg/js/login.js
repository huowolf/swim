! function () {
    var $ = layui.$  
    var form = layui.form;
    var layer = layui.layer;

    if(document.referrer.indexOf("register")!= -1){
        layer.msg('注册成功', {icon: 6,area: '100px'});
    };

    // 表单提交
    form.on('submit(login-submit)', function (obj) {

        var field = obj.field;
        $.ajax({
            url: '/login',
            data: field,
            type: 'post',
            dataType: 'JSON',
            success: function (data) {
                console.log(JSON.stringify(data));
                if (data.code == 200) {
                    layer.msg('登录成功', {icon: 1,time:2000}, function () {
                        location.replace('/');
                    });
                } else {
                    layer.closeAll('loading');
                    layer.msg(data.msg, {icon: 5});
                }
            },
            error: function (xhr) {
                layer.closeAll('loading');
                if (xhr.status == 400) {
                    layer.msg('登录失败，请重试', {icon: 5});
                }
            }
        });



    });

}();