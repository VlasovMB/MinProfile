<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="form-user">
    <form:form method="POST" modelAttribute="userForm">


        <div class="card text-dark bg-light mb-3 justify-content-center">
            <div class="card-header">
                <h1 class="h3 mb-3 fw-normal">Регистрация</h1>
            </div>
            <div class="card-body">
                <spring:bind path="user.username">
                    <div class="form-group mb-1 ${status.error ? 'text-danger' : ''}">
                        <form:input path="user.username"
                                    type="text"
                                    placeholder="Логин"
                                    class="form-control"
                                    pattern="[A-Za-z]{,30}"></form:input>
                        <form:errors path="user.username"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="user.password">
                    <div class="form-group mb-1 ${status.error ? 'text-danger' : ''}">
                        <form:input path="user.password"
                                    type="password"
                                    placeholder="Пароль"
                                    class="form-control"></form:input>
                        <form:errors path="user.password">
                        </form:errors>


                    </div>
                </spring:bind>

                <spring:bind path="user.passwordConfirm">
                    <div class="form-group mb-5 ${status.error ? 'text-danger' : ''}">
                        <form:input path="user.passwordConfirm"
                                    type="password"
                                    placeholder="Повторите пароль"
                                    class="form-control"></form:input>
                        <form:errors path="user.passwordConfirm">
                        </form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="userAccount.firstName">
                    <div class="form-group mb-1 ${status.error ? 'text-danger' : ''}">
                        <form:input path="userAccount.firstName"
                                    type="text"
                                    placeholder="Ваше имя"
                                    class="form-control"></form:input>

                        <form:errors path="userAccount.firstName">
                        </form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="userAccount.lastName">
                    <div class="form-group mb-2 ${status.error ? 'text-danger' : ''}">
                        <form:input path="userAccount.lastName"
                                    type="text"
                                    placeholder="Ваша фамилия"
                                    class="form-control"></form:input>
                        <form:errors path="userAccount.lastName">
                        </form:errors>
                    </div>

                </spring:bind>
            </div>
        </div>
        <button
                class="w-100 btn btn-lg btn-primary"
                type="submit">Зарегистрироваться
        </button>
    </form:form>
</div>






