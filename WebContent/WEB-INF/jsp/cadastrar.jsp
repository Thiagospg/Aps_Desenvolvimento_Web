<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CADASTRO</h1>
	
	<h2>${countQuestionario}</h2>
	
	<form action="HomeController" method="post">
		<label for="pergunta1">Pergunta: </label>
		<input type="text" name="pergunta1" />
		
		<div>
			<label for="resposta11">Resposta 1: </label>
			<input type="text" name="resposta11" />
			<input type="radio" name="perg1" value="1" />
		</div>
		
		<div>
			<label for="resposta12">Resposta 2: </label>
			<input type="text" name="resposta12" />
			<input type="radio" name="perg1" value="2" />
		</div>
		
		<div>
			<label for="resposta13">Resposta 3: </label>
			<input type="text" name="resposta13" />
			<input type="radio" name="perg1" value="3" />
		</div>
		
		<div>
			<label for="resposta14">Resposta 4: </label>
			<input type="text" name="resposta14" />
			<input type="radio" name="perg1" value="4" />
		</div>
		
		<br>
		<label for="pergunta2">Pergunta: </label>
		<input type="text" name="pergunta2" />
		
		<div>
			<label for="resposta21">Resposta 1: </label>
			<input type="text" name="resposta21" />
			<input type="radio" name="perg2" value="1" />
		</div>
		
		<div>
			<label for="resposta22">Resposta 2: </label>
			<input type="text" name="resposta22" />
			<input type="radio" name="perg2" value="2" />
		</div>
		
		<div>
			<label for="resposta23">Resposta 3: </label>
			<input type="text" name="resposta23" />
			<input type="radio" name="perg3" value="3" />
		</div>
		
		<div>
			<label for="resposta24">Resposta 4: </label>
			<input type="text" name="resposta24" />
			<input type="radio" name="perg2" value="4" />
		</div>
		
		<br>
		
		<label for="pergunta3">Pergunta: </label>
		<input type="text" name="pergunta3" />
		
		
		<div>
			<label for="resposta31">Resposta 1: </label>
			<input type="text" name="resposta31" />
			<input type="radio" name="perg3" value="1" />
		</div>
		
		<div>
			<label for="resposta32">Resposta 2: </label>
			<input type="text" name="resposta32" />
			<input type="radio" name="perg3" value="2" />
		</div>
		
		<div>
			<label for="resposta33">Resposta 3: </label>
			<input type="text" name="resposta33" />
			<input type="radio" name="perg3" value="3" />
		</div>
		
		<div>
			<label for="resposta34">Resposta 4: </label>
			<input type="text" name="resposta34" />
			<input type="radio" name="perg3" value="4" />
		</div>
		
		<br>
		
		<label for="pergunta4">Pergunta: </label>
		<input type="text" name="pergunta4" />
		
		<div>
			<label for="resposta41">Resposta 1: </label>
			<input type="text" name="resposta41" />
			<input type="radio" name="perg4" value="1" />
		</div>
		
		
		<div>
			<label for="resposta42">Resposta 2: </label>
			<input type="text" name="resposta42" />
			<input type="radio" name="perg4" value="2" />
		</div>
		
		<div>
			<label for="resposta43">Resposta 3: </label>
			<input type="text" name="resposta43" />
			<input type="radio" name="perg4" value="3" />
		</div>
		
		<div>
			<label for="resposta44">Resposta 4: </label>
			<input type="text" name="resposta44" />
			<input type="radio" name="perg4" value="4" />
		</div>
	
	<input type="hidden" value="${countQuestionario}" name="questionarioId"/>
	<input type="submit" value="Salvar Pergunta" name="button" />
	</form>
</body>
</html>