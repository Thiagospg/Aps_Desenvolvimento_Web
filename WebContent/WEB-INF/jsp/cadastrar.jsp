<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/cadastrar.css"
	rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="idQuestionario">
			<h2>ID desse questionario: </h2><h2 style="color:red">${countQuestionario}</h2>
		</div>
		<form action="HomeController" method="post">
			<fieldset class="borda">
				<legend>
					<span class="legendaBorda">Pergunta 1</span>
				</legend>
				<span> <input type="text" name="pergunta1"
					placeholder="Pergunta" />
				</span> <span> <input type="text" name="resposta11"
					placeholder="Resposta 1" /> <input type="radio" name="perg1"
					value="1" />
				</span> <span> <input type="text" name="resposta12"
					placeholder="Resposta 2" /> <input type="radio" name="perg1"
					value="2" />
				</span> <span> <input type="text" name="resposta13"
					placeholder="Resposta 3" /> <input type="radio" name="perg1"
					value="3" />
				</span> <span> <input type="text" name="resposta14"
					placeholder="Resposta 4" /> <input type="radio" name="perg1"
					value="4" />
				</span>

			</fieldset>

			<fieldset class="borda">
				<legend>
					<span class="legendaBorda">Pergunta 2</span>
				</legend>
				<span> <input type="text" name="pergunta2"
					placeholder="Pergunta" />
				</span> <span> <input type="text" name="resposta21"
					placeholder="Resposta 1" /> <input type="radio" name="perg2"
					value="1" />
				</span> <span> <input type="text" name="resposta22"
					placeholder="Resposta 2" /> <input type="radio" name="perg2"
					value="2" />
				</span> <span> <input type="text" name="resposta23"
					placeholder="Resposta 3" /> <input type="radio" name="perg3"
					value="3" />
				</span> <span> <input type="text" name="resposta24"
					placeholder="Resposta 4" /> <input type="radio" name="perg2"
					value="4" />
				</span>
			</fieldset>

			<fieldset class="borda">
				<legend>
					<span class="legendaBorda">Pergunta 3</span>
				</legend>
				<span> <input type="text" name="pergunta3"
					placeholder="Pergunta" />

				</span> <span> <input type="text" name="resposta31"
					placeholder="Resposta 1" /> <input type="radio" name="perg3"
					value="1" />
				</span> <span> <input type="text" name="resposta32"
					placeholder="Resposta 2" /> <input type="radio" name="perg3"
					value="2" />
				</span> <span> <input type="text" name="resposta33"
					placeholder="Resposta 3" /> <input type="radio" name="perg3"
					value="3" />
				</span> <span> <input type="text" name="resposta34"
					placeholder="Resposta 4" /> <input type="radio" name="perg3"
					value="4" />
				</span>
			</fieldset>

			<fieldset class="borda">
				<legend>
					<span class="legendaBorda">Pergunta 4</span>
				</legend>
				<span> <input type="text" name="pergunta4"
					placeholder="Pergunta" />
				</span> <span> <input type="text" name="resposta41"
					placeholder="Resposta 1" /> <input type="radio" name="perg4"
					value="1" />
				</span> <span> <input type="text" name="resposta42"
					placeholder="Resposta 2" /> <input type="radio" name="perg4"
					value="2" />
				</span> <span> <input type="text" name="resposta43"
					placeholder="Resposta 3" /> <input type="radio" name="perg4"
					value="3" />
				</span> <span> <input type="text" name="resposta44"
					placeholder="Resposta 4" /> <input type="radio" name="perg4"
					value="4" />
				</span>
			</fieldset>
			<input type="hidden" value="${countQuestionario}"
				name="questionarioId" /> <input type="submit"
				value="Salvar Pergunta" name="button" />
		</form>

		<p class="error">${error}</p>
	</div>
</body>
</html>