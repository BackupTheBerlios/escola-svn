package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Docente {

	private long id;

	private String matricula;

	private String curriculum;

	private List<ProgramaDisciplina> programaDisciplina;
    
	public Docente(){
		this.id =0;
		this.matricula = new String();
		this.curriculum = new String();
		this.programaDisciplina = new ArrayList<ProgramaDisciplina>();
	}
	
	public Docente(String matricula, String curriculum,
			List<ProgramaDisciplina> programaDisciplina ){
		this.id=0;
		this.matricula = matricula;
		this.curriculum = curriculum;
		this.programaDisciplina = programaDisciplina;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
