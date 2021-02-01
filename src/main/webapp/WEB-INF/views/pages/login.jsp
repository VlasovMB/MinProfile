<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="form-user">

    <form method="POST" action="${pageContext.request.contextPath}/login">

        <div class="card text-dark bg-light mb-3 justify-content-center">
            <div class="card-header">
                <h1 class="h3 mb-3 fw-normal">Вход в личный кабинет</h1>
            </div>
            <div class="card-body">
                <div class="form-group ${error != null ? 'text-danger' : 'text-primary'}">
                    <span>${message}</span>
                    <input name="username"
                           type="text"
                           placeholder="Логин"
                           class="form-control mb-2 mt-2">

                    <input name="password"
                           type="password"
                           placeholder="Пароль"
                           class="form-control mb-2">
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>
        </div>
        <button class="w-100 btn btn-lg btn-primary btn-block mb-2" type="submit">Войти</button>

        <a class="text-center" href="${contextPath}/registration">Зарегистрироваться</a>

    </form>
</div>

<div class="alert alert-warning alert-dismissible fade show w-25 m-auto" role="alert">
    <p><strong>Стандарные пользователи:</strong></p>
    <p><strong>admin </strong>admin</p>
    <p><strong>user </strong>user</p>
    <p><strong>user2 </strong>user2</p>

    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>


<c:forEach var="role"
           items="${pageContext.request.userPrincipal.principal.authorities}">
    <c:if test="${role.authority == 'role_anonymous' }">
        <div class="alert alert-warning alert-dismissible fade show w-25 m-auto" role="alert">
            <p><strong>Стандарные пользователи:</strong></p>
            <p><strong>admin </strong>admin</p>
            <p><strong>user </strong>user</p>
            <p><strong>user2 </strong>user2</p>

            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
</c:forEach>