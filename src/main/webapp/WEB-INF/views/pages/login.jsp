<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="form-user">

    <form method="POST" action="${contextPath}/login">

        <div class="card text-dark bg-light mb-3 justify-content-center">
            <div class="card-header">
                <h1 class="h3 mb-3 fw-normal">Вход в личный кабинет</h1>
            </div>
            <div class="card-body">
                <div class="form-group ${error != null ? 'has-error' : ''}">

                    <input name="username"
                           type="text"
                           placeholder="Логин"
                           class="form-control mb-1">

                    <input name="password"
                           type="password"
                           placeholder="Пароль"
                           class="form-control mb-1">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>
        </div>
        <button class="w-100 btn btn-lg btn-primary btn-block mb-2" type="submit">Войти</button>

        <a class="text-center" href="${contextPath}/registration">Зарегистрироваться</a>

    </form>
</div>


