/**
 * 
 */
package br.ufg.inf.apsi.escola.ui;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * @author Fernando Nery Barros
 * 
 */
public class TurmaController {
	private String codigoTurma;

	private String expressao;

	private int qtdeNotas;

	private boolean preMatricula;

	private boolean situacao;

	private String codigoDisciplina;

	private String matriculaDocente;

	private String nomeDocente;

	private long idDocente;

	private long idDisciplina;

	private String nomeDisciplina;

	private TurmaService turmaService;

	private LocalServiceFactory localServiceFactory;

	public TurmaController() {
		localServiceFactory = new LocalServiceFactory();
		turmaService = localServiceFactory.obterTurmaService();
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public int getQtdeNotas() {
		return qtdeNotas;
	}

	public void setQtdeNotas(int qtdeNotas) {
		this.qtdeNotas = qtdeNotas;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(long idDocente) {
		this.idDocente = idDocente;
	}

	public long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public boolean isPreMatricula() {
		return preMatricula;
	}

	public void setPreMatricula(boolean preMatricula) {
		this.preMatricula = preMatricula;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getMatriculaDocente() {
		return matriculaDocente;
	}

	public void setMatriculaDocente(String matriculaDocente) {
		this.matriculaDocente = matriculaDocente;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	/**
	 * Método limpa a tela de cadastro de turma.
	 * 
	 * @return ""
	 */
	public String novo() {
		setCodigoTurma(null);
		setExpressao(null);
		setCodigoDisciplina(null);
		setMatriculaDocente(null);
		setPreMatricula(false);
		setQtdeNotas(0);
		setSituacao(false);
		return "";
	}

	public String gravar() {
		try {
			DocenteService docenteService = localServiceFactory
					.obterDocenteService();
			DisciplinaService disciplinaService = localServiceFactory
					.obterDisciplinaService();

			Turma turma = new Turma(getCodigoTurma(), getExpressao(),
					getQtdeNotas(), isPreMatricula(), isSituacao(),
					disciplinaService.consultar(getIdDisciplina()),
					docenteService.consultarPorMatricula(getMatriculaDocente()));

			turmaService.gravar(turma);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}
