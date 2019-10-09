package model;

public class Pergunta {

	private String textoPergunta;
	private String textoResposta;

	public Pergunta() {
	}

	public Pergunta(String textoPergunta, String textoResposta) {
		super();
		this.textoPergunta = textoPergunta;
		this.textoResposta = textoResposta;
	}

	public String getTextoPergunta() {
		return textoPergunta;
	}

	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}

	public String getTextoResposta() {
		return textoResposta;
	}

	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}
}
