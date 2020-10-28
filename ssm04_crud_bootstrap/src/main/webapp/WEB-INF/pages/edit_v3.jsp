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
    <title>修改部门</title>
</head>
<body>
    <!--container表示容器，所有内容放进这个容器-->
    <div class="container">
        <!--row表示一行的宽度，一行分12份-->
        <div class="row">
            <!--col-md-4 表示使用一行的4/12宽度-->
            <div class="col-md-4">
                <h1>部门编辑</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="did" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="did" disabled="disabled" value="1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dname" class="col-sm-2 control-label">部门名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="dname" placeholder="部门名称" value="测试部门">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">保存修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
