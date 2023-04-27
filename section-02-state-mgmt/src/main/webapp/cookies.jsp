<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.html" />

<main class="container-fluid">
<section class="container pt-5">
<h1>Training Portal</h1>

<%
String favLang = "Java";
Cookie[] cookies = request.getCookies();

if(cookies != null) {
	for(Cookie cookie: cookies) {
		if("myApp.favoriteLanguage".equals(cookie.getName())) {
			favLang = cookie.getValue();
			break;
		}
	}
}


%>

<h4>New books for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>Latest news for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

<h4>Hot jobs for <%= favLang %></h4>
<ul>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
<li>blah blah blah</li>
</ul>

We set your favorite language to: ${param.favoriteLanguage}
<br/>
<a class="mt-5" href="cookies-form.jsp">Change your favorite language.</a>
<br/>
<a class="mt-5" href="index.jsp">Home</a>

</section>
</main>

	
<jsp:include page="my-footer.jsp" />