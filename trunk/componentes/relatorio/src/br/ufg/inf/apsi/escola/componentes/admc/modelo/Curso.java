/*
 * Curso.java
 *
 * Alterado em 13 de Outubro de 2007 16:06
 * Por: Yoshi
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena os dados de um Curso
 * 
 * @author Ailton
 */
public class Curso {

	/**
	 * Inteiro longo para a indentitifacao do Curso
	 */
	private long id;

	/**
	 * String para identificar o Curso
	 */
	private String codigo;

	/**
	 * String para nome do Curso
	 */
	private String nome;

	/**
	 * List para relacionar as disciplinas do Curso
	 */
	private List<Disciplina> disciplina;

	/**
	 * List para relacionar alunos do Curso
	 */
	private List<Aluno> aluno;

	/**
	 * Cria instância de Curso
	 * <p>
	 * 
	 * @param codigo
	 *            String contendo o código do Curso
	 * @param nome
	 *            String contendo o nome do Curso
	 */
	public Curso(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.disciplina = new ArrayList<Disciplina>();
		this.aluno = new ArrayList<Aluno>();
	}

	/**
	 * Cria instância de Curso
	 */
	public Curso() {
		this.codigo = new String();
		this.nome = new String();
		this.disciplina = new ArrayList<Disciplina>();
		this.aluno = new ArrayList<Aluno>();
	}

	/**
	 * Retorna o id do Curso
	 * <p>
	 * 
	 * @return long contendo o id do Curso
	 */
	public long getId() {
		return id;
	}

	/**
	 * Atribui o id ao Curso
	 * <p>
	 * 
	 * @param id
	 *            long contendo o id do Curso
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Retorna o código do Curso
	 * <p>
	 * 
	 * @return String contendo o código do Curso
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Atribui o código ao curso
	 * <p>
	 * 
	 * @param codigo
	 *            String contendo o código do Curso
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o nome do Curso
	 * <p>
	 * 
	 * @return String contendo o nome do Curso
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atribui um nome ao Curso
	 * <p>
	 * 
	 * @param nome
	 *            String contendo o nome do Curso
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Adiciona uma Disciplina ao Curso
	 * <p>
	 * 
	 * @param disciplina
	 *            instância de Disciplina a ser adicionada ao Curso
	 */
	public void addDisciplina(Disciplina disciplina) {
		this.disciplina.add(disciplina);
	}

	/**
	 * Remove uma Disciplina do Curso
	 * <p>
	 * 
	 * @param disciplina
	 *            instância de Disciplina a ser removida do Curso
	 *            <p>
	 * @throws Exception
	 *             Exceção gerada quando a Disciplina não é encontrada entre as
	 *             adicionadas ao curso.
	 */
	public void removeDisciplina(Disciplina disciplina) throws Exception {
		if (this.disciplina != null || !this.disciplina.isEmpty()) {
			this.disciplina.remove(disciplina);
		} else
			throw new Exception("Nao existe disciplinas para remocao!");
	}

	/**
	 * Adiciona um Aluno ao Curso
	 * <p>
	 * 
	 * @param aluno
	 *            instância de Aluno a ser adicionado ao Curso
	 */
	public void addAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}

	/**
	 * Remove um Aluno do Curso
	 * <p>
	 * 
	 * @param aluno
	 *            instância de Aluno a ser removido do Curso
	 *            <p>
	 * @throws Exception
	 *             Exceção gerada quando o Aluno não é encontrado entre os
	 *             adicionados ao curso.
	 */
	public void removeAluno(Aluno aluno) throws Exception {
		if (this.aluno != null || !this.aluno.isEmpty()) {
			this.aluno.remove(aluno);
		} else
			throw new Exception("Nao existe aluno para remocao!");
	}
}
