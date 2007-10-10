package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

public class OfertaDisciplina {
 
	private long id;
	
	private int quantidadeVagas;
	
	private List<PreMatriculaDisciplina> preMatriculaDisciplina;
	 
	
	public OfertaDisciplina(){
		this.quantidadeVagas =0;
		this.preMatriculaDisciplina = new ArrayList<PreMatriculaDisciplina>();
	}
	
	public OfertaDisciplina(int quantidadeVagas,List<ProgramaDisciplina> programaDisciplina){
		this.quantidadeVagas = quantidadeVagas;
		this.preMatriculaDisciplina = new ArrayList<PreMatriculaDisciplina>();
	}
	
	public OfertaDisciplina(int quantidadeVagas,List<ProgramaDisciplina> programaDisciplina,
			List<PreMatriculaDisciplina> prematriculaDisciplina){
		this.quantidadeVagas = quantidadeVagas;
		this.preMatriculaDisciplina = prematriculaDisciplina;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	 
		
    public void addPrematriculaDisciplina(PreMatriculaDisciplina prematriculaDisciplina){
    	this.preMatriculaDisciplina.add(prematriculaDisciplina);
    }
    
    public void removePrematriculaDisciplina(PreMatriculaDisciplina prematriculaDisciplina)
    throws Exception{
    	if(this.preMatriculaDisciplina !=null || !this.preMatriculaDisciplina.isEmpty()){
    		this.preMatriculaDisciplina.remove(prematriculaDisciplina);
    	}else{
    		throw new Exception("Nao existe Pre-Matricula para remocao!");
    	}
    }

	
}
 
