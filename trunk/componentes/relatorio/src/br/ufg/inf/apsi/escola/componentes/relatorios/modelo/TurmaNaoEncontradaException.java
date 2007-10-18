package br.ufg.inf.apsi.escola.componentes.relatorios.modelo;

public class TurmaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TurmaNaoEncontradaException() {
		super("<<< Turma não encontrada. >>>");
	}

}
