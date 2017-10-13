<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farm | Feed animals</title>
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
							style="float: left; max-width: 350px;">Generate Report</label>
						<div class="col-md-11">

							<form:input placeholder="Farm address" type="text" path="address"
								id="address" class="form-control input-sm" />

						</div>
						<div class=" col-md-1">
							<a class="btn btn-primary btn-sm " id="generateReport"
								style="float: left; margin-left: 15px;">Generate</a>
						</div>
					</div>
				</div>

			</div>
		</form:form>
		<div id="reportSection">
			<div id="reportTables">
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<a class="btn btn-primary btn-sm" href="<c:url value='/list' />">Cancel</a>
			</div>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value='/static/javascript/app.js' />"></script>
</body>
</html>