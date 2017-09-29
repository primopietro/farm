<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farm | index</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>


</head>

<body>
	<div class="generic-container">

		<a href="<c:url value='/CreateFarm' />">Create Farm</a>

	</div>

	<div class="generic-container">

		<a href="<c:url value='/CreateFarm' />">Feed Animals</a>

	</div>

	<div class="generic-container">

		<a href="<c:url value='/Report' />">Report</a>

	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value='/static/javascript/app.js' />"></script>
</body>
</html>