package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um país não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class PaisNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public PaisNaoEncontradoException() {
		super("País não Encontrado!");
	}

}
