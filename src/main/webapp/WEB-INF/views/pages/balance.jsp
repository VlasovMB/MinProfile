<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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



<c:forEach var="role"
           items="${pageContext.request.userPrincipal.principal.authorities}">
    <c:if test="${role.authority == 'role_admin' }">
        <div class="alert alert-danger alert-dismissible fade show w-25 m-auto" role="alert">
            <p><strong>Через кнопку консоль можно зайти в H2SQL in-memory базу данных</strong></p>
            <p><strong>URL: </strong>jdbc:h2:mem:admin</p>
            <p><strong>username: </strong>sa</p>
            <p><strong>password: </strong></p>

            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
</c:forEach>
