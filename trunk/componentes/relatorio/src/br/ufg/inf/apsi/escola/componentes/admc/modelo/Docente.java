package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Docente {

	private long id;

	private String matricula;

	private String curriculum;
	
	private long pessoaId;

	private List<Turma> turma;
	
	public Docente(){
		this.matricula = new String();
		this.curriculum = new String();
		this.turma = new ArrayList<Turma>();
		this.pessoaId=0;
	}
	
	public Docente(String matricula, String curriculum,List<Turma> turma,long pessoaId){
		this.matricula = matricula;
		this.curriculum = curriculum;
		this.turma = turma;
		this.pessoaId=pessoaId;
	}
	
	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void addTurma(Turma turma) {
		this.turma.add(turma);
	}

	public void removeTurma(Turma turma) throws Exception {
		if (this.turma != null || !this.turma.isEmpty()) {
			this.turma.remove(turma);
		} else
			throw new Exception("Nao existe Turma para remocao!");
	}

	

}
