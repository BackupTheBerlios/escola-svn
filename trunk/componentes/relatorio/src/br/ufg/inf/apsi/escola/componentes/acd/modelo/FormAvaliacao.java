package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Esta classe representa o formulario de avaliacao que foi definido na
 * avaliacao, e deve ser respondido por cada aluno de uma determinada turma.
 * Oferece os servicos de consultar, criar, alterar e excluir suas respostas.
 * 
 * @author Rodrigo Morian Loures
 */
public class FormAvaliacao {
	private Long id;
	private Long alunoId;
	private Avaliacao avaliacao;
	private List<Resposta> respostas = new ArrayList<Resposta>();

	public FormAvaliacao() {

	}

	/**
	 * Cria uma instancia de <code>FormAvaliacao</code> para o especificado
	 * identificador unico do <code>Aluno</code>.
	 * 
	 * @param alunoId
	 *            Identificador unico do <code>Aluno</code> para o qual se
	 *            deseja criar o <code>FormAvaliacao</code>.
	 */
	public FormAvaliacao(Long alunoId) {
		this.alunoId = alunoId;
	}

	/**
	 * Cria uma instancia de <code>FormAvaliacao</code> para a especificada
	 * <code>Avaliacao</code>.
	 * 
	 * @param avaliacao
	 *            Instancia de <code>Avaliacao</code> para a qual se deseja
	 *            criar o <code>FormAvaliacao</code>.
	 */
	public FormAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * Cria uma instancia de <code>FormAvaliacao</code> para o especificado
	 * identificador unico de <code>Aluno</code> e para a especificada
	 * <code>Avaliacao</code>.
	 * 
	 * @param alunoId
	 *            Identificador unico do <code>Aluno</code> para o qual se
	 *            deseja criar o <code>FormAvaliacao</code>.
	 * @param avaliacao
	 *            Instancia de <code>Avaliacao</code> para a qual se deseja
	 *            criar o <code>FormAvaliacao</code>.
	 */
	public FormAvaliacao(Long alunoId, Avaliacao avaliacao) {
		this.alunoId = alunoId;
		this.avaliacao = avaliacao;
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
	 * Obtem o identificador unico do <code>Aluno</code> para qual se aplica o
	 * formulario de avaliacao.
	 * 
	 * @return O identificador unico do <code>Aluno</code> para qual se aplica
	 *         o formulario de avaliacao.
	 */
	public Long getAlunoId() {
		return alunoId;
	}

	/**
	 * Atribui o identificador unico do <code>Aluno</code> para o qual se
	 * aplica o formulario de avaliacao.
	 * 
	 * @param alunoId
	 *            Identificador unico do <code>Aluno</code> para o qual se
	 *            deseja criar o formulario de avaliacao.
	 */
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	/**
	 * Obtem o <code>Avaliacao</code> para qual se aplica o formulario de
	 * avaliacao.
	 * 
	 * @return o <code>Avaliacao</code> para qual se aplica o formulario de
	 *         avaliacao.
	 */
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	/**
	 * Atribui uma <code>Avaliacao</code> para o formulario de avaliacao.
	 * 
	 * @param avaliacao
	 *            <code>Avaliacao</code> para o qual se deseja criar o
	 *            formulario de avaliacao.
	 */
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * Obtem a colecao, <code>List</code> das respostas informadas pelos
	 * alunos para o formulario de avaliacao.
	 * 
	 * @return Uma <code>List</code> das respostas informadas pelos alunos
	 *         para o formulario de avaliacao.
	 */
	public List<Resposta> getRespostas() {
		return respostas;
	}

	/**
	 * Atribui a colecao, <code>List</code> de respostas informadas pelos
	 * alunos para o formulario de avaliacao.
	 * 
	 * @param respostas
	 *            Um <code>List</code> de respostas informadas pelos alunos
	 *            para o formulario de avaliacao.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean setRespostas(List<Resposta> respostas) {
		for (int i = 0; i < respostas.size() - 1; i++)
			for (int j = i + 1; j < respostas.size(); j++)
				if (respostas.get(i).equals(respostas.get(j)))
					return false;

		this.respostas = respostas;
		return true;
	}

	/**
	 * Obtem uma <code>Resposta</code> de acordo com o indice informado.
	 * 
	 * @param indice
	 *            Indice da <code>Resposta</code> que se deseja obter.
	 * @return A <code>Resposta</code> de acordo com o indice.
	 */
	public Resposta getResposta(int indice) {
		return getRespostas().get(indice);
	}

	/**
	 * Obtem uma <code>Resposta</code> de acordo com o identificador unico da
	 * mesma para o banco de dados.
	 * 
	 * @param respostaId
	 *            Identificador unico de <code>Resposta</code> para o banco de
	 *            dados.
	 * @return A <code>Resposta</code> de acordo com seu identificador unico
	 *         para o banco de dados.
	 */
	public Resposta getResposta(Long respostaId) {
		for (int i = 0; i < respostas.size(); i++)
			if (respostaId.equals(respostas.get(i).getId()))
				return respostas.get(i);

		return null;
	}

	/**
	 * Obtem uma <code>Resposta</code> de acordo com a <code>Questao</code>
	 * informada.
	 * 
	 * @param questao
	 *            <code>Questao</code> para a qual se deseja obter a
	 *            <code>Resposta</code>.
	 * @return A <code>Resposta</code> de acordo com a <code>Questao</code>
	 *         informada.
	 */
	public Resposta getResposta(Questao questao) {
		Resposta resp;
		Iterator<Resposta> itResp;

		itResp = respostas.iterator();
		while (itResp.hasNext()) {
			resp = itResp.next();
			if (questao.equals(resp.getQuestao()))
				return resp;
		}

		return null;
	}

	/**
	 * Adiciona uma <code>Resposta</code> para o formulario de avaliacao.
	 * 
	 * @param resposta
	 *            <code>Resposta</code> que se deseja adicionar.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarResposta(Resposta resposta) {
		if (resposta.getQuestao() == null)
			return false;

		for (int i = 0; i < respostas.size(); i++)
			if (resposta.getQuestao().equals(respostas.get(i).getQuestao()))
				return false;

		return respostas.add(resposta);
	}

	/**
	 * Adiciona uma <code>Resposta</code> para o formulario de avaliacao.
	 * 
	 * @param questao
	 *            A <code>Questao</code> para responder.
	 * @param resposta
	 *            A resposta da <code>Questao</code>.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarResposta(Questao questao, String resposta) {
		if (questao == null)
			return false;

		for (int i = 0; i < respostas.size(); i++)
			if (questao.equals(respostas.get(i).getQuestao()))
				return false;

		return respostas.add(new Resposta(questao, resposta));
	}

	/**
	 * Adiciona uma <code>Resposta</code> para o formulario de avaliacao na
	 * posicao do indice informado.
	 * 
	 * @param indice
	 *            Posicao para adicionar a <code>Resposta</code>.
	 * @param resposta
	 *            <code>Resposta</code> que se deseja adicionar.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarResposta(int indice, Resposta resposta) {
		if (resposta.getQuestao() == null)
			return false;

		for (int i = 0; i < respostas.size(); i++)
			if (resposta.getQuestao().equals(respostas.get(i).getQuestao()))
				return false;

		respostas.add(indice, resposta);

		if (respostas.get(indice).equals(resposta))
			return true;

		return false;
	}

	/**
	 * Remover uma <code>Resposta</code> de acordo com o indice informado.
	 * 
	 * @param indice
	 *            Indice da <code>Resposta</code> que se deseja remover.
	 * @return A <code>Resposta</code> removida.
	 */
	public Resposta removerResposta(int indice) {
		return getRespostas().remove(indice);
	}

	/**
	 * Remover a <code>Resposta</code> informada.
	 * 
	 * @param resposta
	 *            A <code>Resposta</code> que se deseja remover.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean removerResposta(Resposta resposta) {
		return getRespostas().remove(resposta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder saida = new StringBuilder();

		for (int i = 0; i < respostas.size(); i++)
			saida.append("\nQUESTAO NUMERO: " + (i + 1) + "\n"
					+ respostas.get(i).toString());

		return "" + saida;
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
		result = prime * result + ((alunoId == null) ? 0 : alunoId.hashCode());
		result = prime * result
				+ ((avaliacao == null) ? 0 : avaliacao.hashCode());
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
		final FormAvaliacao other = (FormAvaliacao) obj;
		if (alunoId == null) {
			if (other.alunoId != null)
				return false;
		} else if (!alunoId.equals(other.alunoId))
			return false;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		return true;
	}
}
