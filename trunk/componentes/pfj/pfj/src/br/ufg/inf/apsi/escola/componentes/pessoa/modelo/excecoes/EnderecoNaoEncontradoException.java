package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um endereço não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EnderecoNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public EnderecoNaoEncontradoException(){
		super("Endereço não encontrado!");
	}

}
