<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%
    //给path设置为项目名路径
    pageContext.setAttribute("path",request.getContextPath());
%>
<head>
    <title>Title</title>
    <!--引入-->
    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#btn_add').click(function () {
                //js发送请求
                var dname = $('#add_name').val()
                console.info(dname)

                $.ajax({
                    url:'${path}/deptv3/add',
                    async:true,
                    data:'{"did":"","dname":"'+dname+'"}',
                    type:"post",
                    contentType:"application/json;charset=UTF-8",
                    success:function (result) {
                        if (200 == result.code){
                            alert(result.msg)
                            //刷新列表
                        }
                    },
                    error:function (result) {
                        alert('服务器错误，请求失败')
                    }
                })
            })

        })
    </script>
</head>
<body>

    <div id="addDiv">
        <h1>添加页面</h1>
        <form id="add_form" method="post">
            <input type="hidden" name="did"><br>
            <input type="text" name="dname" id="add_name"/><br/>
            <input id="btn_add" type="button" value="保存"/><br/>
        </form>
    </div>

</body>
</html>
