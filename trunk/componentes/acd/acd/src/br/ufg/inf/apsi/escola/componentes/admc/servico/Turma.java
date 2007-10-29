package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.Calendar;

/**
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
