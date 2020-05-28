<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Pomiary</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<p class="text-center alert alert-warning">Lista pomiarów ciśnienia:</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
			<h2>Imię i nazwisko: ${osoba.imie} ${osoba.nazwisko}</h2>
				<table class="table table-striped table-hover">
					<tr>
						<th>Id</th>
						<th>Data pomiaru</th>
						<th>Puls</th>
						<th>Rozkurczowe</th>
						<th>Skurczowe</th>
						<th>Edycja</th>
						<th>Usuń</th>
					</tr>
					<c:forEach items="${pomiary}" var="pomiar">
						<tr>
							<td>${pomiar.id}</td>
							<td>${pomiar.dataPomiaru}</td>
							<td>${pomiar.puls}</td>
							<td>${pomiar.rozkurczowe}</td>
							<td>${pomiar.skurczowe}</td>
							<td><button	class="btn btn-warning btn-sm 
												glyphicon glyphicon-edit"
									title="edytuj osobę" 
									onclick="">
								</button></td>
							<td><button	class="btn btn-danger btn-sm 
												glyphicon glyphicon-remove"
									title="usuń osobę"
									onclick=""> 
								</button></td>		
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
</body>

</html>