<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,edu.foobar.model.*,edu.foobar.controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<jsp:include page="../inc/header.jsp">
    <jsp:param name="pageTitle" value="Student List"/>
</jsp:include>
<main class="container">
    <section class="container-fixed">
        <div class="school-heading">
            <div class="name-title">
                <h1 class="mb-3 mt-5 color-purple">Foobar University</h1>
                <h2 class="mb-3 mt-3 color-purple">Student List</h2>
            </div>
            <div class="school-logo">
                <img src="${pageContext.request.contextPath}/images/coyotes.png" alt="school logo" />
            </div>
        </div>

        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th scope="col">Student Id</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Email</th>
                <th class="text-center" scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <th scope="row">${student.id}</th>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.emailAddress}</td>
                    <td class="text-center">
                        <button onclick="window.location.href='${pageContext.request.contextPath}/main?action-type=update-student&id=${student.id}'" class="btn btn-secondary">update</button>
                        <button onclick="window.location.href='${pageContext.request.contextPath}/main?action-type=delete-student&id=${student.id}'" class="btn btn-warning">delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form class="mb-5" action="main" method="GET">
            <input type="hidden" value="add-student" name="action-type" />
            <button type="submit" class="btn btn-success mt-1 mb-5 bg-purple border-purple text-white">Add Student</button>
        </form>
    </section>
</main>
<jsp:include page="../inc/footer.jsp"/>