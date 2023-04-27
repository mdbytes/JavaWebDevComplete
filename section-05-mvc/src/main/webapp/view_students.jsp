<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/14/22
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Students</title>
</head>
<body>
<table>
    <thead>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email Address</th>
    </thead>

<c:forEach var="student" items="${student_list}">
  <tr>
      <td>${student.firstName}</td>
      <td>${student.lastName}</td>
      <td>${student.emailAddress}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>
