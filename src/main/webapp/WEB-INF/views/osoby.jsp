<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<table class="table table-striped table-hover">
					<tr>
						<th>Id</th>
						<th>Imię</th>
						<th>Nazwisko</th>
					</tr>
					<c:forEach items="${osoby}" var="osoba">
						<tr>
							<td>${osoba.id}</td>
							<td>${osoba.imie}</td>
							<td>${osoba.nazwisko}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>