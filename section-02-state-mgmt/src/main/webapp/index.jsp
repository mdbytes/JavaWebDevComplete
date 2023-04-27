<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="header.html" />

<body class="container-fluid">
	<main class="container pt-5">

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
		
		
		
		<section>
		<h2>State Management</h2>
		
		<h3>JSP Session Object</h3>
		
		<p>Such as a shopping cart for a unique user</p>
		<p>Or the following "To Do List" application.</p>
		
		<a class="mt-5" href="to-do.jsp">To Do List App</a>
		
		<h3>Using Cookies</h3>
		
		<p>Such as with the following training portal app</p>
		
		<a class="mt-5" href="cookies-form.jsp">Training Portal</a>
		
		</section>
	</main>
	
	
	
	<jsp:include page="my-footer.jsp" />