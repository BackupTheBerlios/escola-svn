package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoService;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.externo.servicos.Turma;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * Esta classe e um "Managed Bean" usada pelo JSF para fazer a interacao com o
 * usuario via web browser, ela e responsavel pela preenchimento do
 * <code>FormAvaliacao</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoBean {

	private ServiceFactory sf = null;
	private AvaliacaoDocenteService ads = null;
	private ExternoService es = new ExternoServiceImpl();

	private Long formAvaliacaoId = 0L;
	private Long avaliacaoId = 0L;
	private Long turmaId = 0L;
	private Long alunoId = 0L;
	private boolean objetiva;
	private String pergunta;
	private String resposta;
	private List<Resposta> respostas = new ArrayList<Resposta>();

	private List<SelectItem> turmas = new ArrayList<SelectItem>();
	private List<Turma> lista = new ArrayList<Turma>();

	/**
	 * Metodo construtor, carrega os servicos necessarios para gerar e preencher
	 * o <code>FormuAvaliacao</code>.
	 */
	public FormAvaliacaoBean() {
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
	 * Obtem o id do <code>Aluno</code>.
	 * 
	 * @return O id do <code>Aluno</code>.
	 */
	public Long getAlunoId() {
		return alunoId;
	}

	/**
	 * Atribui o id do <code>Aluno</code>.
	 * 
	 * @param alunoId
	 *            O id do <code>Aluno</code>.
	 */
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
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
	 * Obtem a resposta de uma <code>Questao</code> do
	 * <code>FormAvaliacao</code>.
	 * 
	 * @return A resposta de uma <code>Questao</code> do
	 *         <code>FormAvaliacao</code>.
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * Atribui a resposta de uma <code>Questao</code> do
	 * <code>FormAvaliacaoBean</code>.
	 * 
	 * @param resposta
	 *            A resposta de uma <code>Questao</code> do
	 *            <code>FormAvaliacaoBean</code>.
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
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
	 * Obtem o <code>List<SelectItem></code> da <code>AvaliacaoBean</code>
	 * 
	 * @return O <code>List<SelectItem></code> da <code>AvaliacaoBean</code>
	 */
	public List<SelectItem> getTurmas() {
		return turmas;
	}

	/**
	 * Atribui o <code>List<SelectItem></code> para
	 * <code>AvaliacaoBean</code>
	 * 
	 * @param turmas
	 *            O <code>List<SelectItem></code> para
	 *            <code>AvaliacaoBean</code>
	 */
	public void setTurmas(List<SelectItem> turmas) {
		this.turmas = turmas;
	}

	/**
	 * Este metodo busca a <code>Avaliacao</code> da turma selecionada pelo o
	 * usuario, e gera o <code>FormAvaliacao</code> para ser preenchido pelo
	 * aluno.
	 * 
	 * @return "Sucesso" ou "Falha"
	 */
	public String selecionarTurma() {
		respostas.clear();

		if (!verificaAvaliacao())
			return "Falha";

		alunoId = obterAlumoLogadoId();

		formAvaliacaoId = ads.buscarFormAvaliacaoId(avaliacaoId, alunoId);
		if (formAvaliacaoId < 1) {
			formAvaliacaoId = ads.cadastrarFormAvaliacao(avaliacaoId, alunoId);
			if (formAvaliacaoId < 1)
				return "Falha";
		}

		respostas = ads.buscarRespostas(formAvaliacaoId);
		if (respostas == null)
			return "Falha";

		return "Sucesso";
	}

	/**
	 * Metodo usado para salvar o <code>FormAvaliacao</code> preenchido por um
	 * aluno.
	 * 
	 * @return "Sucesso" caso o <code>FormAvaliacao</code> seja salvo
	 *         corretamente, e "Falha" caso contrario.
	 */
	public String salvarFormAvaliacao() {
		byte respNota;
		String respTexto;

		for (int i = 0; i < respostas.size(); i++)
			if (respostas.get(i).getQuestao().isObjetiva()) {
				respTexto = respostas.get(i).getResposta();

				if (respTexto == null || respTexto.isEmpty())
					respNota = 0;
				else {
					try {
						respNota = Byte.parseByte(respTexto);
					} catch (NumberFormatException nfe) {
						return "Falha";
					}
					if (respNota < 0 || respNota > 10)
						return "Falha";
				}
			}

		for (int j = 0; j < respostas.size(); j++) {
			ads.alterarResposta(formAvaliacaoId, respostas.get(j).getId(),
					respostas.get(j).getResposta());
		}

		return "Sucesso";
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

	/**
	 * Obtem o id do <code>Aluno</code> que acessando os servicos de
	 * "Avaliacao do Corpo Docente".
	 * 
	 * @return O id do <code>Aluno</code> que acessando os servicos de
	 *         "Avaliacao do Corpo Docente".
	 */
	private Long obterAlumoLogadoId() {
		return es.buscarIdAlunoLogado();
	}
}
