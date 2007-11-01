package br.ufg.inf.apsi.escola.componentes.externo.servicos;

import java.util.Calendar;

/**
 * Classe criada com o intuito de simular servicos de componentes externos ao
 * componente "acd", dos quais o componente "acd" depende. Dessa forma, pode-se
 * executar e testar o componente "acd", enquanto os servicos externos dos quais
 * ele dependente, nao estao disponiveis. Por este motivo, nao sera gerado
 * documentacao para esta classe.
 * 
 * @author Rodrigo Morian Loures
 */
public class Turma {
	private Long id;
	private String codigoTurma;
	private Calendar dataInicio;
	private Calendar dataTermino;

	public Turma() {

	}

	public Turma(Long id, String nome, Calendar dataInicio, Calendar dataTermino) {
		super();
		this.id = id;
		this.codigoTurma = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
}
