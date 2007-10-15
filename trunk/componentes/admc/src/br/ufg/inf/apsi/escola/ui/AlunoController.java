package br.ufg.inf.apsi.escola.ui;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class AlunoController {

	 private AlunoService alunoService = null;
	 private LocalServiceFactory localServiceFactory = null;
	 
	 
	 private DataModel model;
     
	public AlunoController(){
		 localServiceFactory = new LocalServiceFactory();
         alunoService = localServiceFactory.obterAlunoService();
        
	}
	
	
	
	public String novo(){
		
		
		return "editar";
	}
	
	public String gravar(){
		        
        try {
            
            //alunoService.gravar(this.aluno);
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
