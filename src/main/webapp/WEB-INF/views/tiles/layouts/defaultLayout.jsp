<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <link href="<c:url value='/static/css/site.css' />" rel="stylesheet"/>
</head>

<body class="site-body site-center">

<header class="site-header">
    <tiles:insertAttribute name="header"/>
</header>

<section class="background-grey content-site">
    <tiles:insertAttribute name="body"/>
</section>

</body>
</html>