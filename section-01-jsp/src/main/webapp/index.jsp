<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mdbytes.jsp.*,java.util.*"%>

<jsp:include page="header.html" />

<body class="container-fluid">
	<main class="container pt-5">
		<!-- Lecture 15 -->
		<h2>Hello world of Java web development!</h2>
		<p>JSP files - a combination of html and Java code</p>
		<!-- Lecture 16 -->
		<h3>JSP Expressions</h3>
		The time on the server is
		<%=new java.util.Date()%>
		<p><%=new String("Hello World").toUpperCase()%></p>
		<p>
			25 multiplied by 4 equals
			<%=25 * 4%></p>
		<p>
			Is 75 less than 69?
			<%=75 < 69%></p>


		<!-- Lecture 16 -->
		<h3>JSP Scriptlets</h3>
		<%
		for (int i = 1; i <= 5; i++) {
			out.println("<p>I really love to code " + i + ". REALLY!</p>");
		}
		%>

		<!-- Lecture 18 -->
		<h3>JSP Declarations</h3>

		<%!String makeItLower(String data) {
		return data.toLowerCase();
	}%>

		<p>
			Lower case of "Hello World":
			<%=makeItLower("Hello World")%></p>

		<!-- Best practice with scriptlets and declarations:  -->
		<!-- Minimize scriptlet and expression code -->
		<!-- Refactor into a separate Java class -->
		<!-- Make use of MVC -->

		<!-- Lecture 19 -->
		<h3>Calling a Java Class From JSP</h3>
		<p>Import file with page import at top of file</p>
		<p>Use methods from the class where you like, such as ...</p>
		<%=FunUtils.makeItLower("FUN FUN FUN")%>

		<h3>JSP Server Objects</h3>

		<section>
			<table>
				<thead>
					<tr>
						<th>Object</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>request</td>
						<td>Contains http request headers</td>
					</tr>
					<tr>
						<td>response</td>
						<td>provides http support for sending responses</td>
					</tr>
					<tr>
						<td>out</td>
						<td>JspWriter for including content in the HTML page</td>
					</tr>
					<tr>
						<td>session</td>
						<td>Unique session for each user of the web application</td>

					</tr>
					<tr>
						<td>application</td>
						<td>shared data for all users of the web application</td>
					</tr>
				</tbody>
			</table>

			<h3>Testing built-in objects</h3>

			<p>
				Request user agent :
				<%=request.getHeader("User-Agent")%></p>

			<p>
				Request user language:
				<%=request.getLocale()%></p>

		</section>

		<h3>Including other files</h3>
		<p>Commonly used for header and footer</p>
		
		<a class="mt-5" href="student-form.jsp">Student form page</a>
		
		<section>
		<h3>JSP Session Object</h3>
		
		<p>Such as a shopping cart for a unique user</p>
		</section>
	</main>
	
	
	
	<jsp:include page="my-footer.jsp" />