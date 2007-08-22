package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a bairros não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumBairroEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumBairroEncontradoException(){
		super("Nenhum bairro foi encontrado!");
	}

}
