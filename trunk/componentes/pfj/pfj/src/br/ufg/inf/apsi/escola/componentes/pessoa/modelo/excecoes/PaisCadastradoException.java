package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um país em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class PaisCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public PaisCadastradoException(){
		super("País já cadastrado!");
	}

}
