<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<c:if test="${empty usuariosPontuacao}">

		<p>Nenhum aluno respondeu esse questionário</p>

	</c:if>

	<c:if test="${not empty usuariosPontuacao}">
		<table border="1">
			<tr>
				<td><span>Usuário</span></td>
				<td><span>Pontuação</span></td>
			</tr>
			<c:forEach items="${usuariosPontuacao}" var="usuarioPontuacao"
				varStatus="status">

				<tr>
					<td>${usuarioPontuacao}</td>

					<td>${pontosPontuacao[status.index]}</td>
				</tr>

			</c:forEach>
		</table>
	</c:if>


</body>
</html>