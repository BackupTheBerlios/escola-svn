package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
 
	private long id;
	 
	private String codigo;
	 
	private String nome;
	 
 	private Curso curso;

	private OfertaDisciplina ofertaDisciplina;
	 
	

	public Disciplina(){
		this.id =0;
		this.codigo =new String();
		this.nome = new String();
		this.curso = new Curso();
		this.ofertaDisciplina = new OfertaDisciplina();
	}
	
	public Disciplina(String nome,String codigo,Curso curso, 
			OfertaDisciplina ofertaDisciplina){
		this.id =0;
		this.nome = nome;
		this.codigo = codigo;
		this.curso = curso;
		this.ofertaDisciplina = ofertaDisciplina;
		
	}
	
	public OfertaDisciplina getOfertaDisciplina() {
		return ofertaDisciplina;
	}

	public void setOfertaDisciplina(OfertaDisciplina ofertaDisciplina) {
		this.ofertaDisciplina = ofertaDisciplina;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
 
