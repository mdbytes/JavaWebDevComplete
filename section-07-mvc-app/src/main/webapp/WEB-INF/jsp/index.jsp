<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="inc/header.jsp" >
    <jsp:param name="pageTitle" value="Home Page"/>
</jsp:include>
<main class="container">
    <section class="container-fixed">

        <div class="row">
            <div class="col-6" style="display: flex; flex-direction:column; align-items: center; justify-content: center;">
                <h1 class="mb-3 mt-5 color-purple">Foobar University</h1>
                <h2 class="mb-3 mt-3 color-purple">Administration Home</h2>
                <img src="${pageContext.request.contextPath}/images/coyotes.png" alt="school logo" class="img-fluid"/>
            </div>
            <div class="col-6" style="display: flex; flex-direction:column; align-items: center; justify-content: center;">
                <h3 class="color-purple">Admin Web Site</h3>
                <a href="${pageContext.request.contextPath}/main" style="display: flex; flex-direction: row; align-items: center; justify-content: center;">
                <img src="${pageContext.request.contextPath}/images/go-button.jpg" alt="school logo" class="img-fluid" style="width:50%"/>
                </a>
            </div>

        </div>


    </section>
</main>
<jsp:include page="inc/footer.jsp" />

