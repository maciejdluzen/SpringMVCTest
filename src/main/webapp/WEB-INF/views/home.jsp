<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>OSOBA: ${osoba.imie}, ${osoba.nazwisko}</P>

<ul>
<c:forEach items="${osoby}" var="os">
	<li> id: ${os.id}; imie: ${os.imie}; nazwisko: ${os.nazwisko }</li>
</c:forEach>
</ul>
</body>
</html>
