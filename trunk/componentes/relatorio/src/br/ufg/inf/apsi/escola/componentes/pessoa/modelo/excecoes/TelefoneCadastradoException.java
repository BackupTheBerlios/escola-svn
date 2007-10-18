package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um telefone em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class TelefoneCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public TelefoneCadastradoException(){
		super("Telefone já cadastrado!");
	}

}
