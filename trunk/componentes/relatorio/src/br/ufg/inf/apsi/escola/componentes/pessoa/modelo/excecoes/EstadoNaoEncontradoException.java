package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um estado não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EstadoNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EstadoNaoEncontradoException(){
		super("Estado não encontrado!");
	}

}
