package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um documento em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class DocumentoCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public DocumentoCadastradoException(){
		super("Documento já cadastrado!");
	}

}
