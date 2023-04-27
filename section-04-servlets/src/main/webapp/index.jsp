<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet Demo</title>
</head>
<body>
<h1><%= "Servlet Demo" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br/>
<a href="HelloWorld">Hello World</a><br/>
<a href="TestParamServlet">Test Param Servlet</a>
<h3 class="mt-5 mb-5">Processing Form Data</h3>
<p>Using GET method</p>
<form action="StudentServlet" method="GET">
    <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstName" name="firstName">
    </div>
    <div class="mb-3">
        <label for="lastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastName" name="lastName">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<p>Using POST method</p>
<form action="StudentServlet" method="POST">
    <div class="mb-3">
        <label for="firstNamePost" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstNamePost" name="firstName">
    </div>
    <div class="mb-3">
        <label for="lastNamePost" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastNamePost" name="lastName">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>