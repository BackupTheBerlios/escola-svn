package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um telefone não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class TelefoneNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public TelefoneNaoEncontradoException(){
		super("Telefone não encontrado!");
	}

}
