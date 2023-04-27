<jsp:include page="header.html" />
<body class=container-fluid">

	<main class="container pt-5">
		<h1>Student Response Form</h1>
		<form action="student-response.jsp">
			<div class="mb-3">
				<label for="firstName" class="form-label">First Name</label> <input
					type="text" class="form-control" id="firstName" name="firstName"
					aria-describedby="firstName">

			</div>
			<div class="mb-3">
				<label for="lastName" class="form-label">Last Name</label> <input
					type="text" class="form-control" id="lastName" name="lastName"
					aria-describedby="lastName">
			</div>
			<br />
			<h3>Country</h3>
			<select name="country" class="form-select" aria-label="Default select example">
				<option selected>Select Country</option>
				<option value="Brazil">Brazil</option>
				<option value="France">France</option>
				<option value="Germany">Germany</option>
				<option value="United States">United States</option>
			</select> <br />	
			

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
			
			<h3>Languages you know</h3>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="knownLanguage"
					id="java" value="Java"> <label class="form-check-label"
					for="java">Java</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="knownLanguage"
					id="c-sharp"  value="C#"> <label class="form-check-label"
					for="c-sharp">C#</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="knownLanguage"
					id="php" value="PHP"> <label class="form-check-label"
					for="php">PHP</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" name="knownLanguage"
					id="ruby" value="Ruby"> <label class="form-check-label"
					for="ruby">Ruby</label>
			</div>
			

			<button type="submit" class="btn btn-primary mt-5">Submit</button>
		</form>
<br/>
		<button class="btn btn-primary" href="index.jsp">Home</button>
	</main>
	<jsp:include page="my-footer.jsp" />