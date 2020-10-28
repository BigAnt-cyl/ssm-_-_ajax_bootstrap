<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<% pageContext.setAttribute("path",request.getContextPath()); %>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        //页面加载完成后执行
        $(function () {
            refreshTable()
            //在文档加载之前，读取dom元素就是空
            //所以要写在$(function(){})中，不然会报错，没有效果。
            $('#btn_add').click(function () {
                //当表单提交多条数据时，需要用到serialize()方法，
                //将表单数据拼接成k1=v1&k2=v2
                //注意data不是json格式数据
                var data = $('#add_form').serialize()
                $.post(
                    '${path}/deptv2/add',
                    data,
                    function (result) {
                        console.info(result)
                        //提示信息
                        alert(result.msg)
                        //重新加载列表
                        refreshTable()
                    }, 'json')
            })
        })

        //传对象，修改值
        function update() {
            //注意data不是json格式数据
            var data = $('#update_form').serialize();//获取序列化的表单数据,k1=v1&k2=v2
            $.post(
                '${path}/deptv2/update',
                data,
                function (result) {
                    alert(result.msg);
                    //刷新列表
                    refreshTable()
                },'json')
        }
        //回显，根据id查到结果，显示到编辑界面
        function updateUI(did) {
            //切换到编辑div
            switchDiv(3)

            $.get('${path}/deptv2/find?did='+did,function (result) {
                if (200==result.code){
                    var dept = result.data
                    //数据回显
                    $('#u_did1').val(dept.did)
                    $('#u_did2').val(dept.did)
                    $('#u_dname').val(dept.dname)
                }else {
                    //提示没有查到
                    alert(result.msg)
                }
            },'json')
        }
        //根据id删除
        function deleteById(did) {
            $.get(
                '${path}/deptv2/delete?did='+did,
                function (result) {
                    //提示是否删除成功
                    alert(result.msg)
                    //转到列表页面
                    refreshTable()
                },
                'json'
            )
        }
        //获取所有信息，并显示在表格中
        function refreshTable() {
            //清空表格
            $('#tab').html('')
            //1：js发送请求
            $.get(
                '${path}/deptv2/list',
                function (result) {
                    console.info(result)
                    //定义表格的内容
                    var trs = ''
                    //拼接表头
                    trs += '<tr>\n' +
                        '        <td>编号</td>\n' +
                        '        <td>部门名称</td>\n' +
                        '        <td>管理</td>\n' +
                        '\n' +
                        '    </tr>'
                    //2:js接收结果
                    if (200==result.code){
                        var items = result.data
                        console.info(items)
                        for (var i = 0; i < items.length; i++) {
                            trs += '<tr>\n' +
                                '            <td>'+items[i].did+'</td>\n' +
                                '            <td>'+items[i].dname+'</td>\n' +
                                '            <td><a href="javascript:deleteById('+items[i].did+')">删除</a><a href="javascript:updateUI('+items[i].did+')">修改</a></td>\n' +
                                '        </tr>'
                        }//for 结束
                    }
                    //3:js更新页面
                    $('#tab').html(trs)
                },
                'json'
            )
            //只显示列表div
            switchDiv(2)
        }

        //切换div的显示
        function switchDiv(part) {
            //隐藏内容
            $('#addDiv').css("display","none")
            $('#listDiv').css("display","none")
            $('#editDiv').css("display","none")
            if(1 == part){//添加页面
                $('#addDiv').css("display","block")
                $('#add_dname').val('')
            }else if(2 == part){//列表页面
                $('#listDiv').css("display","block")
            }else if(3 == part){//编辑页面
                $('#editDiv').css("display","block")
            }
        }
    </script>
</head>
<body>
<div id="addDiv">
    <h1>添加页面</h1>
    <form id="add_form">
        <input type="hidden" name="did"/><br>
        部门名称<input type="text" name="dname" id="add_dname"/><br>
        <input id="btn_add" type="button" value="保存">
    </form>
</div>

<div id="listDiv">
    <a href="javascript:switchDiv(1)">新增</a>
    <table border="1px" width="100%" id="tab">
    </table>
</div>

<div id="editDiv">
    <h1>修改页面</h1>
    <form id="update_form">
        <input type="hidden" name="did" id="u_did1"/><br>
        部门编号<input type="text" name="did" disabled="disabled" id="u_did2"/><br>
        部门名称<input type="text" name="dname" id="u_dname"/><br>
        <input id="btn_update" onclick="update()" type="button" value="保存修改"/>
    </form>
</div>
</html>
</html>

