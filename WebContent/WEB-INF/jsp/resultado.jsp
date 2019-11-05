<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/resultado.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p>Id do questionario: <span class="resultado">${questionarioId}</span></p>
		<p>Seu usuario: <span class="resultado">${usuario}</span></p>
		<p>Sua pontuacao: <span class="resultado">${pontuacao}</span></p>

		<form action="HomeController" method="post">
			<input type="submit" name="button" value="Voltar" />
		</form>
	</div>



</body>
</html>