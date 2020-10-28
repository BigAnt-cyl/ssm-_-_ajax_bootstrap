<%--
  Created by IntelliJ IDEA.
  User: 陈云龙
  Date: 2020/10/18
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/dept/update">
    <input type="hidden" name="did" value="${dept.did}" >
    <input type="text"  value="${dept.did}" disabled="disabled"/><br/>
    <input type="text" name="dname" value="${dept.dname}"/><br/>
    <input type="submit" value="保存修改"/><br/>
</form>

</body>
</html>
