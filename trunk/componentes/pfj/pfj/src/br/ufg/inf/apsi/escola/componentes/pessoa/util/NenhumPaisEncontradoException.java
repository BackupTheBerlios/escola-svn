package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a países não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumPaisEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumPaisEncontradoException(){
		super("Nenhum País Encontrado!");
	}

}
