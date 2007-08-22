package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de uma pessoa em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class PessoaCadastradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public PessoaCadastradaException(){
		super("Pessoa já cadastrada!");
	}

}
