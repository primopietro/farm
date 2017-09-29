<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.cgi.farm.model.Food,com.cgi.farm.model.Animal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${hasAnimals}">
		<table class="table table-striped">
			<tr>
				<th>Name Type</th>
				<th>Food Stored</th>
				<th>Food Eaten</th>
			</tr>
			<c:forEach items="${farmToBeAdded.getAnimals()}" var="anAnimal">
				<tr>
					<td>${anAnimal.getType().getName() }</td>
					<td><c:set var="totalAmount" value="${0}" /> <c:forEach
							items="${anAnimal.getFoodList()}" var="aFood">
							<c:set var="totalAmount"
								value="${totalAmount + aFood.getQuantity()}" />
						</c:forEach> ${totalAmount}</td>
					<td>${anAnimal.getfoodEated() }</td>

				</tr>
			</c:forEach>
		</table>

		<table class="table table-striped">
			<tr>
				<th>Name</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${foodTotals}" var="foodTotal">
				<tr>
			    <td>  ${foodTotal.key}</td>
			    <td> ${foodTotal.value}</td>
			    </tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		
	No animals
</c:otherwise>
</c:choose>