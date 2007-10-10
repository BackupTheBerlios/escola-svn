package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class MatriculaTurma {
 
	private String matriculaAluno;
	 
	private Turma turma;

	public MatriculaTurma(){
		this.matriculaAluno = new String();
		this.turma = new Turma();
	}
	
	public MatriculaTurma(String matriculaAluno, Turma turma){
		this.matriculaAluno = matriculaAluno;
		this.turma = turma;
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
	
	
	 
}
 
