<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<main class="container">
    <section class="container-fixed">
        <h1><%= "Hello JSTL!" %></h1>
        <a href="core-tags.jsp">A simple first example (forEach)</a>
        <br/><br/>
        <a href="hello-servlet">Hello Servlet</a>
    </section>
</main>
<jsp:include page="footer.jsp" />

