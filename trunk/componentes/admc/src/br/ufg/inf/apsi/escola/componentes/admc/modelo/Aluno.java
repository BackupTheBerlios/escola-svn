/*
 * Aluno.java
 *
 * Criado em 02/10/2007
 *
 */

package br.ufg.inf.apsi.escola.componentes.admc.modelo;

/**
 * Classe que armazena os dados de um Aluno
 * 
 * @author APSI2006
 */

public class Aluno {

	private long id;

	private String numeroMatricula;

	private long pessoa;

	private Curso cursoMatriculado;

	public Aluno() {
		this.numeroMatricula = new String();
		this.pessoa = 0;
		this.cursoMatriculado = new Curso();

	}

	public Aluno(long pessoa, String numeroMatricula, Curso curso) {
		this.numeroMatricula = numeroMatricula;
		this.cursoMatriculado = curso;
		this.pessoa = pessoa;
	}

	public Aluno(long id,long pessoa, String numeroMatricula, Curso curso) {
		this.id=id;
		this.numeroMatricula = numeroMatricula;
		this.cursoMatriculado = curso;
		this.pessoa = pessoa;
	}

	public Curso getCurso() {
		return cursoMatriculado;
	}

	public void setCurso(Curso curso) {
		this.cursoMatriculado = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public long getPessoa() {
		return pessoa;
	}

	public void setPessoa(long pessoa) {
		this.pessoa = pessoa;
	}

}
