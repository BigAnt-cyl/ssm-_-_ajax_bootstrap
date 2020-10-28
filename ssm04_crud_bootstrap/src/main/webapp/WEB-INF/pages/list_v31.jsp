<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <!--兼容IE浏览器-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--兼容手机-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <% pageContext.setAttribute("path",request.getContextPath()); %>
    <!-- Bootstrap -->
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${path}/js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${path}/js/bootstrap.min.js"></script>
    <title>部门列表</title>
</head>
<body>
${pi}
    <!--container表示容器，所有内容放进这个容器-->
    <div class="container" >
        <!-- row表示 一行的宽度-->
        <div class="row">
            <!--col-md-4 表示使用一行的4/12宽度 -->
            <div class="col-md-4" >
                <h1>部门列表</h1>
            </div>
        </div>
        <div class="row">
            <%--        <div class="col-md-8" ></div>--%>
            <!-- offset表示不占左边八格，从第九开始-->
            <div class="col-md-4 col-md-offset-8" >
                <button class="btn btn-primary"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</button>
            </div>
        </div>
        <div class="row">

            <div class="col-md-12" >
                <table class="table table-hover">
                    <tr >
                        <th >部门编号</th>
                        <th ></th>
                        <th >部门名称</th>
                        <th >操作</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td></td>
                        <td>jack</td>
                        <td>
                            <button class="btn btn-danger"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</button>/
                            <button class="btn btn-info"> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改</button>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6" >当前共有100条记录，共20页</div>
            <div class="col-md-6" >
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">首页</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">末页</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

</body>
</html>
