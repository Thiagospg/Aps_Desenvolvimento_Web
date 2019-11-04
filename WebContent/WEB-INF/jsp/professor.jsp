<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/professor.css"
	rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Professor Page</title>
</head>
<body>
	<div class="usuario">
		<span>Seja bem vindo </span><span style="color: red">${usuario}
		</span>
	</div>
	<div class="container">
		<form action="HomeController" method="post">
			<input type="submit" value="Cadastrar" name="button" />
		</form>
		<form action="HomeController" method="post">
			<input type="submit" value="Resultado Questionario" name="button" />
		</form>

		<form action="HomeController" method="post">
			<input name="button" value="Deslogar" type="submit" />
		</form>
		<p class="error">${error}</p>
	</div>
</body>
</html>