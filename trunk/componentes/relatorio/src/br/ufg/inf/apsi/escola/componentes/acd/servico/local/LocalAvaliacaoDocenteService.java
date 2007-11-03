package br.ufg.inf.apsi.escola.componentes.acd.servico.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.repositorioTeste.RepositorioTesteACD;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;

public class LocalAvaliacaoDocenteService implements AvaliacaoDocenteService {

	RepositorioTesteACD rtacd = RepositorioTesteACD.getRepositorioTesteACD(); 
	@Override
	public boolean AlterarResposta(Long formAvaliacaoId, Long respostaId,
			String resposta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarQuestao(Long avaliacaoId, Long questaoId,
			boolean objetiva, String pergunta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Avaliacao buscarAvaliacao(Long avaliacaoId) {
		HashMap<Long,Avaliacao> hm = rtacd.getAvaliacaoIdHM();
		return hm.get(avaliacaoId);
	}

	@Override
	public Long buscarAvaliacaoId(Long turmaId) {
		HashMap<Long,Avaliacao> hm = rtacd.getAvaliacaoTurmaIdHM();
		return hm.get(turmaId).getId();
	}

	@Override
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long buscarFormAvaliacaoId(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormAvaliacao> buscarFormulariosAvaliacao(Long avaliacaoId) {
		FormAvaliacao[] formAvaliacao = rtacd.getFormAvaliacao();
		List<FormAvaliacao> l = new ArrayList<FormAvaliacao>();
		for(int i=1;i<formAvaliacao.length;i++){
			if (formAvaliacao[i].getAvaliacao().getId() == avaliacaoId){
				l.add(formAvaliacao[i]);
			}
		}
		return l;
	}

	@Override
	public Questao buscarQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questao> buscarQuestoes(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resposta buscarResposta(Long formAvaliacaoId, Long respostaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resposta> buscarRespostas(Long formAvaliacaoId) {
		FormAvaliacao fa = rtacd.getFormAvaliacaoIdHM().get(formAvaliacaoId);
		return fa.getRespostas();
	}

	@Override
	public Long cadastrarAvaliacao(Long turmaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarQuestao(Long avaliacaoId, boolean objetiva,
			String pergunta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirAvaliacao(Long avaliacaoId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirFormAvaliacao(Long formAvaliacaoId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId) {
		// TODO Auto-generated method stub
		return false;
	}

}
