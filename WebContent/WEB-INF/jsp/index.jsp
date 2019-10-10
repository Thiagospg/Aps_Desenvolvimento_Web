<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<form action="HomeController" method="post">
		<label for="usuario">Usuário: </label> <input type="text"
			placeholder="usuario" name="usuario"> <label for="senha">Senha:
		</label> <input type="password" placeholder="senha" name="senha"> <input
			type="submit" value="Logar" name="button" >
	</form>
	<label>${error}</label>
</body>
</html>


