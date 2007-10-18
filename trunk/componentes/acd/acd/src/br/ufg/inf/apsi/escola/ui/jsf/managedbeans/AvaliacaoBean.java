package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.acd.servico.local.LocalAvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.admc.servico.Turma;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoBean {
	private ServiceFactory sf = new LocalServiceFactory();
	private AvaliacaoDocenteService ads = sf.ObtemAvaliacaoDocenteService();

//	private AvaliacaoDocenteService ads = new LocalAvaliacaoDocenteService();
// private ExternoService es = new ExternoServiceImpl();

	private Long id = 0L;
	private Long turmaId = 0L;
	private Long questaoId = 0L;
	private boolean objetiva;
	private String pergunta;
	private List<Questao> questoes = new ArrayList<Questao>();

	private int indice = 0;
	private SelectItem[] turmas = { new SelectItem(1L, "Turma_01"),
			new SelectItem(20L, "Turma_02"), new SelectItem(30L, "Turma_03"),
			new SelectItem(40L, "Turma_04") };

	public AvaliacaoBean() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the turmaId
	 */
	public Long getTurmaId() {
		return turmaId;
	}

	/**
	 * @param turmaId
	 *            the turmaId to set
	 */
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	/**
	 * @return the questaoId
	 */
	public Long getQuestaoId() {
		return questaoId;
	}

	/**
	 * @param questaoId
	 *            the questaoId to set
	 */
	public void setQuestaoId(Long questaoId) {
		this.questaoId = questaoId;
	}

	/**
	 * @return the objetiva
	 */
	public boolean isObjetiva() {
		return objetiva;
	}

	/**
	 * @param objetiva
	 *            the objetiva to set
	 */
	public void setObjetiva(boolean objetiva) {
		this.objetiva = objetiva;
	}

	/**
	 * @return the perguna
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * @param perguna
	 *            the perguna to set
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/**
	 * @return the questoes
	 */
	public List<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * @param questoes
	 *            the questoes to set
	 */
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	/**
	 * @return the turmas
	 */
	public SelectItem[] getTurmas() {
		return turmas;
	}

	/**
	 * @param turmas
	 *            the turmas to set
	 */
	public void setTurmas(SelectItem[] turmas) {
		this.turmas = turmas;
	}

	/**
	 * Cadastra a <code>Avaliacao</code> para a especificada
	 * <code>Turma</code>
	 * 
	 * @return O resultado da operacao (Sucesso ou Falha).
	 */
	public String cadastrarAvaliacao() {
		if (turmaId < 1)
			return "Falha";

		id = ads.cadastrarAvaliacao(turmaId);
		if (id > 0)
			return "Avaliacao_Cadastrada";
		else
			return "Falha";
	}

	/**
	 * Exclui a <code>Avaliacao</code> da especificada <code>Turma</code>.
	 * 
	 * @return O resultado da operacao (Sucesso ou Falha).
	 */
	public String excluirAvaliacao() {
		if (!verificaAvaliacao())
			return "Falha";

		if (ads.excluirAvaliacao(id))
			return "Sucesso";
		else
			return "Falha";
	}

	// ===================================================================

	public String listarQuestoes() {
		questoes.clear();

		if (!verificaAvaliacao())
			return "Falha";

		questoes = ads.buscarQuestoes(id);
		if (questoes == null)
			return "Falha";
		else
			return "Sucesso";
	}

	public String buscarQuestoes() {
		questoes.clear();
		id = 0L;
		questaoId = 0L;
		objetiva = false;
		pergunta = "";

		if (!verificaAvaliacao())
			return "Falha";

		questoes = ads.buscarQuestoes(id);
		if (questoes == null)
			return "Falha";

		indice = 0;
		atribuirValores();

		return "Sucesso";
	}

	public String cadastrarQuestao() {
		if (!verificaAvaliacao())
			return "Falha";

		if (ads.cadastrarQuestao(id, objetiva, pergunta))
			return "Sucesso";
		else
			return "Falha";
	}

	public String alterarQuestao() {
		if (pergunta.isEmpty())
			return "Falha";

		if (ads.alterarQuestao(id, questaoId, objetiva, pergunta)) {
			buscarQuestoes();
			return "Sucesso";
		} else
			return "Falha";
	}

	public String excluirQuestao() {
		if (ads.excluirQuestao(id, questaoId)) {
			buscarQuestoes();
			return "Sucesso";
		} else
			return "Falha";
	}

	public String anteriorQuestao() {
		if (indice > 0) {
			indice--;
			atribuirValores();
			return "Sucesso";
		} else
			return "Falha";
	}

	public String proximaQuestao() {
		if (indice < questoes.size() - 1) {
			indice++;
			atribuirValores();
			return "Sucesso";
		} else
			return "Falha";
	}

	private boolean verificaAvaliacao() {
		if (turmaId < 1)
			return false;

		id = ads.buscarAvaliacaoId(turmaId);
		if (id > 0)
			return true;
		else
			return false;
	}

	private void atribuirValores() {
		questaoId = questoes.get(indice).getId();
		objetiva = questoes.get(indice).isObjetiva();
		pergunta = questoes.get(indice).getPergunta();
	}
	/*
	 * private void obterListaTurmas() { List<Turma> turmaList =
	 * es.buscarTurmas();
	 * 
	 * for (int i=0; i<turmaList.size(); i++) { turmas[i] = new
	 * SelectItem(turmaList.get(i).getId(), turmaList.get(i).getCodigoTurma()); } }
	 */
}
