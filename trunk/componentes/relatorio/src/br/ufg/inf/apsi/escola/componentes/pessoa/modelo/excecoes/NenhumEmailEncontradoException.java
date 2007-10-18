package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar uma exceção disparada quando a consulta
 * a emails não for bem sucedida.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class NenhumEmailEncontradoException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 *
	 */
	public NenhumEmailEncontradoException(){
		super("Nenhum email foi encontrado!");
	}

}
