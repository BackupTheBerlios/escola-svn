package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * uma pessoa não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class PessoaNaoEncontradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public PessoaNaoEncontradaException(){
		super("Pessoa não encontrada!");
	}

}
