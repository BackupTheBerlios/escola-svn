package de.berlios.escola.acd.src;

import java.util.List;

/**
 * Esta Interface fornece servicos de recuperar, gravar, alterar e excluir
 * informacoes de <code>FormAvaliacao</code> e de <code>Resposta</code> do
 * banco de dados, ou para o banco de dados.
 * 
 * @author Rodrigo Morian Loures
 */
public interface FormAvaliacaoRepository {

	/**
	 * Recupera uma instancia de <code>FormAvaliacao</code> e todas as suas
	 * instancias de <code>Resposta</code> do banco de dados a partir de seu
	 * identificador.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @return Uma instancia de <code>FormAvaliacao</code> do banco de dados.
	 */
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId);

	/**
	 * Recupera uma instancia de <code>FormAvaliacao</code> e todas as suas
	 * instancias de <code>Resposta</code> do banco de dados a partir dos
	 * identificadores de <code>Avaliacao</code> e de <code>Aluno</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @param alunoId
	 *            Identificador unico de <code>Aluno</code> para o banco de
	 *            dados.
	 * @return Uma instancia de <code>FormAvaliacao</code> do banco de dados.
	 */
	public FormAvaliacao buscarFormAvaliacao(Long avaliacaoId, Long alunoId);

	/**
	 * Recupera uma <code>List</code> de todas os formularios de Avaliacao de
	 * uma <code>Avaliacao</code> do banco de dados a partir do identificador
	 * de <code>Avaliacao</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return Uma <code>List</code> de <code>FormAvaliacao</code> do banco
	 *         de dados.
	 */
	public List<FormAvaliacao> buscarListFormAvaliacao(Long avaliacaoId);

	/**
	 * Recupera uma <code>List</code> de todas as respostas de um
	 * <code>FormAvaliacao</code> do banco de dados a partir do identificador
	 * de <code>FormAvaliacao</code>.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @return Uma <code>List</code> de <code>Resposta</code> do banco de
	 *         dados.
	 */
	public List<Resposta> buscarListResposta(Long formAvaliacaoId);

	/**
	 * Grava uma instancia de <code>FormAvaliacao</code> e todas as suas
	 * instancias de <code>Resposta</code> no banco de dados.
	 * 
	 * @param formAvaliacao
	 *            Uma instancia de <code>FormAvaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean gravarFormAvaliacao(FormAvaliacao formAvaliacao);

	/**
	 * Atualiza uma instancia de <code>FormAvaliacao</code> e todas as suas
	 * instancias de <code>Resposta</code> no banco de dados.
	 * 
	 * @param formAvaliacao
	 *            Uma instancia de <code>FormAvaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean alterarFormAvaliacao(FormAvaliacao formAvaliacao);

	/**
	 * Exclui uma instancia de <code>FormAvaliacao</code> e todas as suas
	 * instancias de <code>Resposta</code> no banco de dados.
	 * 
	 * @param formAvaliacao
	 *            Uma instancia de <code>FormAvaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean excluirFormAvaliacao(FormAvaliacao formAvaliacao);
}
