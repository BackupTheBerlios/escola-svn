package br.ufg.inf.apsi.escola.componentes.acd.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Esta classe representa a avaliacao de um docente em uma disciplina para uma
 * Turma. Oferece os servicos de consultar, criar, alterar e excluir uma
 * avaliacao para uma turma, podendo consultar, criar, alterar e excluir suas
 * questoes e seus formularios de avaliacao.
 * 
 * @author Rodrigo Morian Loures
 */
public class Avaliacao {

	private Long id;
	private Long turmaId;
	private List<Questao> questoes = new ArrayList<Questao>();
	private Set<FormAvaliacao> formulariosAvaliacao = new HashSet<FormAvaliacao>();

	public Avaliacao() {

	}

	/**
	 * Cria uma instancia de <code>Avaliacao</code> para o especificado
	 * identificador unico da <code>Turma</code>.
	 * 
	 * @param turmaId
	 *            Identificador unico da <code>Turma</code> para a qual se
	 *            deseja criar a <code>Avaliacao</code>.
	 */
	public Avaliacao(Long turmaId) {
		this.turmaId = turmaId;
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
	 * Obtem o identificador unico da <code>Turma</code> para qual se aplica a
	 * avaliacao.
	 * 
	 * @return O identificador unico da <code>Turma</code> para qual se aplica
	 *         a avaliacao.
	 */
	public Long getTurmaId() {
		return turmaId;
	}

	/**
	 * Atribui o identificador unico da <code>Turma</code> para a qual se
	 * aplica a avaliacao.
	 * 
	 * @param turmaId
	 *            Identificador unico da <code>Turma</code> para a qual se
	 *            deseja criar a avaliacao.
	 */
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	/**
	 * Obtem uma colecao, <code>Set</code> dos formularios preenchidos pelos
	 * alunos para a avaliacao.
	 * 
	 * @return <code>Set</code> dos formularios preenchidos pelos alunos para
	 *         a avaliacao.
	 */
	public Set<FormAvaliacao> getFormulariosAvaliacao() {
		return formulariosAvaliacao;
	}

	/**
	 * Atribui a colecao, <code>Set</code> de formularios preenchidos pelos
	 * alunos para a avaliacao.
	 * 
	 * @param formulariosAvaliacao
	 *            Um <code>Set</code> de formularios preenchidos pelos alunos
	 *            para a avaliacao.
	 */
	public void setFormulariosAvaliacao(Set<FormAvaliacao> formulariosAvaliacao) {
		this.formulariosAvaliacao = formulariosAvaliacao;
	}

	/**
	 * Obtem a colecao, <code>List</code> das questoes definidas para a
	 * avaliacao.
	 * 
	 * @return Uma <code>List</code> das questoes definidas para a avaliacao.
	 */
	public List<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * Atribui a colecao, <code>List</code> de questoes definidas para a
	 * avaliacao.
	 * 
	 * @param questoes
	 *            Um <code>List</code> de questoes definidas para a avaliacao.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean setQuestoes(List<Questao> questoes) {
		for (int i = 0; i < questoes.size() - 1; i++)
			for (int j = i + 1; j < questoes.size(); j++)
				if (questoes.get(i).equals(questoes.get(j)))
					return false;

		this.questoes = questoes;
		return true;
	}

	/**
	 * Obtem uma <code>Questao</code> de acordo com o indice informado.
	 * 
	 * @param indice
	 *            Indice da <code>Questao</code> que se deseja obter.
	 * @return A <code>Questao</code> de acordo com o indice.
	 */
	public Questao getQuestao(int indice) {
		return (Questao) questoes.get(indice);
	}

	/**
	 * Obtem uma <code>Questao</code> de acordo com o identificador unico da
	 * mesma para o banco de dados.
	 * 
	 * @param questaoId
	 *            Identificador unico de <code>Questao</code> para o banco de
	 *            dados.
	 * @return A <code>Questao</code> de acordo com seu identificador unico
	 *         para o banco de dados.
	 */
	public Questao getQuestao(Long questaoId) {
		for (int i = 0; i < questoes.size(); i++)
			if (questaoId.equals(questoes.get(i).getId()))
				return questoes.get(i);

		return null;
	}

	/**
	 * Adiciona uma <code>Questao</code> para a avaliacao.
	 * 
	 * @param questao
	 *            <code>Questao</code> que se deseja adicionar.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarQuestao(Questao questao) {
		Iterator<Questao> itQuestao;

		if (questao.getPergunta().isEmpty())
			return false;

		itQuestao = questoes.iterator();
		while (itQuestao.hasNext())
			if (questao.equals(itQuestao.next()))
				return false;

		return questoes.add(questao);
	}

	/**
	 * Adiciona uma <code>Questao</code> para a avaliacao.
	 * 
	 * @param objetiva
	 *            Se a <code>Questao</code> e Objetiva <code>true</code>,
	 *            ou Subjetiva <code>false</code>.
	 * @param pergunta
	 *            A pergunta da <code>Questao</code>.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarQuestao(boolean objetiva, String pergunta) {
		return adicionarQuestao(new Questao(objetiva, pergunta));
	}

	/**
	 * Remover uma <code>Questao</code> de acordo com o indice informado.
	 * 
	 * @param indice
	 *            Indice da <code>Questao</code> que se deseja remover.
	 * @return A <code>Questao</code> removida.
	 */
	public Questao removerQuestao(int indice) {
		return questoes.remove(indice);
	}

	/**
	 * Remover a <code>Questao</code> informada.
	 * 
	 * @param questao
	 *            A <code>Questao</code> que se deseja remover.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean removerQuestao(Questao questao) {
		return questoes.remove(questao);
	}

	/**
	 * Obtem um <code>FormAvaliacao</code> de acordo com o identificador unico
	 * do mesmo para o banco de dados.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @return <code>FormAvaliacao</code> de acordo com o identificador unico
	 *         do mesmo para o banco de dados.
	 */
	public FormAvaliacao getFormAvaliacao(Long formAvaliacaoId) {
		FormAvaliacao form;
		Iterator<FormAvaliacao> itForm;

		itForm = formulariosAvaliacao.iterator();
		while (itForm.hasNext()) {
			form = itForm.next();
			if (formAvaliacaoId.equals(form.getId()))
				return form;
		}
		return null;
	}

	/**
	 * Obtem um <code>FormAvaliacao</code> de acordo com o identificador unico
	 * do <code>Aluno</code> para o banco de dados.
	 * 
	 * @param alunoId
	 *            Identificador unico de <code>Aluno</code> para o banco de
	 *            dados.
	 * 
	 * @return <code>FormAvaliacao</code> de acordo com o identificador unico
	 *         do <code>Aluno</code> para o banco de dados.
	 */
	public FormAvaliacao getFormAvaliacaoAluno(Long alunoId) {
		FormAvaliacao form;
		Iterator<FormAvaliacao> itForm;

		itForm = formulariosAvaliacao.iterator();
		while (itForm.hasNext()) {
			form = itForm.next();
			if (alunoId.equals(form.getAlunoId()))
				return form;
		}
		return null;
	}

	/**
	 * Adiciona um <code>FormAvaliacao</code> para a avaliacao.
	 * 
	 * @param formAvaliacao
	 *            <code>FormAvaliacao</code> que se deseja adicionar.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean adicionarFormAvaliacao(FormAvaliacao formAvaliacao) {
		if (formAvaliacao.getAlunoId() == null
				|| formAvaliacao.getAlunoId() < 1L)
			return false;

		if (formAvaliacao.getAvaliacao() == null)
			formAvaliacao.setAvaliacao(this);

		return formulariosAvaliacao.add(formAvaliacao);
	}

	/**
	 * Adiciona um <code>FormAvaliacao</code> para a avaliacao.
	 * 
	 * @param alunoId
	 *            Identificador unico do <code>Aluno</code> para o qual se
	 *            deseja adicionar o <code>FormAvaliacao</code>.
	 * @return <code>FormAvaliacao</code> adicionado.
	 */
	public FormAvaliacao adicionarFormAvaliacao(Long alunoId) {
		FormAvaliacao form;

		if (alunoId == null || alunoId < 1L)
			return null;

		form = new FormAvaliacao(alunoId, this);
		if (formulariosAvaliacao.add(form))
			return form;
		else
			return null;
	}

	/**
	 * Remover o <code>FormAvaliacao</code> informado.
	 * 
	 * @param formAvaliacao
	 *            O <code>FormAvaliacao</code> que se deseja remover.
	 * @return <code>false</code> caso haja uma falha.
	 */
	public boolean removerFormAvaliacao(FormAvaliacao formAvaliacao) {
		return formulariosAvaliacao.remove(formAvaliacao);
	}

	/**
	 * Remover o <code>FormAvaliacao</code> de acordo com o identificador
	 * unico para o banco de dados do <code>Aluno</code>.
	 * 
	 * @param alunoId
	 *            Identificador unico do <code>Aluno</code> para o qual se
	 *            deseja remover o formulario de avaliacao.
	 * @return O <code>FormAvaliacao</code> que foi removido.
	 */
	public FormAvaliacao removerFormAvaliacao(Long alunoId) {
		FormAvaliacao form;

		form = getFormAvaliacaoAluno(alunoId);
		if (form != null)
			if (removerFormAvaliacao(form))
				return form;

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder saida = new StringBuilder();

		for (int i = 0; i < questoes.size(); i++)
			saida.append("\nQUESTAO NUMERO: " + (i + 1) + "\n"
					+ questoes.get(i).toString());

		return "AVALIACAO DA TURMA: " + turmaId + saida;
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
		result = prime * result + ((turmaId == null) ? 0 : turmaId.hashCode());
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
		final Avaliacao other = (Avaliacao) obj;
		if (turmaId == null) {
			if (other.turmaId != null)
				return false;
		} else if (!turmaId.equals(other.turmaId))
			return false;
		return true;
	}
}
