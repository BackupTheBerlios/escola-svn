package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de uma cidade em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class CidadeCadastradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public CidadeCadastradaException(){
		super("Cidade já cadastrada!");
	}
	
}
