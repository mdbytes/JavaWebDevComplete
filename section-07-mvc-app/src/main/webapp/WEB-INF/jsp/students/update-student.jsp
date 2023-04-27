<%@ page import="edu.foobar.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Student student = (Student)request.getAttribute("student");
%>
<jsp:include page="../inc/header.jsp" >
    <jsp:param name="pageTitle" value="Update Student"/>
</jsp:include>
<main class="container">
    <section class="container-fixed">
        <div class="school-heading">
            <div class="name-title">
                <h1 class="mb-3 mt-5 color-purple">Foobar University</h1>
                <h2 class="mb-3 mt-3 color-purple">Update Student</h2>
            </div>
            <div class="school-logo">
                <img src="${pageContext.request.contextPath}/images/coyotes.png" alt="school logo" />
            </div>
        </div>
        <form action="main" method="POST">
            <div class="mb-3">
                <label for="studentId" class="form-label">Id</label>
                <input disabled type="text" class="form-control" id="studentId" name="studentId" value="${student.id}" >
                <input type="hidden" value="${student.id}" name="id" />
            </div>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName"  value="${student.firstName}"  >
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName"  value="${student.lastName}"  >
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email"  value="${student.emailAddress}"  >
            </div>
            <input type="hidden" value="update-student" name="action-type" />
            <button type="submit" class="btn btn-success bg-purple border-purple">Submit</button>
        </form>
    </section>
</main>
<jsp:include page="../inc/footer.jsp" />