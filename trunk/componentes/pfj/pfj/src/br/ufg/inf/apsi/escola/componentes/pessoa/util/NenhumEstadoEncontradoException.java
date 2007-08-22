package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a estados não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumEstadoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumEstadoEncontradoException(){
		super("Nenhum Estado foi econtrado!");
	}

}
