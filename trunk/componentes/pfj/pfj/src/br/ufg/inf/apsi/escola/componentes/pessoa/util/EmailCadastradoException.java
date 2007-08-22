package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um email em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EmailCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EmailCadastradoException(){
		super("Email já cadastrado!");
	}

}
