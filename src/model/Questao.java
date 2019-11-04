package model;

public class Questao {
	
	private Integer id;
	private String pergunta;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String resposta4;
	private Integer correta;
	
	
	public Questao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Questao(Integer id, String pergunta, String resposta1, String resposta2, String resposta3, String resposta4,
			Integer correta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta1 = resposta1;
		this.resposta2 = resposta2;
		this.resposta3 = resposta3;
		this.resposta4 = resposta4;
		this.correta = correta;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta1() {
		return resposta1;
	}
	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}
	public String getResposta2() {
		return resposta2;
	}
	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}
	public String getResposta3() {
		return resposta3;
	}
	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}
	public String getResposta4() {
		return resposta4;
	}
	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}
	public Integer getCorreta() {
		return correta;
	}
	public void setCorreta(Integer correta) {
		this.correta = correta;
	}
	
	
	

}
