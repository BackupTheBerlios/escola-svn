package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a documentos não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumDocumentoEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumDocumentoEncontradoException(){
		super("Nenhum documento foi encontrado!");
	}

}
