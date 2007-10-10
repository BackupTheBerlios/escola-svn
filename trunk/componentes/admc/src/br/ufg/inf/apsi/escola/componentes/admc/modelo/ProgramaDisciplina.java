package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class ProgramaDisciplina {
 
	private int id;
	 
	private String ementa;
	 
	private String horarioAulas;
	 
	private String numeroSala;
	 
	private Disciplina disciplina;
	 
	private Turma turma;
	 
	private Docente docente;
	
	public ProgramaDisciplina(){
		this.id=0;
		this.ementa = new String();
		this.horarioAulas = new String();
		this.numeroSala = new String();
		this.disciplina = new Disciplina();
		this.turma = new Turma();
		this.docente = new Docente();
	
	}
	
	
	public ProgramaDisciplina(String ementa, String horarioAulas, String numeroSala,
			Disciplina disciplina, Turma turma, Docente docente,
			OfertaDisciplina ofertadisciplina){
		
		this.ementa = ementa;
		this.horarioAulas = horarioAulas;
		this.numeroSala = numeroSala;
		this.disciplina = disciplina;
		this.turma = turma;
		this.docente = docente;
	
		
	}
	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getHorarioAulas() {
		return horarioAulas;
	}

	public void setHorarioAulas(String horarioAulas) {
		this.horarioAulas = horarioAulas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(String numeroSala) {
		this.numeroSala = numeroSala;
	}

	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	 
	
}
 
