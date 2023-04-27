<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="header.jsp" />
<main class="container">
    <section class="container-fixed">
        <h2 class="mt-5 mb-5">Internationalization (i18n)</h2>
        <div class="links">
            <p>Click on any language to change the display</p>
        <a href="i18n.jsp?theLocale=en_US">English (US)</a>&nbsp|
        <a href="i18n.jsp?theLocale=es_ES">Spanish (Spain)</a>&nbsp|
        <a href="i18n.jsp?theLocale=de_DE">Germain (Germany)</a>
        </div>
        <c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}" scope="session" />
        <fmt:setLocale value="${theLocale}" />
        <fmt:setBundle var="mylabels" basename="com.mdbytes.i18n.mylabels" />

        <h3 class="mt-3 mb-3"><fmt:message key="label.greeting" /></h3>
        <form>
            <div class="mb-3">
                <label for="firstName" class="form-label"><fmt:message key="label.firstname" /></label>
                <input type="text" class="form-control" id="firstName">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label"><fmt:message key="label.lastname" /></label>
                <input type="text" class="form-control" id="lastName">
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="label.submit" /></button>
        </form>
        <h4><fmt:message key="label.welcome" /></h4>
        <p>Selected locale: ${theLocale}</p>
    </section>
</main>
<jsp:include page="footer.jsp" />