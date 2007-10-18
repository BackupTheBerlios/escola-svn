package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.relatorios.servico.RelatorioService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class RelatorioNFAlunosUmaTurmaController {

	private RelatorioService relatorioService = null;
	private LocalServiceFactory localServiceFactory = null;

	private String s;
	
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public RelatorioNFAlunosUmaTurmaController() {
		localServiceFactory = new LocalServiceFactory();
		relatorioService = localServiceFactory.obterRelatorioService();

	}

	public String consultaTurmasAluno() {
		List<HashMap<String,String>> l = relatorioService.consultaTurmasAluno(new Long(1)) ;
		String s = "";
		for(int i=0;i<l.size();i++){
			s = s + l.get(i).get("codigoTurma");
			s = s + " - ";
			s = s + l.get(i).get("codigoDisciplina");
			s = s + " - ";
			s = s + l.get(i).get("nomeDisciplina");
			s = s + "\n";
		}
		
		return "OK";
	}

}
