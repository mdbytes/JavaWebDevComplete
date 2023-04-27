<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.html" />

<main class="container-fluid">
<section class="container pt-5">
<h1>To Do List</h1>
<form action="to-do.jsp">
	Add new item: <input type="text" name="theItem" />
	
	<input class="btn btn-primary" type="submit" value="Submit" />

</form>
<br/>

<%-- <p>Item entered: <%= request.getParameter("theItem") %></p> --%>

<%
List<String> items = (List<String>)session.getAttribute("myToDoList");

if(items == null) {
	items = new ArrayList<String>();
	session.setAttribute("myToDoList",items);
}

String theItem = request.getParameter("theItem");
if(theItem != null && theItem != "" && !items.contains(theItem)) {
	items.add(theItem);
}
%>

<b>To Do List Items: </b><br/>
<ol>
<%
for(String item: items) {
	out.println("<li>"+item+"</li>");
}
%>

</ol>


<br/>
<a class="mt-5" href="index.jsp">Home</a>
</section>
</main>

	
<jsp:include page="my-footer.jsp" />