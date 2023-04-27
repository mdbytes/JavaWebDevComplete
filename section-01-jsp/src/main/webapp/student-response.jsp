
<jsp:include page="header.html" />
<main class="container-fluid">

<section class="container pt-5">
The student is confirmed: ${param.firstName} ${param.lastName}<br/>

The student's country:  ${param.country}<br/>

The student's favorite programming language: ${param.favoriteLanguage}<br/>

The student's known languages: 
<ul>
<%
	String[] langs = request.getParameterValues("knownLanguage");

	if(langs != null) {
		for(String lang: langs) {
			out.println("<li>"+ lang + "</li>");
		}	
	} else {
		out.println("none");
	}
	
%>

</ul>

<a class="btn btn-primary mt-5" href="index.jsp">Home</a>
</section>
</main>

<jsp:include page="my-footer.jsp" />