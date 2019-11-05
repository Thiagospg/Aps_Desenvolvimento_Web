<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/classificacao.css"
	rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<c:if test="${empty usuariosPontuacao}">

		<p>Nenhum aluno respondeu esse questionário</p>

	</c:if>

	<c:if test="${not empty usuariosPontuacao}">
		<table border="1">
			<tr class="header">
				<td><span>Usuário</span></td>
				<td><span>Pontuação</span></td>
			</tr>
			<c:forEach items="${usuariosPontuacao}" var="usuarioPontuacao"
				varStatus="status">

				<tr>
					<td>${usuarioPontuacao}</td>

					<td class="pontos">${pontosPontuacao[status.index]}</td>
				</tr>

			</c:forEach>
		</table>
	</c:if>


</body>
</html>