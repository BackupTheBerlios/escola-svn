package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um bairro não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class BairroNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public BairroNaoEncontradoException(){
		super("Bairro não encontrado!");
	}
}
