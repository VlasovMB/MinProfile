<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div class="form-user">
    <form:form method="POST" modelAttribute="userForm">


        <div class="card text-dark bg-light mb-3 justify-content-center">
            <div class="card-header">
                <h1 class="h3 mb-3 fw-normal">Регистрация</h1>
            </div>
            <div class="card-body">
                <spring:bind path="user.username">
                    <form:input path="user.username"
                                type="text"
                                placeholder="Логин"
                                class="form-control mb-1"></form:input>
                    <form:errors>
                    </form:errors>
                </spring:bind>

                <spring:bind path="user.password">
                    <form:input path="user.password"
                                type="password"
                                placeholder="Пароль"
                                class="form-control mb-1"></form:input>
                    <form:errors>
                    </form:errors>
                </spring:bind>

                <spring:bind path="user.passwordConfirm">
                    <form:input path="user.passwordConfirm"
                                type="password"
                                placeholder="Повторите пароль"
                                class="form-control mb-5"></form:input>
                    <form:errors>
                    </form:errors>
                </spring:bind>

                <spring:bind path="userAccount.firstName">
                    <form:input path="userAccount.firstName"
                                type="text"
                                placeholder="Ваше имя"
                                class="form-control mb-1"></form:input>
                    <form:errors>
                    </form:errors>
                </spring:bind>

                <spring:bind path="userAccount.lastName">
                    <form:input path="userAccount.lastName"
                                type="text"
                                placeholder="Ваша фамилия"
                                class="form-control mb-1"></form:input>
                    <form:errors>
                    </form:errors>
                </spring:bind>
            </div>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Зарегистрироваться</button>
    </form:form>
</div>






