package br.ufg.inf.apsi.escola.componentes.pessoa.util;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a cidades não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumaCidadeEncontradaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumaCidadeEncontradaException(){
		super("Nenhuma cidade foi encontrada!");
	}

}
