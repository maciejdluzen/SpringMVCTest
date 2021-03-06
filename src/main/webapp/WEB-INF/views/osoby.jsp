<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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


<title>Osoby</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<p class="text-center alert alert-warning">Lista wszystkich osób:</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<sec:authorize access="isAuthenticated()">
				
					<sec:authentication property="principal.username" 
					var="loggedUser" scope="request"/>
					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<p class="text-left alert alert-success">Jesteś zalogowany jako Admin. 
						Twoja nazwa użytkownika to: ${loggedUser}</p>
					</sec:authorize>
					
					<sec:authorize access="hasRole('ROLE_USER')">
						<p class="text-left alert alert-success">Jesteś zalogowany jako User. 
						Twoja nazwa użytkownika to: ${loggedUser}</p>
					</sec:authorize>
						
				</sec:authorize>
			</div>
		</div>
		
		<a href="<c:url value="j_spring_security_logout"/>"
				class="btn btn-warning btn-mini">Wyloguj</a>
		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover">
					<tr>
						<th>Id</th>
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>Login</th>
						<th>Hasło</th>
						<th>Edycja</th>
						<th>Usuń</th>
						<th>Szczegóły</th>
					</tr>
					<c:forEach items="${osoby}" var="osoba">
						<tr>
							<td>${osoba.id}</td>
							<td>${osoba.imie}</td>
							<td>${osoba.nazwisko}</td>
							<td>${osoba.login}</td>
							<td>${osoba.haslo}</td>
							<td><button	class="btn btn-warning btn-sm 
												glyphicon glyphicon-edit"
									title="edytuj osobę" 
									onclick="OsobaUtils.prepareForEditOsoba(${osoba.id})">
								</button></td>
							<td><button	class="btn btn-danger btn-sm 
												glyphicon glyphicon-remove"
									title="usuń osobę"
									onclick="OsobaUtils.deleteOsoba(${osoba.id})"> 
								</button></td>
							<td>
								<c:url value="/osoba/pomiary" var="pomiary">
									<c:param name="id" value="${osoba.id}"/>
								</c:url>
							<a href="/mojafirma/osoba/pomiary/${osoba.id}">Pomiary</a>
							</td>		
						</tr>
					</c:forEach>
				</table>
				<h3 class="bg-primary">Dodaj osobę:</h3>
		<spring:url value="/osoba" var="osobaUrl" />
		
		<sf:form class="form-horizontal" method="POST" commandName="osoba"
			action="${parkingsUrl}" acceptCharset="UTF-8">
			<fieldset>
			
				<div class="control-group">
					<sf:label class="control-label" path="imie">Imię:</sf:label>
					<div class="controls">
						<sf:input path="imie" placeholder="podaj imię"
							class="input-xlarge" />
						<sf:errors path="imie" />						
					</div>
				</div>
				
				<div class="control-group">
					<sf:label class="control-label" path="nazwisko">Nazwisko:</sf:label>
					<div class="controls">
						<sf:input path="nazwisko" placeholder="podaj nazwisko"
							class="input-xlarge" />
						<sf:errors path="nazwisko" />						
					</div>
				</div>
				
				<div class="control-group">
					<sf:label class="control-label" path="login">Login:</sf:label>
					<div class="controls">
						<sf:input path="login" placeholder="podaj login"
							class="input-xlarge" />
						<sf:errors path="login" />						
					</div>
				</div>
				
				<div class="control-group">
					<sf:label class="control-label" path="haslo">Hasło:</sf:label>
					<div class="controls">
						<sf:password path="haslo" placeholder="podaj hasło"
							class="input-xlarge" />
						<sf:errors path="haslo" />						
					</div>
				</div>
				
				<div class="control-group">
					<sf:label class="control-label" path="wiek">Wiek:</sf:label>
					<div class="controls">
						<sf:input path="wiek" placeholder="podaj wiek" 
							class="input-xlarge" />
						<sf:errors path="wiek" />						
					</div>
				</div>

				<div class="control-group">
					<div class="controls">
						<button class="btn btn-success" id=”addOsobaBtn”>Dodaj osobę</button>
						
						<button class="btn btn-success" id=”editBtn” onclick="OsobaUtils.editOsoba(${osoba.id})">Edytuj osobę</button>
						
						<button class="btn btn-success" id=”cancelEditBtn” onclick="OsobaUtils.cancelEdit()">Anuluj edycję</button>
					</div>
				</div>
			</fieldset>
		</sf:form>
				
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/osoba.js" />"></script>	
</body>

</html>