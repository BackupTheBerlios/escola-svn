package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class PreMatriculaDisciplina {
 
	private long id;
	
	private String matriculaAluno;
	 
	private Turma turma;
	 
	

	public PreMatriculaDisciplina(){
		this.matriculaAluno = new String();
		this.turma = new Turma();
		
	}
	
	public PreMatriculaDisciplina(String matriculaAluno, Turma turma){
		this.matriculaAluno = matriculaAluno;
		this.turma = new Turma();
	}
	
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	 
	
}
 
