<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table border="1">
			<tr>
				<td><span>Checar Questionario</span></td>
			</tr>
			<c:forEach items="${idsQuestionario}" var="idQuestionario">

				<tr>
					<td>${idQuestionario}</td>
					<td><form action="HomeController" method="post">
							<input type="hidden" name="id" value="${idQuestionario}" /> <input
								style="width: 100%" type="submit" name="button"
								value="Checar" />
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>