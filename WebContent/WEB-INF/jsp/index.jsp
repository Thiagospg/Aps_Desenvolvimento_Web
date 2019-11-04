<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css" />
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<div class="login">
		<form action="HomeController" method="post">

			<div>
				<input type="text" name="usuario" id="username" placeholder="Usuario"/>
			</div>
			<div>
				<input type="password" name="senha" id="password" placeholder="Senha"/>
			</div>
			<div class="button">
				<input type="submit" value="Logar" name="button" />
			</div>
		</form>

		<p class="error">${error}</p>
	</div>
	<div class="shadow"></div>
</body>
</html>


