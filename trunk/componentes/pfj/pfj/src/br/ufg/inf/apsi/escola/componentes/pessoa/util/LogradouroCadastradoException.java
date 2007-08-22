package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um logradouro em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class LogradouroCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public LogradouroCadastradoException(){
		super("Logradouro já cadastrado!");
	}

}
