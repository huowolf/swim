!function () {
    var $ = layui.$;
    var form = layui.form;
    var table = layui.table;


    table.render({
        id: "user-id",
        elem: '#user',
        height: 'full-200',
        cellMinWidth: 80, //全局定义常规单元格的最小宽度
        url: '/user/showUserTable', //
        method: 'post',
        page: true, //开启分页
        cols: [
            [ //表头
                {
                    field: 'id',
                    title: 'ID',
                    sort: true,
                    align:'center',
                    fixed: 'left'
                }, {
                field: 'name',
                title: '用户名',
                align:'center'
            }, {
                field: 'sex',
                title: '性别',
                sort: true,
                align:'center'
            }, {
                field: 'subject',
                title: '培训课程',
                align:'center'
            },  {
                fixed: 'right',
                title: '操作',
                toolbar: '#userbar',
                width: 190
            },
            ]
        ],

        initSort: {
            field: 'id' //排序字段，对应 cols 设定的各字段名
            , type: 'asc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        }
    });


    //监听行工具事件
    table.on('tool(user)', function (obj) {
        var data = obj.data;//获得当前行数据

        //更新form渲染
        form.render();

        if (obj.event === 'del') {
            layer.confirm('真的删除该行数据吗？', function (index) {
                obj.del();
                layer.close(index);
                //向服务端发送删除指令

                $.ajax({
                    type:'post',
                    url: '/user/deleteUser',
                    data: {"id":data.id},
                    success:function(data){
                        layer.msg(data.msg,{icon:1,time: 2000})
                    },

                });
            });
        } else if (obj.event === 'edit') {
            layer.open({
                type: 1,
                offset: '100px',
                title: '修改用户',
                shadeClose: true, //点击遮罩关闭
                content: $('#user-form'),
                success: function (layero, index) {
                    form.val("user-edit-form",{
                        "id": data.id,
                        "name":data.name,
                        "sex":data.sex,
                        "subject":data.subject
                    })
                },
            });
        }
    });

    //修改用户
    form.on('submit(user-form-submit)', function(data){
        $.ajax({
            type:'post',
            url: '/user/editUser',
            data: data.field,
            success:function(data){
                if  (data.code == 200) {
                    layer.msg('修改成功!',{icon:1,time: 2000});
                    layer.closeAll('page');

                    //重载表格
                    table.reload('user-id', {
                        url: '/user/showUserTable',
                    });

                }else{
                    layer.msg(data.msg,{icon:2,time: 2000});
                }

            },

        });

        return false; //阻止表单跳转。
    });

}();