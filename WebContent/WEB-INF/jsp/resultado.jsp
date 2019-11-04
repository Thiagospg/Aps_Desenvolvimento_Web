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
	<div>
		<p id="idQuestionario">Id do questionario: ${questionarioId}</p>
		<p id="usuario">Seu usuario: ${usuario}</p>
		<p id="pontuacao">Sua pontuacao: ${pontuacao}</p>
	</div>
	
	<div>
		<form action="HomeController" method="post">
			<input type="submit" name="button" value="Voltar" />
		</form>
	
	</div>
</body>
</html>