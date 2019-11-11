<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<p>
			Id do questionario: <span class="resultado">${questionarioId}</span>
		</p>
		<p>
			Seu usuario: <span class="resultado">${usuario}</span>
		</p>
		<p>
			Sua pontuacao: <span class="resultado">${pontuacao}</span>
		</p>

		<p>
			Respostas corretas: <span class="correta">${correta1}</span><span class="correta"> ${correta2}</span><span class="correta">
				${correta3}</span><span class="correta"> ${correta4}</span>
		</p>



		<form action="HomeController" method="post">
			<input type="submit" name="button" value="Voltar" />
		</form>
	</div>



</body>
</html>