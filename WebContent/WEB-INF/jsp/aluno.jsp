<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/aluno.css"
	rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Aluno Page</title>
</head>
<body>
	<h1>AlUNO</h1>
	<h1>${contextPath}</h1>




	<form action="HomeController" method="post">
		<input name="questionarioId" type="text" /> <input name="button"
			value="Ir ao questionario" type="submit" />
	</form>

	<form action="HomeController" method="post">
		<input name="button" value="Deslogar" type="submit" />
	</form>
</body>
</html>