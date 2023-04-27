<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 수정</title>
</head>
<body>
<h1>사원 수정</h1>
<form name="empfrm" id="empfrm" method="post">
    <div>이름 <input type="text" name="fname" value="${emp.fname}" readonly></div>
    <div>성 <input type="text" name="lname" value="${emp.lname}" readonly></div>
    <div>이메일 <input type="text" name="email" value="${emp.email}" readonly></div>
    <div>전화번호 <input type="text" name="phone" value="${emp.phone}" readonly></div>
    <div>입사일 <input type="text" name="hdate" value="${emp.hdate}" readonly></div>
    <div><b>직책</b> <input type="text" name="jobid" value="${emp.jobid}"></div>
    <div>급여 <input type="text" name="sal" value="${emp.sal}" readonly></div>
    <div>수당 <input type="text" name="comm" value="${emp.comm}" readonly></div>
    <div><b>상사번호</b> <input type="text" name="mgrid" value="${emp.mgrid}"></div>
    <div><b>부서번호</b> <input type="text" name="deptid" value="${emp.deptid}"></div>
    <input type="hidden" name="empid" value="${emp.empid}">
    <div><button type="submit">수정완료</button></div>

</form>
</body>
</html>
