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

	<div class="container">
		<p>Insira o ID de um Questionário</p>
		<form class="formId" action="HomeController" method="post">
			<input class="inputId" name="questionarioId" type="text" />

			<div>
				<input class="irQuestionario" name="button" value="Ir ao questionario" type="submit" />
			</div>
		</form>

		<form action="HomeController" method="post">
			<input class="btnDeslogar" name="button" value="Deslogar"
				type="submit" />
		</form>
	</div>
</body>
</html>