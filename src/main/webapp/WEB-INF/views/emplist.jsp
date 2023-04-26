<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 정보 리스트</title>
</head>
<body>
<h1>사원 정보 리스트</h1>

<ul>
    <c:forEach items="${emps}" var="emp">
    <li>${emp.empid} ${emp.fname} ${emp.email} ${emp.jobid} ${emp.deptid}</li>
    </c:forEach>
</ul>

</body>
</html>
