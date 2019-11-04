package model;

import java.util.ArrayList;
import java.util.List;

public class Questionario {
	private Integer id;
	private List<Questao> questoes = new ArrayList<>();
	
	
	public Questionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionario(Integer id, List<Questao> questoes) {
		super();
		this.id = id;
		this.questoes = questoes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public Questao getQuestao(int index) {
		return questoes.get(index);
	}
	public void addQuestao(Questao questao) {
		questoes.add(questao);
	}
	
	
}
