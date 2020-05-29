<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<h3 class="bg-primary">Dodaj osobę:</h3>

				
			
				<sf:form class="form-horizontal" method="POST" commandName="pomiar"
			action="${parkingsUrl}" acceptCharset="UTF-8">
				<fieldset>
				
				<div class="control-group">
					<sf:label class="control-label" path="puls">Puls:</sf:label>
					<div class="controls">
						<sf:input path="puls" placeholder="podaj puls"
							class="input-xlarge" />
						<sf:errors path="puls" />						
					</div>
				</div>
			
				<div class="control-group">
					<sf:label class="control-label" path="rozkurczowe">Rozkurczowe:</sf:label>
					<div class="controls">
						<sf:input path="rozkurczowe" placeholder="podaj rozkurczowe"
							class="input-xlarge" />
						<sf:errors path="rozkurczowe" />						
					</div>
				</div>
				
				<div class="control-group">
					<sf:label class="control-label" path="skurczowe">Skurczowe:</sf:label>
					<div class="controls">
						<sf:input path="skurczowe" placeholder="podaj skurczowe"
							class="input-xlarge" />
						<sf:errors path="skurczowe" />						
					</div>
				</div>
				
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-success" id=”addPomiarBtn”>Dodaj pomiar</button>
					</div>
				</div>
				</fieldset>
			</sf:form>
			</div>
		</div>
	</div>
	
</body>

</html>