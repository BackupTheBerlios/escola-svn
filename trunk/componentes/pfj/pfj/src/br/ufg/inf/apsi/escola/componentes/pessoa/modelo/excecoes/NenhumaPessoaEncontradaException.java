package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a pessoas não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumaPessoaEncontradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumaPessoaEncontradaException(){
		super("Nenhuma pessoa foi encontrada!");
	}

}
