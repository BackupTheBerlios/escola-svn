package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class Disciplina {
 
	private long id;
	 
	private String codigo;
	 
	private String nome;
	
	private String ementa;
	
	private int cargaHoraria;
	
	private Curso curso;
	
 	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina(){
		this.codigo =new String();
		this.nome = new String();
		this.ementa = new String();
		this.cargaHoraria =0;
	}
	
	public Disciplina(String nome,String codigo, 
			String ementa, int cargaHoraria, Curso curso){
		this.nome = nome;
		this.codigo = codigo;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
		
	}
	
	public Disciplina(String nome,String codigo, 
			String ementa, int cargaHoraria){
		this.nome = nome;
		this.codigo = codigo;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
		
	}
	
	
	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
 
