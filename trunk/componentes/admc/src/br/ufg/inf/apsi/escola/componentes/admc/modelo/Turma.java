package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe, <code>Turma</code>, representa uma turma. Toda turma possui:
 * <p>
 * *Uma identificação (<code>codigoTurma</code>);
 * <p>
 * *Uma expressão de nota (<code>expressao</code>);
 * <p>
 * *Quantidade de notas (<code>qtdeNotas</code>);
 * <p>
 * *Uma identificação se a turma está disponível para que alunos realizem
 * pré-matrícula (<code>preMatricula</code>);
 * <p>
 * *Um <code>Docente</code> responsável pela turma (<code>docente</code>);
 * <p>
 * *Uma turma é de uma <code>Disciplina</code> (<code>disciplina</code>);
 * 
 * @author Fernando Nery Barros
 * @data 13/10/2007
 * 
 */
public class Turma {

	/**
	 * Atributo <code>id</code> é obrigatório porque foi definido que ao
	 * utilizar o hibernate todos objetos deverão conter um id para
	 * identificação.
	 */

	private long id;

	/**
	 * Atributo <code>codigoTurma</code> é o código da turma. Por exemplo a
	 * turma Análise e Projeto de Sistema de Informação possui o código
	 * APSI2006.
	 */

	private String codigoTurma;

	/**
	 * Atributo <code>expressao</code> é usado para definir a expressão de
	 * cálculo da nota. Essa expressão deverá ser validada, e depende da
	 * quantidade de notas.
	 */

	private String expressao;

	/**
	 * Atributo <code>qtdeNotas</code> é quem informa a quantidade de notas
	 * que formará a expressão.
	 */

	private int qtdeNotas;

	/**
	 * Atributo <code>preMatricula</code> retorna <code>true</code> ou
	 * <code>false</code> e informa se a turma está disponível para que os
	 * alunos efetuem pré-matrícula.
	 */

	private boolean preMatricula;

	/**
	 * Atributo <disciplina> informa qual a disciplina da turma.
	 */
	private Disciplina disciplina;

	/**
	 * Atributo <docente> informa qual o docente responsável pela turma.
	 */
	private Docente docente;

	/**
	 * Atributo <situacao> retorna <code>true</code> ou <code>false</code>
	 * informando se a turma está disponível.
	 */

	private boolean situacao;

	private List<PreMatriculaDisciplina> preMatriculaDisciplina;

	/**
	 * 
	 */
	public Turma() {
		this.codigoTurma = new String();
		this.expressao = new String();
		this.qtdeNotas = 0;
		this.preMatricula = false;
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
