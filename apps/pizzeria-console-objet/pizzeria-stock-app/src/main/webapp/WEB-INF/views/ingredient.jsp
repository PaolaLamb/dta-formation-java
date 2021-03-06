<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liste des ingrédients</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='/css/bootstrap.min.css'></c:url>">

<link rel="stylesheet" href="<c:url value='/css/list.css'></c:url>">

<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>


</head>
	<body>
		<div class="container">
	
			<header>
			<h2>Liste des Ingrédients</h2>
			<a href="<c:url value='/mvc/ingredient/new'></c:url>" class="btn btn-primary btn-sm">Ajouter un ingrédient</a> 
			</header>
		
			
			<table class="table" id="ingredients">
				<thead>
					<tr align=center>
						<th>Id</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Quantité</th>
					</tr>
				</thead>
				<tbody>
	
					<c:forEach var="ingredient" items="${ingreList}">
						<tr>
							<td>${ingredient.id}</td>
							<td>${ingredient.nom}</td>
							<td>${ingredient.prix}</td>
							<td>${ingredient.quantity}</td>
	
							<td><a href="<c:url value='/mvc/ingredient/id'></c:url>"
								class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil"></span> Editer</a> 
								<a href="<c:url value='/mvc/ingredient/delete?nom=${ingredient.nom}'></c:url>"
								class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"></span> Supprimer</a>
							</td>
						</tr>
	
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>