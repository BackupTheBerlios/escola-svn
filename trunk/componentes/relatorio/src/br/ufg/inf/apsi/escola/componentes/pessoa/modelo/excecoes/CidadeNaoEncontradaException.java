package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * uma cidade não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class CidadeNaoEncontradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public CidadeNaoEncontradaException(){
		super("Cidade não encontrada!");
	}

}
