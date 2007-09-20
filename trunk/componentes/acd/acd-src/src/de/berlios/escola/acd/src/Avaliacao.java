package de.berlios.escola.acd.src;

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
	private Turma turma;
	private List<Questao> questoes = new ArrayList<Questao>();
	private Set<FormAvaliacao> formulariosAvaliacao = new HashSet<FormAvaliacao>();

	public Avaliacao() {

	}

	/**
	 * Cria uma instancia de <code>Avaliacao</code> para a especificada
	 * <code>Turma</code>.
	 * 
	 * @param turma
	 *            Instancia de <code>Turma</code> para a qual se deseja criar
	 *            a <code>Avaliacao</code>.
	 */
	public Avaliacao(Turma turma) {
		this.turma = turma;
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
	 * Obtem a <code>Turma</code> para qual se aplica a avaliacao.
	 * 
	 * @return A <code>Turma</code> para qual se aplica a avaliacao.
	 */
	public Turma getTurma() {
		return turma;
	}

	/**
	 * Atribui uma <code>Turma</code> para a avaliacao.
	 * 
	 * @param turma
	 *            <code>Turma</code> para a qual se deseja criar a avaliacao.
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
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
			if (alunoId.equals(form.getAluno().getId()))
				return form;
		}
		return null;
	}

	/**
	 * Obtem um <code>FormAvaliacao</code> de acordo com a matricula do aluno
	 * informada.
	 * 
	 * @param matriculaAluno
	 *            Matricula do <code>Aluno</code>.
	 * @return <code>FormAvaliacao</code> de acordo com a matricula do aluno.
	 */
	public FormAvaliacao getFormAvaliacaoAluno(int matriculaAluno) {
		FormAvaliacao form;
		Iterator<FormAvaliacao> itForm;

		itForm = formulariosAvaliacao.iterator();
		while (itForm.hasNext()) {
			form = itForm.next();
			if (matriculaAluno == form.getAluno().getMatricula())
				return form;
		}
		return null;
	}

	/**
	 * Obtem um <code>FormAvaliacao</code> de acordo com a instancia de
	 * <code>Aluno</code> informada.
	 * 
	 * @param aluno
	 *            Instancia de <code>Aluno</code>.
	 * @return <code>FormAvaliacao</code> de acordo com a instancia de
	 *         <code>Aluno</code> informada.
	 */
	public FormAvaliacao getFormAvaliacaoAluno(Aluno aluno) {
		FormAvaliacao form;
		Iterator<FormAvaliacao> itForm;

		itForm = formulariosAvaliacao.iterator();
		while (itForm.hasNext()) {
			form = itForm.next();
			if (aluno.equals(form.getAluno()))
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
		if (formAvaliacao.getAluno() == null)
			return false;

		if (formAvaliacao.getAvaliacao() == null)
			formAvaliacao.setAvaliacao(this);

		return formulariosAvaliacao.add(formAvaliacao);
	}

	/**
	 * Adiciona um <code>FormAvaliacao</code> para a avaliacao.
	 * 
	 * @param aluno
	 *            <code>Aluno</code> para o qual se deseja adicionar o
	 *            <code>FormAvaliacao</code>.
	 * @return <code>FormAvaliacao</code> adicionado.
	 */
	public FormAvaliacao adicionarFormAvaliacao(Aluno aluno) {
		FormAvaliacao form;

		if (aluno == null)
			return null;

		form = new FormAvaliacao(aluno, this);
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
	 *            Identificador unico para o banco de dados do
	 *            <code>Aluno</code> para o qual se deseja remover o
	 *            formulario de avaliacao.
	 * @return O <code>FormAvaliacao</code> que foi removido.
	 */
	public FormAvaliacao removerFormAvaliacaoAluno(Long alunoId) {
		FormAvaliacao form;

		form = getFormAvaliacaoAluno(alunoId);
		if (form != null)
			if (removerFormAvaliacao(form))
				return form;

		return null;
	}

	/**
	 * Remover o <code>FormAvaliacao</code> de acordo com instancia de
	 * <code>Aluno</code> informada.
	 * 
	 * @param aluno
	 *            Instancia de <code>Aluno</code> para a qual se deseja
	 *            remover o formulario de avaliacao.
	 * @return O <code>FormAvaliacao</code> que foi removido.
	 */
	public FormAvaliacao removerFormAvaliacaoAluno(Aluno aluno) {
		FormAvaliacao form;

		form = getFormAvaliacaoAluno(aluno);
		if (form != null)
			if (removerFormAvaliacao(form))
				return form;

		return null;
	}

	/**
	 * Remover o <code>FormAvaliacao</code> de acordo com a matricula do
	 * aluno.
	 * 
	 * @param matriculaAluno
	 *            Matricula do <code>Aluno</code> para o qual se deseja
	 *            remover o formulario de avaliacao.
	 * @return O <code>FormAvaliacao</code> que foi removido.
	 */
	public FormAvaliacao removerFormAvaliacaoAluno(int matriculaAluno) {
		FormAvaliacao form;

		form = getFormAvaliacaoAluno(matriculaAluno);
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

		return "AVALIACAO DA TURMA: " + getTurma().getNome() + saida;
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
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
}
