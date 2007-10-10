package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto Curso
 */
public class Curso {

	private long id;

	private String codigo;

	private String titulo;

	private String sigla;

	private String objetivo;

	private String metodologia;

	private String matriculaMEC;

	private String dataCriacao;

	private String vigenciaCurso;

	private List<Disciplina> disciplina;

	private List<Turma> turma;

	private List<Aluno> aluno;

	public Curso(){
		this.id =0;
		this.codigo=new String();
		this.titulo =new String();
		this.sigla =new String();
		this.objetivo = new String();
		this.metodologia = new String();
		this.matriculaMEC = new String();
		this.dataCriacao = new String();
		this.vigenciaCurso = new String();
		this.disciplina = new ArrayList<Disciplina>();
		this.turma = new ArrayList<Turma>();
		this.aluno = new ArrayList<Aluno>();
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatriculaMEC() {
		return matriculaMEC;
	}

	public void setMatriculaMEC(String matriculaMEC) {
		this.matriculaMEC = matriculaMEC;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getVigenciaCurso() {
		return vigenciaCurso;
	}

	public void setVigenciaCurso(String vigenciaCurso) {
		this.vigenciaCurso = vigenciaCurso;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplina.add(disciplina);
	}

	public void removeDisciplina(Disciplina disciplina) throws Exception {
		if (this.disciplina != null || !this.disciplina.isEmpty()) {
			this.disciplina.remove(disciplina);
		} else
			throw new Exception("Nao existe disciplinas para remocao!");
	}

	public void addTurma(Turma turma) {
		this.turma.add(turma);
	}

	public void removeTurma(Turma turma) throws Exception {
		if (this.turma != null || !this.turma.isEmpty()) {
			this.turma.remove(turma);
		} else
			throw new Exception("Nao existe turma para remocao!");
	}
	
	public void addAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}

	public void removeAluno(Aluno aluno) throws Exception {
		if (this.aluno != null || !this.aluno.isEmpty()) {
			this.aluno.remove(aluno);
		} else
			throw new Exception("Nao existe aluno para remocao!");
	}
}
