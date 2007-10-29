package br.ufg.inf.apsi.escola.ie;

import br.ufg.inf.apsi.escola.ie.spring.SpringEscolaServiceDelegate;

/**
 * Interface para o Delegate dos servicos de Avaliacao do Corpo Docente
 * 
 * @author Rodrigo Morian Loures
 */
public abstract class EscolaServiceDelegate {
	/**
	 * Metodo para obtencao do Servico de Avaliacao do Corpo Docente pelo nome.
	 * 
	 * @param nomeServico
	 *            O nome do servico que se deseja obter.
	 * @return Instancia do objeto de servico.
	 */
	public abstract Object obtemServico(String nomeServico);

	/**
	 * Retorna a instancia da implementacao do Delegate.
	 * 
	 * @return A instancia da implementacao do Delegate.
	 */
	public static EscolaServiceDelegate getInstancia() {
		return SpringEscolaServiceDelegate.getInstancia();
	}
}
