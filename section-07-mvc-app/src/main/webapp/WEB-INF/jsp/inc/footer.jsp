<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .footer {
        position: absolute;
        position: fixed;
        bottom: 0;
        overflow: hidden;
        width: 100%;
        height: auto;
        line-height: 60px;

    }
</style>
<footer class="footer bg-green border-green">
    <div class="container-fixed">
        <p class="text-center text-white">
            <%
                Date today = new java.util.Date();
                DateFormat df = new SimpleDateFormat("yyyy");
                String strToday = df.format(today);
            %>
            &copy <%= strToday %>, Foobar University, MD Bytes, MD Web Technologies<br/>

        </p>
    </div>
</footer>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
