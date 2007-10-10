package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turma {
 
	private long id;
	 
	private String codigoTurma;
	 
	private List<ProgramaDisciplina> programaDisciplina;
	 
	private Curso curso;

	public Turma(){
		this.id=0;
		this.codigoTurma = new String();
		this.programaDisciplina = new ArrayList<ProgramaDisciplina>();
		this.curso = new Curso();
	}
	
	public Turma(String codigoTurma, List<ProgramaDisciplina> programaDisciplina,
			Curso curso){
		this.id = 0;
		this.codigoTurma = codigoTurma;
		this.programaDisciplina = programaDisciplina;
		this.curso = curso;
	}
	
	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
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
	 
	public void addProgramaDisciplina(ProgramaDisciplina programa) {
		this.programaDisciplina.add(programa);
	}

	public void removeProgramaDisciplina(ProgramaDisciplina programa)
			throws Exception {
		if (this.programaDisciplina != null
				|| !this.programaDisciplina.isEmpty()) {
			this.programaDisciplina.remove(programa);
		} else
			throw new Exception(
					"Nao existe Programa de Disciplina para remocao!");
	}
		 
	
	 
}
 
