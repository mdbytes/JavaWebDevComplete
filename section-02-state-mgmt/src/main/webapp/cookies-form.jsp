<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.html" />

<main class="container-fluid">
<section class="container pt-5">
<h1>Student Form</h1>

<form action="cookies-response.jsp">
<br />
			<h3>Favorite programming language</h3>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="favoriteLanguage"
					id="java" value="Java"> <label class="form-check-label"
					for="java">Java</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="favoriteLanguage"
					id="c-sharp"  value="C#"> <label class="form-check-label"
					for="c-sharp">C#</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="favoriteLanguage"
					id="php" value="PHP"> <label class="form-check-label"
					for="php">PHP</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="favoriteLanguage"
					id="ruby" value="Ruby"> <label class="form-check-label"
					for="ruby">Ruby</label>
			</div><br/><br/>

		<input type="submit" value="Submit" class="btn btn-primary" />
</form>

<br/>
<a class="mt-5" href="index.jsp">Home</a>
</section>
</main>

	
<jsp:include page="my-footer.jsp" />