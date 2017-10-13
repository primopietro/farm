<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farm | Create farm</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">

		<form:form method="POST" modelAttribute="farm" class="form-horizontal">

			<div class="row">
				<div class="form-group col-md-11  lead">
					<div style="display: table; min-width: 350px">

						<label class="col-md-12 control-label" for="address"
							style="float: left; max-width: 350px;">Farm</label>
						<div class="col-md-11">

							<form:input placeholder="Addresse" type="text" path="address"
								id="address" class="form-control input-sm" />

							<div class="has-error">
								<form:errors path="address" class="help-inline" />
							</div>
						</div>
						<div class=" col-md-1">
							<a class="btn btn-primary btn-sm " id="verifyFarmAdress"
								style="float: left; margin-left: 15px;">OK</a>
						</div>
					</div>
				</div>

			</div>
		</form:form>
		<form:form method="POST" modelAttribute="farmer"
			class="form-horizontal">
			<div class="row" id="formFarmer">
				<div class="form-group col-md-11  lead">
					<div style="display: table; min-width: 350px">

						<label class="col-md-12 control-label" for="address"
							style="float: left; max-width: 350px;">Farmer</label>
						<div class="col-md-11">

							<form:input placeholder="Name" type="text" path="name" id="name"
								class="form-control input-sm" />

							<div class="has-error">
								<form:errors path="name" class="help-inline" />
							</div>
						</div>
						<div class="col-md-11">

							<form:input placeholder="Age" type="text" path="age" id="age"
								class="form-control input-sm" />

							<div class="has-error">
								<form:errors path="age" class="help-inline" />
							</div>
						</div>
						<div class=" col-md-1">
							<a class="btn btn-primary btn-sm " id="verifyFarmer"
								style="float: left; margin-left: 15px;">OK</a>
						</div>
					</div>
				</div>

			</div>
		</form:form>
		<form:form method="POST" modelAttribute="animal"
			class="form-horizontal">
			<div class="row" id="animalForm">
				<div class="form-group col-md-11  lead">
					<div style="display: table; min-width: 350px">
						<label class="col-md-12 control-label" for="address"
							style="float: left; max-width: 350px;">Animal</label>

					</div>

					<div class="col-lg-12">
						<select id="animalType" style="float: left;">
							<c:forEach items="${animalTypes}" var="animalTypes">
								<option value="${animalTypes.name}">${animalTypes.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-lg-5">
						<select id="foodType" style="float: left;">
							<c:forEach items="${foodTypes}" var="foodTypes">
								<option value="${foodTypes.name}">${foodTypes.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-lg-5">
						<form:input placeholder="QTY" type="number" path="foodEated"
							id="foodEated" class="form-control input-sm" />
					</div>
					<div class="col-lg-2">
						<a class="btn btn-primary btn-sm " id="addFoodAnimal"
							style="float: left; margin-left: 15px;">ADD</a>
					</div>
				</div>
				<div class="col-lg-12" id="animalDataTable">
					<%@include file="animalTables.jsp"%>
				</div>

				<!-- <div class="col-lg-12">
					<a class="btn btn-primary btn-sm " id="addForm"
								style="float: left; margin-left: 15px;">ADD</a>
					</div> -->

			</div>
		</form:form>
		<div class="row">
			<div class="form-actions floatRight">
				<a class="btn btn-primary btn-sm" href="<c:url value='/list' />">Cancel</a>
				<a id="saveFarm" class="btn btn-primary btn-sm">Register</a>
			</div>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value='/static/javascript/app.js' />"></script>
</body>
</html>