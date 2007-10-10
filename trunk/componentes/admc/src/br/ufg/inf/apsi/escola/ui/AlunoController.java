package br.ufg.inf.apsi.escola.ui;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class AlunoController {

	 private AlunoService alunoService = null;
	 private LocalServiceFactory localServiceFactory = null;
	 private Aluno aluno=null;
	 private DataModel model;

	public AlunoController(){
		 localServiceFactory = new LocalServiceFactory();
         alunoService = localServiceFactory.obterAlunoService();
         this.aluno = new Aluno();
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	public Aluno getAluno(){
		return this.aluno;
	}
	
	public String novo(){
		
		this.setAluno(new Aluno());
		return "editar";
	}
	
	public String gravar(){
		        
        try {
            
            alunoService.gravar(this.aluno);
        } catch(Exception e){
            e.printStackTrace();
        }
                
       return "novo";

	}
	
	public DataModel consultar() throws Exception{
		 
	        model = new ListDataModel(alunoService.consultar());    
	       
	          
	        return model;
	}
}
