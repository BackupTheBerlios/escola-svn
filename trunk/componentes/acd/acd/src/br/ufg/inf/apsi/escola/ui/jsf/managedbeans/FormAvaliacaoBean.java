package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.acd.servico.local.LocalAvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.ExternoServiceImpl;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacaoBean {

	private ServiceFactory sf = new LocalServiceFactory();
	private AvaliacaoDocenteService ads = sf.ObtemAvaliacaoDocenteService();

//	private AvaliacaoDocenteService ads = new LocalAvaliacaoDocenteService();
	private ExternoService es = new ExternoServiceImpl();

	private Long id = 0L;
	private Long avaliacaoId = 0L;
	private Long turmaId = 0L;
	private Long alunoId = 0L;
	private boolean objetiva;
	private String pergunta;
	private String resposta;
	private List<Resposta> respostas = new ArrayList<Resposta>();
	private List<FormAvaliacao> formularios = new ArrayList<FormAvaliacao>();

	private int indice = 0;
	private SelectItem[] turmas = { new SelectItem(1L, "Turma_01"),
			new SelectItem(20L, "Turma_02"), new SelectItem(30L, "Turma_03"),
			new SelectItem(40L, "Turma_04") };

	public FormAvaliacaoBean() {
		
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

	public String listarFormulariosAvaliacao() {
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

	public String criarFormAvaliacao() {
		respostas.clear();

		if (!verificaAvaliacao())
			return "Falha";

		alunoId = obterAlumoLogado();

		id = ads.buscarFormAvaliacaoId(avaliacaoId, alunoId);
		if (id < 1) {
			id = ads.cadastrarFormAvaliacao(avaliacaoId, alunoId);
			if (id < 1)
				return "Falha";
		}

		respostas = ads.buscarRespostas(id);
		if (respostas == null)
			return "Falha";

		return "Sucesso";
	}

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
			ads.AlterarResposta(id, respostas.get(j).getId(), respostas.get(j)
					.getResposta());
		}

		return "Sucesso";
	}

	public String anteriorFormAvaliacao() {
		if (indice > 0) {
			indice--;
			respostas = formularios.get(indice).getRespostas();
			return "Sucesso";
		} else
			return "Falha";
	}

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
/*
	private void obterListaTurmas() {
		List<Turma> turmaList = es.buscarTurmas();

		for (int i=0; i<turmaList.size(); i++) {
			turmas[i] = new SelectItem(turmaList.get(i).getId(), turmaList.get(i).getCodigoTurma());
		}
	}
*/
	private Long obterAlumoLogado() {
		return es.buscarIdAlunoLogado();
	}
}
