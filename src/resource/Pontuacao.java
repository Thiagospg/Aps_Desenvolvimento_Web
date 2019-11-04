package resource;

public class Pontuacao {

	private Integer pontuacao;
	private Integer questionario;
	private Integer usuario;

	public Pontuacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pontuacao(Integer pontuacao, Integer questionario, Integer usuario) {
		super();
		this.pontuacao = pontuacao;
		this.questionario = questionario;
		this.usuario = usuario;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Integer questionario) {
		this.questionario = questionario;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

}
