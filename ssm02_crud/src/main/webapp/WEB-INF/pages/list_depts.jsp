<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/add_dept.jsp">新增</a>
<table border="1px" width="100%">
    <tr>
        <td>编号</td>
        <td>部门名称</td>
        <td>管理</td>
    </tr>

    <c:forEach items="${depts}" var="dept">
        <tr>
            <td>${dept.did}</td>
            <td>${dept.dname}</td>
            <td><a href="${pageContext.request.contextPath}/dept/delete?did=${dept.did}">删除</a>
                <a href="${pageContext.request.contextPath}/dept/updateUI?did=${dept.did}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

