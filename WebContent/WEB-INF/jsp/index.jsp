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
	
		<form action="HomeController" method="post">
			
					<label for="usuario">USERNAME</label> 
					<input	type="text" name="usuario"/>
				
					<label for="senha">PASSWORD</label> 
					<input type="password" name="senha"/>
				
					<input type="submit" value="Logar" name="button" />		
		</form>
	
	<label>${error}</label>


	
</body>
</html>


