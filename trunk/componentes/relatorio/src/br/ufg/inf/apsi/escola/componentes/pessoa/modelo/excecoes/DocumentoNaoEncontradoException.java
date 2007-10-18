package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada sempre que uma consulta a
 * um documento não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class DocumentoNaoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public DocumentoNaoEncontradoException(){
		super("Documento não encontrado!");
	}
	
}
