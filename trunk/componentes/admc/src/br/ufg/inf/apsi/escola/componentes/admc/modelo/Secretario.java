package br.ufg.inf.apsi.escola.componentes.admc.modelo;

public class Secretario {

	
	private long id;
	private String matricula;
	private long pessoa_id;
	
	
   public Secretario(){
	  this.matricula = new String();
	  this.pessoa_id = 0;
	}
   public Secretario(String matricula, long pessoa_id){
	   this.matricula = matricula;
	   this.pessoa_id = pessoa_id;
   }
   
   public Secretario(long id,String matricula, long pessoa_id){
	   this.id = id;
	   this.matricula = matricula;
	   this.pessoa_id = pessoa_id;
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
	public long getPessoa_id() {
		return pessoa_id;
	}
	public void setPessoa_id(long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	
	
	
	
}
