<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.html" />

<main class="container-fluid">
<section class="container pt-5">
<h1>Student Confirmation Page</h1>

<%
String favLang = request.getParameter("favoriteLanguage");
Cookie cookie = new Cookie("myApp.favoriteLanguage",favLang);
cookie.setMaxAge(60*60*24*365);
response.addCookie(cookie);
%>

We set your favorite language to: ${param.favoriteLanguage}
<br/>
<a class="mt-5" href="cookies-form.jsp">Change your selection</a>
<br/>
<a class="mt-5" href="cookies.jsp">Training Portal</a>

</section>
</main>

	
<jsp:include page="my-footer.jsp" />