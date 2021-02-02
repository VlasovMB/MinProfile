<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="form-user">
    <div class="card text-dark bg-light mb-3 justify-content-center">
        <div class="card-header">
            <h4 class="h3 mb-3 fw-normal text-capitalize">Доступ запрещен</h4>

        </div>
        <div class="card-body">
                <a class="w-100 btn btn-lg btn-success btn-block"
                   href="${pageContext.request.contextPath}/login">Домой</a>
        </div>
    </div>
</div>
