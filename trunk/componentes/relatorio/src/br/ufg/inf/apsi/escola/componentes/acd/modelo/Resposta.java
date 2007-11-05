package br.ufg.inf.apsi.escola.componentes.acd.modelo;

/**
 * Esta classe representa uma resposta para uma <code>Questao</code> de
 * <code>FormAvaliacao</code>, ou seja, uma resposta para uma questao do
 * formulario de avaliacao.
 * 
 * @author Rodrigo Morian Loures
 */
public class Resposta {

	private Long id;
	private Questao questao;
	private String resposta;

	public Resposta() {
	}

	/**
	 * Cria uma instancia de <code>Resposta</code> com a especificada
	 * <code>Questao</code>.
	 * 
	 * @param questao
	 *            Instancia de <code>Questao</code> para a qual se deseja
	 *            criar a <code>Resposta</code>.
	 */
	public Resposta(Questao questao) {
		this.questao = questao;
	}

	/**
	 * Cria uma instancia de <code>Resposta</code> com a especificada
	 * <code>Questao</code> e sua resposta.
	 * 
	 * @param questao
	 *            Instancia de <code>Questao</code> para a qual se deseja
	 *            criar a <code>Resposta</code>.
	 * @param resposta
	 *            Resposta para a <code>Questao</code>.
	 */
	public Resposta(Questao questao, String resposta) {
		this.questao = questao;
		this.resposta = resposta;
	}

	/**
	 * Obtem o identificador unico para o banco de dados.
	 * 
	 * @return Identificador unico para o banco de dados.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Atribui um valor para o identificador unico para o banco de dados.
	 * Normalmente esta tarefa fica para a persistencia.
	 * 
	 * @param id
	 *            Identificador unico para o banco de dados.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtem a <code>Questao</code> da resposta.
	 * 
	 * @return A <code>Questao</code> da resposta
	 */
	public Questao getQuestao() {
		return questao;
	}

	/**
	 * Atribui a <code>Questao</code> para a resposta.
	 * 
	 * @param questao
	 *            <code>Questao</code> a ser atribuida a resposta.
	 */
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	/**
	 * Obtem a resposta da <code>Resposta</code>.
	 * 
	 * @return A resposta da <code>Resposta</code>.
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * Atribui a resposta para a <code>Resposta</code>.
	 * 
	 * @param resposta
	 *            Resposta a ser atribuida a <code>Resposta</code>.
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public String toString() {
		return getQuestao().toString() + "\nRESPOSTA: " + resposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questao == null) ? 0 : questao.hashCode());
		result = prime * result
				+ ((resposta == null) ? 0 : resposta.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Resposta other = (Resposta) obj;
		if (questao == null) {
			if (other.questao != null)
				return false;
		} else if (!questao.equals(other.questao))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equalsIgnoreCase(other.resposta))
			return false;
		return true;
	}
}
