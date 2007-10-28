/*
 * Curso.java
 *
 * Alterado em 13 de Outubro de 2007 16:06
 * Por: Yoshi
 * 
 * 
 * Alterado em 15 de Outubro de 2007
 * Por: Fernando Nery
 * 
 */
package br.ufg.inf.apsi.escola.componentes.admc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena os dados de um Curso
 * 
 * @author Ailton
 */
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	private Integer cargaHoraria;

	private List<Disciplina> disciplinas;

	/**
	 * Cria instï¿½ncia de Curso
	 * <p>
	 * 
	 * @param codigo
	 *            String contendo o cï¿½digo do Curso
	 * @param nome
	 *            String contendo o nome do Curso
	 */
	public Curso(long id, String codigo, String nome, Integer cargaHoraria) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.disciplinas = new ArrayList<Disciplina>();
	}

	/**
	 * Cria instï¿½ncia de Curso
	 */
	public Curso() {
		this.codigo = new String();
		this.nome = new String();
		this.cargaHoraria = null;
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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * Retorna o cï¿½digo do Curso
	 * <p>
	 * 
	 * @return String contendo o cï¿½digo do Curso
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Atribui o cï¿½digo ao curso
	 * <p>
	 * 
	 * @param codigo
	 *            String contendo o cï¿½digo do Curso
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
	 * Lista de disciplinas de um curso.
	 * 
	 * @return
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public void removeDisciplina(Disciplina disciplina) throws Exception {
		if (this.disciplinas != null || !this.disciplinas.isEmpty()) {
			this.disciplinas.remove(disciplina);
		} else
			throw new Exception("Não existe Disciplina para remoção!");
	}

}
