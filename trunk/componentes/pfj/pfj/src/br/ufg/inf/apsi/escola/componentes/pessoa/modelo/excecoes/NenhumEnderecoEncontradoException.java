package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a endereços não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumEnderecoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumEnderecoEncontradoException(){
		super("Nenhum endereço foi encontrado!");
	}

}
