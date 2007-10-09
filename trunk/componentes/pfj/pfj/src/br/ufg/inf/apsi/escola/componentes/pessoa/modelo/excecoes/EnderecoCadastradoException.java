package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre quando da
 * tentativa de cadastramento de um endereco em duplicidade.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EnderecoCadastradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EnderecoCadastradoException(){
		super("Endereço já cadastrado!");
	}

}
