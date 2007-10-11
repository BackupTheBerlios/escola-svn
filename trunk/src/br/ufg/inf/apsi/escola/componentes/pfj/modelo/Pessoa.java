package br.ufg.inf.apsi.escola.componentes.pfj.modelo;

public class Pessoa {

	long id;
	String nome;

	public Pessoa() {

	}

	public Pessoa(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
