package br.ufg.inf.apsi.escola.componentes.acd.repositorioTeste;

import java.util.HashMap;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.local.LocalMatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.local.LocalTurmaService;
import br.ufg.inf.apsi.escola.componentes.repositorioParaTeste.RepositorioTeste;

public class RepositorioTesteACD {
	private static RepositorioTesteACD repositorioTesteACD;
	RepositorioTeste rt = RepositorioTeste.getRepositorioTeste();
	MatriculaTurmaService matriculaTurmaService = new LocalMatriculaTurmaService();
	TurmaService turmaService = new LocalTurmaService();
	
	private Avaliacao[] avaliacao;
	private Questao[] questao;
	private FormAvaliacao[] formAvaliacao;
	private HashMap<Long,Avaliacao> hashMapAvaliacaoId;
	private HashMap<Long,Avaliacao> hashMapAvaliacaoTurmaId;
	private HashMap<Long,FormAvaliacao> hashMapFormAvaliacaoId;

	
	public RepositorioTesteACD() {
		this.avaliacao = iniciaAvaliacao();
		this.questao = iniciaQuestao();
		this.formAvaliacao = iniciaFormAvaliacao();
		iniciaResposta();
		System.out.println();
		
	}

	private void iniciaResposta() {
		int i=1;
		int iturma=0;
		int iavaliacao=0;
		int iquestao=0;
		int iformAvaliacao=0;
		String resp;
		Resposta x;
		for(int ccurso=1;ccurso<=3;ccurso++){
			for(int cturma=1;cturma<=5;cturma++){
				for(int caluno=1;caluno<=10;caluno++){
					for(int cquestao=1;cquestao<=10;cquestao++){
						iturma = ((ccurso-1) * 5) + cturma;
						iavaliacao = iturma;
						iformAvaliacao = ((iturma-1) * 10) +  caluno;
						iquestao = ((iavaliacao-1) * 10) + cquestao;
						x = new Resposta();
						x.setId(new Long(i));
						x.setQuestao(questao[iquestao]);
						if (questao[iquestao].isObjetiva())
							resp = ((cquestao % 2 == 0)? "Sim": "Não");
						else {
							resp = "1 lalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala ";
							resp = resp + "2 lalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala ";
							resp = resp + "3 lalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala ";
							resp = resp + "4 lalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala ";
							resp = resp + "5 lalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala lalalalalala ";
						}
						x.setResposta(resp);

						formAvaliacao[iformAvaliacao].adicionarResposta(x);
						i++;
					}
				}
			}
		}
	}


	private FormAvaliacao[] iniciaFormAvaliacao() {
		Aluno[] aluno = rt.getAluno();
		int i=1;
		int iturma=0;
		int ialuno=0;
		int iavaliacao=0;
		FormAvaliacao[] x = new FormAvaliacao[151];
		for(int ccurso=1;ccurso<=3;ccurso++){
			for(int cturma=1;cturma<=5;cturma++){
				for(int caluno=1;caluno<=10;caluno++){
					iturma = ((ccurso-1) * 5) + cturma;
					ialuno = ((ccurso-1) * 10) + caluno;
					iavaliacao = iturma;
					x[i] = new FormAvaliacao();
					x[i].setId(new Long(i));
					x[i].setAlunoId(aluno[ialuno].getId());
					x[i].setAvaliacao(avaliacao[iavaliacao]);
					i++;
				}
			}
		}
		
		//cria um HashMap para busca
		hashMapFormAvaliacaoId = new HashMap<Long,FormAvaliacao>();
		for(int ihm=1;ihm<x.length;ihm++) hashMapFormAvaliacaoId.put(x[ihm].getId(), x[ihm]);

		return x;
	}

	//gilmar 9968-4157
	//gustavo 8133-9983 

	private Questao[] iniciaQuestao() {
		int t = 150;
		int iavaliacao = 0;
		int ipergunta = 0;
		Questao[] x = new Questao[t+1];
		for(int i=1;i<=t;i++){
			x[i]=new Questao();
			x[i].setId(new Long(i));

			ipergunta = ((i-1)%10) + 1; 
			iavaliacao = ((int) ((i-1)/10)) + 1;
			if (ipergunta <= 5)
				x[i].setPergunta("A" + iavaliacao + " P" +  ipergunta + " - blablablabla blablablabla blablablabla blablablabla blablablabla blablablabla ");
			else
				x[i].setPergunta("A" + iavaliacao + " P" +  ipergunta + " - 1 blablablabla blablablabla blablablabla blablablabla blablablabla blablablabla 2 blablablabla blablablabla blablablabla blablablabla blablablabla blablablabla 3 blablablabla blablablabla blablablabla blablablabla blablablabla blablablabla ");

			x[i].setObjetiva( ( (i-1)%10 )< 5 );

			avaliacao[iavaliacao].adicionarQuestao(x[i]);
		}
		return x;
	}


	private Avaliacao[] iniciaAvaliacao() {
		Turma[] turma = rt.getTurma();
		int t = 15;
		Avaliacao[] x = new Avaliacao[t+1];
		for(int i=1;i<=t;i++){
			x[i]=new Avaliacao();
			x[i].setId(new Long(i));
			x[i].setTurmaId(turma[i].getId());
		}

		//cria um HashMap para busca
		hashMapAvaliacaoId = new HashMap<Long,Avaliacao>();
		for(int ihm=1;ihm<x.length;ihm++) hashMapAvaliacaoId.put(x[ihm].getId(), x[ihm]);
		
		//cria um HashMap para busca
		hashMapAvaliacaoTurmaId = new HashMap<Long,Avaliacao>();
		for(int ihm=1;ihm<x.length;ihm++) hashMapAvaliacaoTurmaId.put(x[ihm].getTurmaId(), x[ihm]);

		
		return x;
	}


	public static RepositorioTesteACD getRepositorioTesteACD(){
		if (repositorioTesteACD==null){
			repositorioTesteACD = new RepositorioTesteACD();
		}
		return repositorioTesteACD;
	}

//
// =============================================================================================
//

	public HashMap<Long,Avaliacao> getAvaliacaoIdHM() {
		return hashMapAvaliacaoId;
	}
	
	public HashMap<Long,Avaliacao> getAvaliacaoTurmaIdHM() {
		return hashMapAvaliacaoTurmaId;
	}

	public HashMap<Long,FormAvaliacao> getFormAvaliacaoIdHM() {
		return hashMapFormAvaliacaoId;
	}

	public Avaliacao[] getAvaliacao() {
		return avaliacao;
	}

	public FormAvaliacao[] getFormAvaliacao() {
		return formAvaliacao;
	}

}
