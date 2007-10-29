package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.admc.servico.Turma;
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
	 * @return the id
	 */
	public Long getFormAvaliacaoId() {
		return formAvaliacaoId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setFormAvaliacaoId(Long id) {
		this.formAvaliacaoId = id;
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
	 * @return the respostas
	 */
	public List<Resposta> getRespostas() {
		return respostas;
	}

	/**
	 * @param respostas
	 *            the respostas to set
	 */
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	/**
	 * @return the formularios
	 */
	public List<FormAvaliacao> getFormularios() {
		return formularios;
	}

	/**
	 * @param formularios
	 *            the formularios to set
	 */
	public void setFormularios(List<FormAvaliacao> formularios) {
		this.formularios = formularios;
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
