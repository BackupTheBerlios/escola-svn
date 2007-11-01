package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandLink;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.Turma;
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
	 * Obtem id da <code>Avaliacao</code>.
	 * 
	 * @return O id da <code>Avaliacao</code>.
	 */
	public Long getAvaliacaoId() {
		return avaliacaoId;
	}

	/**
	 * Atribui o id da <code>Avaliacao</code>.
	 * 
	 * @param avaliacaoId
	 *            O id da <code>Avaliacao</code>.
	 */
	public void setAvaliacaoId(Long avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}

	/**
	 * Obtem o id da <code>Turma</code>.
	 * 
	 * @return O id da <code>Turma</code>.
	 */
	public Long getTurmaId() {
		return turmaId;
	}

	/**
	 * Atribui o id da <code>Turma</code>.
	 * 
	 * @param turmaId
	 *            O id da <code>Turma</code>.
	 */
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	/**
	 * Obtem o id da <code>Questao</code>.
	 * 
	 * @return O id da <code>Questao</code>.
	 */
	public Long getQuestaoId() {
		return questaoId;
	}

	/**
	 * Atribui o id da <code>Questao</code>.
	 * 
	 * @param questaoId
	 *            O id da <code>Questao</code>.
	 */
	public void setQuestaoId(Long questaoId) {
		this.questaoId = questaoId;
	}

	/**
	 * Verifica se <code>Questao</code> e objetiva ou nao.
	 * 
	 * @return Se <code>Questao</code> e objetiva ou nao.
	 */
	public boolean isObjetiva() {
		return objetiva;
	}

	/**
	 * Atribui se <code>Questao</code> e objetiva ou nao.
	 * 
	 * @param objetiva
	 *            "true" se <code>Questao</code> e objetiva, ou "false" caso
	 *            contrario.
	 */
	public void setObjetiva(boolean objetiva) {
		this.objetiva = objetiva;
	}

	/**
	 * Obtem a pergunta da <code>Questao</code>.
	 * 
	 * @return A pergunta da <code>Questao</code>.
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * Atribui a pergunta da <code>Questao</code>.
	 * 
	 * @param pergunta
	 *            A pergunta da <code>Questao</code>.
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/**
	 * Obtem uma <code>List<Questao></code> de <code>AvaliacaoBean</code>.
	 * 
	 * @return Uma <code>List<Questao></code>.
	 */
	public List<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * Atribui uma <code>List<Questao></code> para <code>AvaliacaoBean</code>.
	 * 
	 * @param questoes
	 *            Uma <code>List<Questao></code>.
	 */
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	/**
	 * Obtem o <code>List<SelectItem></code> da <code>AvaliacaoBean</code>.
	 * 
	 * @return O <code>List<SelectItem></code> da <code>AvaliacaoBean</code>.
	 */
	public List<SelectItem> getTurmas() {
		return turmas;
	}

	/**
	 * Atribui o <code>List<SelectItem></code> para
	 * <code>AvaliacaoBean</code>.
	 * 
	 * @param turmas
	 *            O <code>List<SelectItem></code> para
	 *            <code>AvaliacaoBean</code>.
	 */
	public void setTurmas(List<SelectItem> turmas) {
		this.turmas = turmas;
	}

	/**
	 * Este metodo busca a <code>Avaliacao</code> da turma selecionada pelo o
	 * usuario para o mesmo poder cadastrar as questoes.
	 * 
	 * @return "Sucesso" ou "Falha".
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

	/**
	 * Carrega todas as questoes para o id de uma <code>Avaliacao</code>
	 */
	private void carregarQuestoes() {
		setQuestoes(ads.buscarQuestoes(avaliacaoId));
	}

	/**
	 * Cadastra uma <code>Avaliacao</code> para a <code>Turma</code> informada.
	 */
	private void cadastrarAvaliacao() {
		if (turmaId > 0)
			setAvaliacaoId(ads.cadastrarAvaliacao(turmaId));
	}
}
