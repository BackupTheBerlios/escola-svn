package br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes;
/**
 * Classe definida para representar exceções disparadas quando da ocorrência de
 * erros não específico durante a execução de operações do sistema.
 * @author gilmar
 *
 */
@SuppressWarnings("serial")
public class EscolaException extends Exception {
	/**
	 * Construtor parametrizado com a mensagem.
	 * @param mensagem
	 *
	 */
	public EscolaException(String mensagem){
		super(mensagem);
	}

}
