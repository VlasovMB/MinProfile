<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>

<body>

<header>
    <tiles:insertAttribute name="header"/>
</header>

<section class="text-center">
    <tiles:insertAttribute name="body"/>
</section>


<script src='${contextPath}/static/js/bootstrap.js'></script>
<script src='${contextPath}/static/js/ajaxJquery.js'></script>
</body>
</html>