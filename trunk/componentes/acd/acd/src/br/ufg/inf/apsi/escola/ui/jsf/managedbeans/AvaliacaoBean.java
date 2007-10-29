package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandLink;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.admc.servico.Turma;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * Esta classe e um "Managed Bean" usada pelo JSF para fazer a interacao com o
 * usuario via web browser, ela e responsavel pelo cadastro de avaliacao pelos
 * secretarios.
 * 
 * @author Rodrigo Morian Loures
 */
public class AvaliacaoBean {
	private ServiceFactory sf = null;
	private AvaliacaoDocenteService ads = null;
	private ExternoService es = null;

	private Long avaliacaoId = 0L;
	private Long turmaId = 0L;
	private Long questaoId = 0L;
	private boolean objetiva;
	private String pergunta;
	private List<Questao> questoes = new ArrayList<Questao>();

	private List<SelectItem> turmas = new ArrayList<SelectItem>();
	private List<Turma> lista = new ArrayList<Turma>();

	/**
	 * Metodo construtor, carrega os servicos necessarios para o cadastro da
	 * <code>Avaliacao</code>.
	 */
	public AvaliacaoBean() {
		super();
		sf = new LocalServiceFactory();
		ads = sf.ObtemAvaliacaoDocenteService();
		es = new ExternoServiceImpl();
		lista = es.buscarTurmas();
		turmas.add(new SelectItem(0L, ""));
		for (int i = 0; i < lista.size(); i++)
			turmas.add(new SelectItem(lista.get(i).getId(), lista.get(i)
					.getCodigoTurma()));
	}

	/**
	 * @return the avaliacaoId
	 */
	public Long getAvaliacaoId() {
		return avaliacaoId;
	}

	/**
	 * @param avaliacaoId
	 *            the avaliacaoId to set
	 */
	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
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
	 * @return the pergunta
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * @param pergunta
	 *            the pergunta to set
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
	public List<SelectItem> getTurmas() {
		return turmas;
	}

	/**
	 * @param turmas
	 *            the turmas to set
	 */
	public void setTurmas(List<SelectItem> turmas) {
		this.turmas = turmas;
	}

	/**
	 * Este metodo busca a <code>Avaliacao</code> da turma selecionada pelo o
	 * usuario para o mesmo poder cadastrar as questoes.
	 * 
	 * @return "Sucesso" ou "Falha"
	 */
	public String selecionarTurma() {
		if (turmaId > 0) {
			avaliacaoId = ads.buscarAvaliacaoId(turmaId);
			if (avaliacaoId < 1)
				cadastrarAvaliacao();
			carregarQuestoes();
		}
		return "Sucesso";
	}

	/**
	 * Metodo usado para salvar a <code>Questao</code> informada por um
	 * secretario.
	 * 
	 * @return "Sucesso" caso a <code>Questao</code> seja salvo corretamente,
	 *         e "Falha" caso contrario.
	 */
	public String salvarQuestao() {
		boolean ok;
		if (questaoId > 0)
			ok = ads.alterarQuestao(avaliacaoId, questaoId, objetiva, pergunta);
		else
			ok = ads.cadastrarQuestao(avaliacaoId, objetiva, pergunta);

		if (ok) {
			carregarQuestoes();
			setQuestaoId(0L);
			setObjetiva(false);
			setPergunta("");
			return "sucesso";
		} else
			return "Falha";
	}

	/**
	 * Seleciona uma <code>Questao</code> para ser alterada.
	 * 
	 * @param evento
	 *            Os dados do evento que chamou este método.
	 */
	public void alterarQuestao(ActionEvent evento) {
		HtmlCommandLink cl = (HtmlCommandLink) evento.getComponent();
		Map<String, Object> atributos = cl.getAttributes();
		setQuestaoId((Long) atributos.get("idA"));

		Questao q = ads.buscarQuestao(avaliacaoId, questaoId);
		setObjetiva(q.isObjetiva());
		setPergunta(q.getPergunta());
	}

	/**
	 * Exclui a <code>Questao</code> selecionada.
	 * 
	 * @param evento
	 *            Os dados do evento que chamou este método.
	 */
	public void excluirQuestao(ActionEvent evento) {
		HtmlCommandLink cl = (HtmlCommandLink) evento.getComponent();
		Map<String, Object> atributos = cl.getAttributes();
		setQuestaoId((Long) atributos.get("idE"));

		if (ads.excluirQuestao(avaliacaoId, questaoId))
			carregarQuestoes();
	}

	private void carregarQuestoes() {
		setQuestoes(ads.buscarQuestoes(avaliacaoId));
	}

	private void cadastrarAvaliacao() {
		if (turmaId > 0)
			setAvaliacaoId(ads.cadastrarAvaliacao(turmaId));
	}
}
