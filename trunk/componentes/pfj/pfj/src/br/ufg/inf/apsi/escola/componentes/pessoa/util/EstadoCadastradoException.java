package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um estado em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EstadoCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EstadoCadastradoException(){
		super("Estado já cadastrado!");
	}

}
