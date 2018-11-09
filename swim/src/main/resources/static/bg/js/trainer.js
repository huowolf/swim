!function () {

    var $ = layui.$
    $("#add-trainer").on("click",function () {
        window.location.href="/trainer/toadd";
    })

    var form = layui.form;
    var table = layui.table;


    table.render({
        id: "user-id",
        elem: '#user',
        height: 'full-200',
        cellMinWidth: 80, //全局定义常规单元格的最小宽度
        url: '/trainer/showTrainerTable', //
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
                field: 'photo',
                title: '照片',
                sort: true,
                align:'center',
                templet: '#photoTpl'
            },{
                field: 'description',
                title: '简介',
                align:'center'
            },
                {
                fixed: 'right',
                title: '操作',
                toolbar: '#userbar',
                align: 'center',

            },
            ]
        ],

        initSort: {
            field: 'id' //排序字段，对应 cols 设定的各字段名
            , type: 'asc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        },
        done:function(res,curr,count){
            hoverOpenImg();//显示大图
            $('table tr').on('click',function(){
                $('table tr').css('background','');
                $(this).css('background','<%=PropKit.use("config.properties").get("table_color")%>');
            });
        }
    });

    function hoverOpenImg(){
        var img_show = null; // tips提示
        $('td img').hover(function(){
            //alert($(this).attr('src'));
            var img = "<img class='img_msg' src='"+$(this).attr('src')+"' style='width:250px;' />";
            img_show = layer.tips(img, this,{
                tips:[2, 'rgba(41,41,41,.5)']
                ,area: ['280px']
            });
        },function(){
            layer.close(img_show);
        });
        // $('td img').attr('style','max-width:70px');
    }

    //监听行工具事件
    table.on('tool(user)', function (obj) {
        var data = obj.data;//获得当前行数据

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
        }

    });

}();