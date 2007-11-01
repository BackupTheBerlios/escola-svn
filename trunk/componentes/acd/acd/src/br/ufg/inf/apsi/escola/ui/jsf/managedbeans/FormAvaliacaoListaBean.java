package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.Turma;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * Esta classe e um "Managed Bean" usada pelo JSF para fazer a interacao com o
 * usuario via web browser, ela apresenta os formularios de avaliacao
 * preenchidos pelos alunos para o secretario e para o docente, dessa forma,
 * eles podem verificar o desempenho do docente na turma.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoListaBean {

	private ServiceFactory sf = null;
	private AvaliacaoDocenteService ads = null;
	private ExternoService es = new ExternoServiceImpl();

	private Long formAvaliacaoId = 0L;
	private Long avaliacaoId = 0L;
	private Long turmaId = 0L;
	private List<Resposta> respostas = new ArrayList<Resposta>();
	private List<FormAvaliacao> formularios = new ArrayList<FormAvaliacao>();

	private int indice = 0;
	private List<SelectItem> turmas = new ArrayList<SelectItem>();
	private List<Turma> lista = new ArrayList<Turma>();

	/**
	 * Metodo construtor, carrega os servicos necessarios para apresentar os
	 * formularios de avaliacao para o secretario e o docente.
	 */
	public FormAvaliacaoListaBean() {
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
	 * Obtem o id do <code>FormAvaliacao</code>.
	 * 
	 * @return o id do <code>FormAvaliacao</code>.
	 */
	public Long getFormAvaliacaoId() {
		return formAvaliacaoId;
	}

	/**
	 * Atribui o id do <code>FormAvaliacao</code>.
	 * 
	 * @param formAvaliacaoId
	 *            O id do <code>FormAvaliacao</code>.
	 */
	public void setFormAvaliacaoId(Long formAvaliacaoId) {
		this.formAvaliacaoId = formAvaliacaoId;
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
	 * Obtem uma <code>List<Resposta></code> do
	 * <code>FormAvaliacaoBean</code>.
	 * 
	 * @return Uma <code>List<Resposta></code> do
	 *         <code>FormAvaliacaoBean</code>.
	 */
	public List<Resposta> getRespostas() {
		return respostas;
	}

	/**
	 * Atribui uma <code>List<Resposta></code> do
	 * <code>FormAvaliacaoBean</code>.
	 * 
	 * @param respostas
	 *            Uma <code>List<Resposta></code> do
	 *            <code>FormAvaliacaoBean</code>.
	 */
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	/**
	 * Obtem uma <code>List<FormAvaliacao></code> da
	 * <code>FormAvaliacaoListBean</code>.
	 * 
	 * @return Uma <code>List<FormAvaliacao></code> do
	 *         <code>FormAvaliacaoListBean</code>.
	 */
	public List<FormAvaliacao> getFormularios() {
		return formularios;
	}

	/**
	 * Obtem uma <code>List<FormAvaliacao></code> da
	 * <code>FormAvaliacaoListBean</code>.
	 * 
	 * @param formularios
	 *            Uma <code>List<FormAvaliacao></code> do
	 *            <code>FormAvaliacaoListBean</code>.
	 */
	public void setFormularios(List<FormAvaliacao> formularios) {
		this.formularios = formularios;
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
	 * usuario, e carrega uma lista de <code>FormAvaliacao</code> para ser
	 * apresentado para o secretario e para o docente.
	 * 
	 * @return "Sucesso" ou "Falha"
	 */
	public String selecionarTurma() {
		respostas.clear();

		if (!verificaAvaliacao())
			return "Falha";

		formularios = ads.buscarFormulariosAvaliacao(avaliacaoId);
		if (formularios.isEmpty())
			return "Falha";

		indice = 0;
		respostas = formularios.get(indice).getRespostas();

		return "Sucesso";
	}

	/**
	 * Este metodo apresenta o <code>FormAvaliacao</code> anterior ao que esta
	 * sendo apresentado na tela.
	 * 
	 * @return "Sucesso" ou "Falha".
	 */
	public String anteriorFormAvaliacao() {
		if (indice > 0) {
			indice--;
			respostas = formularios.get(indice).getRespostas();
			return "Sucesso";
		} else
			return "Falha";
	}

	/**
	 * Este metodo apresenta o <code>FormAvaliacao</code> posterior ao que
	 * esta sendo apresentado na tela.
	 * 
	 * @return "Sucesso" ou "Falha".
	 */
	public String proximoFormAvaliacao() {
		if (indice < formularios.size() - 1) {
			indice++;
			respostas = formularios.get(indice).getRespostas();
			return "Sucesso";
		} else
			return "Falha";
	}

	/**
	 * Verifica se ha uma <code>Avaliacao</code> para a <code>Turma</code>
	 * informada, e obtem o id da <code>Avaliacao</code> caso haja.
	 * 
	 * @return "true" caso haja a <code>Avaliacao</code> e "false" caso
	 *         contrario.
	 */
	private boolean verificaAvaliacao() {
		if (turmaId < 1)
			return false;

		avaliacaoId = ads.buscarAvaliacaoId(turmaId);
		if (avaliacaoId > 0)
			return true;
		else
			return false;
	}
}
