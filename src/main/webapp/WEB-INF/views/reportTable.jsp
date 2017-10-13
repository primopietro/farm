<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.cgi.farm.model.Food,com.cgi.farm.model.Animal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="text-align: left;">
	<div class="row">
		<div class="col-md-1">Adr:</div>
		<div class="col-md-11">${farm.getAddress()}</div>
	</div>
	<h5>Farmer</h5>
	<div class="row">
		<div class="col-md-1">Nom:</div>
		<div class="col-md-10">${farm.getFarmer().getName()}</div>
	</div>
	<div class="row">
		<div class="col-md-1">Age:</div>
		<div class="col-md-11">${farm.getFarmer().getAge()}</div>
	</div>
	<h5>Liste des animaux</h5>
	<c:forEach items="${farm.getAnimals()}" var="anAnimal">
		<div class="row">
			<div class="col-md-2">Animal:</div>
			<div class="col-md-1"></div>
			<div class="col-md-9">${anAnimal.getId_animal()}</div>
			
			<div class="col-md-1"></div>
			<div class="col-md-2">Type:</div>
			<div class="col-md-9">${anAnimal.getType().getName()}</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">Food eaten:</div>
			<div class="col-md-9">${anAnimal.getfoodEated()}</div>
		</div>
	</c:forEach>
</div>