package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um email não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EmailNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EmailNaoEncontradoException(){
		super("Email não encontrado!");
	}

}
