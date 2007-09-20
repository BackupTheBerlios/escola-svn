package de.berlios.escola.acd.src;

/**
 * Esta classe representa uma questao da <code>Avaliacao</code>.
 * 
 * @author Rodrigo Morian Loures
 */
public class Questao {

	private Long id;
	private boolean objetiva;
	private String pergunta;

	/**
	 * Cria uma instancia de <code>Questao</code> Subjetiva.
	 */
	public Questao() {
		objetiva = false;
	}

	/**
	 * Cria uma instancia de <code>Questao</code> Subjetiva com a pergunta
	 * informada.
	 * 
	 * @param pergunta
	 *            Pergunta com a qual se deseja criar a <code>Questao</code>.
	 */
	public Questao(String pergunta) {
		objetiva = false;
		this.pergunta = pergunta;
	}

	/**
	 * Cria uma instancia de <code>Questao</code> Objetiva ou nao, com a
	 * pergunta informada.
	 * 
	 * @param objetiva
	 *            <code>true</code> - objetiva, ou <code>false</code> -
	 *            subjetiva.
	 * @param pergunta
	 *            Pergunta com a qual se deseja criar a <code>Questao</code>.
	 */
	public Questao(boolean objetiva, String pergunta) {
		this.objetiva = objetiva;
		this.pergunta = pergunta;
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
	protected void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtem o tipo da <code>Questao</code>.
	 * 
	 * @return <code>true</code> - objetiva, ou <code>false</code> -
	 *         subjetiva.
	 */
	public boolean isObjetiva() {
		return objetiva;
	}

	/**
	 * Define o tipo da <code>Questao</code> - Objetiva ou Subjetiva.
	 * 
	 * @param objetiva
	 *            <code>true</code> - objetiva, ou <code>false</code> -
	 *            subjetiva.
	 */
	public void setObjetiva(boolean objetiva) {
		this.objetiva = objetiva;
	}

	/**
	 * Obtem a pergunta da <code>Questao</code>.
	 * 
	 * @return A pergunta da <code>Questao</code>.
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * Atribui a pergunta para a <code>Questao</code>.
	 * 
	 * @param pergunta
	 *            Pergunta a ser atribuida a <code>Questao</code>.
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OBJETIVA: " + isObjetiva() + "\nPERGUNTA: " + pergunta;
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
		result = prime * result + (objetiva ? 1231 : 1237);
		result = prime * result
				+ ((pergunta == null) ? 0 : pergunta.hashCode());
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
		final Questao other = (Questao) obj;
		if (objetiva != other.objetiva)
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equalsIgnoreCase(other.pergunta))
			return false;
		return true;
	}
}
