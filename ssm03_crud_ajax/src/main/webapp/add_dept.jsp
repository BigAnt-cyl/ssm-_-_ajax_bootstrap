<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red">${error_msg}</span>
<form method="post" action="${pageContext.request.contextPath}/dept/save">
    <input type="text" name="dname"/><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
