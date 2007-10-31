package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;
//import br.ufg.inf.apsi.escola.componentes.servico.ExpressaoNotaService;

/**
 * Esta classe, <code>Turma</code>, representa uma turma. Toda turma possui:
 * <p>
 * *Uma identifica��o (<code>codigoTurma</code>);
 * <p>
 * *Uma express�o de nota (<code>expressao</code>);
 * <p>
 * *Quantidade de notas (<code>qtdeNotas</code>);
 * <p>
 * *Uma identifica��o se a turma est� dispon�vel para que alunos realizem
 * pr�-matr�cula (<code>preMatricula</code>);
 * <p>
 * *Um <code>Docente</code> respons�vel pela turma (<code>docente</code>);
 * <p>
 * *Uma turma � de uma <code>Disciplina</code> (<code>disciplina</code>);
 * 
 * @author Fernando Nery Barros
 * @data 13/10/2007
 * 
 */
public class Turma {

	/**
	 * Atributo <code>id</code> � obrigat�rio porque foi definido que ao
	 * utilizar o hibernate todos objetos dever�o conter um id para
	 * identifica��o.
	 */

	private long id;

	/**
	 * Atributo <code>codigoTurma</code> � o c�digo da turma. Por exemplo a
	 * turma An�lise e Projeto de Sistema de Informa��o possui o c�digo
	 * APSI2006.
	 */

	private String codigoTurma;

	/**
	 * Atributo <code>expressao</code> � usado para definir a express�o de
	 * c�lculo da nota. Essa express�o dever� ser validada, e depende da
	 * quantidade de notas.
	 */

	private String expressao;

	/**
	 * Atributo <code>qtdeNotas</code> � quem informa a quantidade de notas
	 * que formar� a express�o.
	 */

	private int qtdeNotas;

	/**
	 * Atributo <code>preMatricula</code> retorna <code>true</code> ou
	 * <code>false</code> e informa se a turma est� dispon�vel para que os
	 * alunos efetuem pr�-matr�cula.
	 */

	private boolean preMatricula;

	/**
	 * Atributo <disciplina> informa qual a disciplina da turma.
	 */
	private Disciplina disciplina;

	/**
	 * Atributo <docente> informa qual o docente respons�vel pela turma.
	 */
	private Docente docente;

	/**
	 * Atributo <situacao> retorna <code>true</code> ou <code>false</code>
	 * informando se a turma est� dispon�vel.
	 */

	private boolean situacao;

	private List<PreMatriculaDisciplina> preMatriculaDisciplina;

	/**
	 * 
	 */
	public Turma() {
		this.codigoTurma = new String();
		this.expressao = new String();
		this.qtdeNotas = 1;
		this.preMatricula = false;
		this.situacao = false;
		this.disciplina = new Disciplina();
		this.docente = new Docente();
		this.preMatriculaDisciplina = new ArrayList<PreMatriculaDisciplina>();
	}

	/**
	 * 
	 * @param codigoTurma
	 * @param expressao
	 * @param qtdeNotas
	 * @param preMatricula
	 * @param disciplina
	 * @param docente
	 */
	public Turma(String codigoTurma, String expressao, int qtdeNotas,
			boolean preMatricula, boolean situacao, Disciplina disciplina,
			Docente docente) {
		this.codigoTurma = codigoTurma;
		this.expressao = expressao;
		this.qtdeNotas = qtdeNotas;
		this.preMatricula = preMatricula;
		this.situacao = situacao;
		this.disciplina = disciplina;
		this.docente = docente;
		this.preMatriculaDisciplina = new ArrayList<PreMatriculaDisciplina>();

	}

	public Turma(long id, String codigoTurma, String expressao, int qtdeNotas,
			boolean preMatricula, boolean situacao, Disciplina disciplina,
			Docente docente) {
		this.id = id;
		this.codigoTurma = codigoTurma;
		this.expressao = expressao;
		this.qtdeNotas = qtdeNotas;
		this.preMatricula = preMatricula;
		this.situacao = situacao;
		this.disciplina = disciplina;
		this.docente = docente;
		this.preMatriculaDisciplina = new ArrayList<PreMatriculaDisciplina>();

	}

	/**
	 * 
	 * @return
	 */
	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	/**
	 * 
	 * @return
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param preMatricula
	 */
	public void addPreMatriculaDisciplina(PreMatriculaDisciplina preMatricula) {
		this.preMatriculaDisciplina.add(preMatricula);
	}

	/**
	 * 
	 * @param preMatricula
	 * @throws Exception
	 */
	public void removePreMatriculaDisciplina(PreMatriculaDisciplina preMatricula)
			throws Exception {
		if (this.preMatriculaDisciplina != null
				|| !this.preMatriculaDisciplina.isEmpty()) {
			this.preMatriculaDisciplina.remove(preMatricula);
		} else
			throw new Exception("Nao existe Pre-Matricula para remocao!");
	}

	/**
	 * 
	 * @return
	 */
	public String getExpressao() {
		return expressao;
	}

	/**
	 * 
	 * @param expressao
	 */
	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	/**
	 * 
	 * @return
	 */
	public int getQtdeNotas() {
		return qtdeNotas;
	}

	public void setQtdeNotas(int qtdeNotas) {
		this.qtdeNotas = qtdeNotas;
	}

	/**
	 * 
	 * @return
	 */

	public boolean isPreMatricula() {
		return preMatricula;
	}

	/**
	 * 
	 * @param preMatricula
	 */

	public void setPreMatricula(boolean preMatricula) {
		this.preMatricula = preMatricula;
	}

	/**
	 * 
	 * @return
	 */

	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * 
	 * @param disciplina
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * 
	 * @return
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * 
	 * @param docente
	 */

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getSituacao() {
		return situacao;
	}

	/**
	 * 
	 * @param situacao
	 */
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

}
