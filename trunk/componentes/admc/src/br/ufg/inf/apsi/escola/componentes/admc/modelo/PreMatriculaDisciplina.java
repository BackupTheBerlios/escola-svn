package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class PreMatriculaDisciplina {
 
	private String matriculaAluno;
	 
	private String codigoDisciplina;
	 
	private OfertaDisciplina ofertaDisciplina;

	public PreMatriculaDisciplina(){
		this.matriculaAluno = new String();
		this.codigoDisciplina = new String();
		this.ofertaDisciplina = new OfertaDisciplina();
		
	}
	
	public PreMatriculaDisciplina(String matriculaAluno, String codigoDisciplina,
			OfertaDisciplina ofertaDisciplina){
		this.matriculaAluno = matriculaAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.ofertaDisciplina = ofertaDisciplina;
	}
	
	
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public OfertaDisciplina getOfertaDisciplina() {
		return ofertaDisciplina;
	}

	public void setOfertaDisciplina(OfertaDisciplina ofertaDisciplina) {
		this.ofertaDisciplina = ofertaDisciplina;
	}
	 
	
}
 
