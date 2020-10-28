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
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${path}/js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${path}/js/bootstrap.min.js"></script>
    <title>Bootstrap 101 Template</title>
</head>
<body>
<div class="container">
    <h1>你好，世界！</h1>
    <button type="button">你好我是普通按钮</button>
    <button class="bg-primary" type="button" >你好我是bootstrap按钮</button>
</div>
</body>
</html>


