<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/questionario.css" />
<title>Insert title here</title>
</head>
<body>

	<div id="container">
		<div class="tituloId">
			<p>
				Id do Questionario: <span class="id">${questionarioId}</span>
			</p>
		</div>
		
		<form action="HomeController" method="post">
			<c:forEach items="${questoes}" var="questao" varStatus="id">
				<p class="pergunta">${questao.pergunta }</p>
				<input type="radio" value="1" name="resposta${id.index}" /><span class="resposta">${questao.resposta1}</span><br />
				<input type="radio" value="2" name="resposta${id.index}" /><span class="resposta">${questao.resposta2}</span><br />
				<input type="radio" value="3" name="resposta${id.index}" /><span class="resposta">${questao.resposta3}</span><br />
				<input type="radio" value="4" name="resposta${id.index}" /><span class="resposta">${questao.resposta4}</span><br />
			</c:forEach>
			
			<input type="submit" name="button" value="Enviar Resposta" />
		</form>
		
		<p class="error">${error}</p>
	</div>
</body>
</html>