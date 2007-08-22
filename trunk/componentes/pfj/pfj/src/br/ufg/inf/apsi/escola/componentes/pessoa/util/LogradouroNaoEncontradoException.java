package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um logradouro não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class LogradouroNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public LogradouroNaoEncontradoException(){
		super("Logradouro não encontrado!");
	}

}
