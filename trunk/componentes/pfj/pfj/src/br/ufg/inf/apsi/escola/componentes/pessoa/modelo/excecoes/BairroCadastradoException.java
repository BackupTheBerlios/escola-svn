package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um bairro em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class BairroCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public BairroCadastradoException(){
		super("Bairro já cadastrado!");
	}
}
