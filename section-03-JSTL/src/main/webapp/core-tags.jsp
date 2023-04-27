<%--
  Created by IntelliJ IDEA.
  User: marty
  Date: 11/13/22
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.mdbytes.classes.Customer" %>
<jsp:include page="header.jsp"/>
<main class="container">
    <section class="container-fixed pt-5">
        <h2 class="mb-3">JSTL Core Tags</h2>

        <h3>Cities Example</h3>
        <p>Building a list with forEach</p>
        <%
            // create sample data
            String[] cities = {"Mumbai", "Singapore", "Philadelphia"};

            pageContext.setAttribute("cities", cities);
        %>

        <ul>
            <c:forEach var="city" items="${cities}">
                <li>${city}</li>
            </c:forEach>
        </ul>

        <h3>Customer Example</h3>
        <p>Building a table with forEach</p>
        <%
            List<Customer> data = new ArrayList<>();

            data.add(new Customer("John", "Doe", false));
            data.add(new Customer("Matthew", "Johnson", false));
            data.add(new Customer("Mary", "Public", true));
            data.add(new Customer("Jimmy", "Maroni", false));
            data.add(new Customer("Frank", "Smith", false));

            pageContext.setAttribute("customers", data);
        %>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Preferred Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.goldCustomer}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Conditional Testing with "if"</h3>
        <p>Changing the output for preferred customers...</p>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Preferred Status?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <c:if test="${customer.goldCustomer}">
                        <td>Yes</td>
                    </c:if>
                    <c:if test="${not customer.goldCustomer}">
                        <td>No</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Using Choose Statement</h3>
        <p>A cleaner way to handle multiple options</p>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Preferred Status?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <c:choose>
                        <c:when test="${customer.goldCustomer}">
                            <td>Yes</td>
                        </c:when>
                        <c:otherwise>
                            <td>No</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<jsp:include page="footer.jsp"/>