package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada quando da tentativa
 * de remoção de um documento do tipo CNPJ ou CPF.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class RemocaoDocumentoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public RemocaoDocumentoException(){
		super("Não é permitida a remoção deste tipo de documento!");
	}

}
