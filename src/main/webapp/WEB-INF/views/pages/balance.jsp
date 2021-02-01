<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="form-user">
    <div class="card text-dark bg-light mb-3 justify-content-center">
        <div class="card-header">
            <h4 class="h3 mb-3 fw-normal text-capitalize">${account.firstName} ${account.lastName}</h4>

        </div>
        <div class="card-body">Баланс:
            <h1>${account.balance} $</h1>
        </div>
    </div>
</div>

