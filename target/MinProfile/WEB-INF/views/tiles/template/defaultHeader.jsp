<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom shadow-sm bg-dark text-white">
    <a class="h5 my-0 me-md-auto fw-normal btn btn-outline-light">
        <c:if test="${pageContext.request.userPrincipal.name != null}">${pageContext.request.userPrincipal.name}</c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">LOGO</c:if>

    </a>

    <nav class="my-2 my-md-0 me-md-3">


        <c:forEach var="role"
                   items="${pageContext.request.userPrincipal.principal.authorities}">
            <c:if test="${role.authority == 'role_admin' }">
                <a class="btn btn-outline-secondary"
                   href="${pageContext.request.contextPath}/console">Консоль</a>
            </c:if>
        </c:forEach>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="btn btn-outline-info"
               href="${pageContext.request.contextPath}/balance">Баланс</a>
            <a class="btn btn-outline-danger"
               href="${pageContext.request.contextPath}/logout">Выйти</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a class="btn btn-outline-success"
               href="${pageContext.request.contextPath}/login">Вход</a>
            <a class="btn btn-outline-primary"
               href="${pageContext.request.contextPath}/registration">Регистрация</a>
        </c:if>
    </nav>
</div>




