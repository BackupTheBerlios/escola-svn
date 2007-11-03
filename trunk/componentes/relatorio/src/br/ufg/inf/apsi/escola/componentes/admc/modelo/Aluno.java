/*
 * Aluno.java
 *
 * Criado em 02/10/2007
 *
 */


package br.ufg.inf.apsi.escola.componentes.admc.modelo;

/**
 * Classe que armazena os dados de um Aluno
 * @author APSI2006
 */

public class Aluno {
 
	private Long id;
	 
	private String numeroMatricula;
	 
	private String historicoAcademico;
	 
	private Long pessoa;
	
 	private Curso cursoMatriculado;
 	
 	
 	public Aluno(){
 		this.numeroMatricula = new String();
 		this.historicoAcademico = new String();
 		this.pessoa = new Long(0);
 		this.cursoMatriculado = new Curso();
 		
 	}
 	
 	public Aluno(long pessoa, String numeroMatricula,Curso curso){
 		this.numeroMatricula = numeroMatricula;
 		this.cursoMatriculado = curso;
 		this.historicoAcademico = new String();
 		this.pessoa = pessoa;
 	}
	
 	public Aluno(long pessoa,String numeroMatricula,String historicoAcademico,
 			Curso cursoMatriculado){
 		
 		this.id=new Long(0);
 		this.pessoa = pessoa;
 		this.numeroMatricula = numeroMatricula;
 		this.historicoAcademico = historicoAcademico;
 		this.cursoMatriculado = cursoMatriculado;
 	}
 	
	public Curso getCurso() {
		return cursoMatriculado;
	}

	public void setCurso(Curso curso) {
		this.cursoMatriculado = curso;
	}

	public String getHistoricoAcademico() {
		return historicoAcademico;
	}

	public void setHistoricoAcademico(String historicoAcademico) {
		this.historicoAcademico = historicoAcademico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Long getPessoa() {
		return pessoa;
	}

	public void setPessoa(Long pessoa) {
		this.pessoa = pessoa;
	}

		 
}
 
