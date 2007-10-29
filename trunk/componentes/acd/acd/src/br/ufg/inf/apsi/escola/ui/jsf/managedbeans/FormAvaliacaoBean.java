package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.componentes.admc.servico.Turma;
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
	 * @return the alunoId
	 */
	public Long getAlunoId() {
		return alunoId;
	}

	/**
	 * @param alunoId
	 *            the alunoId to set
	 */
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
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
	 * @return the resposta
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * @param resposta
	 *            the resposta to set
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
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

	private boolean verificaAvaliacao() {
		if (turmaId < 1)
			return false;

		avaliacaoId = ads.buscarAvaliacaoId(turmaId);
		if (avaliacaoId > 0)
			return true;
		else
			return false;
	}

	private Long obterAlumoLogadoId() {
		return 700L;
	}
}
