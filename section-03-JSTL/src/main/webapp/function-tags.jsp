<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" />
<main class="container">
    <section class="container-fixed">
        <h2 class="mt-5">Function Tags</h2><br/>
        <h3>Using fn:length</h3>
        <c:set var="data" value="MDBytes" />
        <p>Length of the string <b>${data}</b>: ${fn:length(data)}</p>
        
        <h3>Uppercase</h3>
        <p>Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}</p>

        <h3>Uppercase</h3>
        <p>Does the string <b>${data}</b> starts with "MD": ${fn:startsWith(data,"MD")}</p>

        <h3>Split and Join Functions</h3>
        <c:set var="data" value="Singapore,Tokyo,Mumbai,London" />
        <p>We start with: "${data}"</p>
        <c:set var="cities" value="${fn:split(data,',')}" />
        <p>Split we can use forEach to make a list</p>
        <ul>
            <c:forEach var="city" items="${cities}">
                <li>${city}</li>
            </c:forEach>
        </ul>
        <c:set var="citiesString" value="${fn:join(cities,'*')}" />
        <p>Joining the split array with * we have: "${citiesString}"</p>


    </section>
</main>
<jsp:include page="footer.jsp" />