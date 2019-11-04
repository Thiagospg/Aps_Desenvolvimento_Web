package model;

public class Usuario {

	private Integer id;
	private String usuario;
	private String senha;
	private String autorizacao;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String usuario, String senha, String autorizacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.autorizacao = autorizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

}
