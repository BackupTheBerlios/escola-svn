package br.ufg.inf.apsi.escola.componentes.acd.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;

/**
 * Esta Interface fornece servicos de recuperar, gravar, alterar e excluir
 * informacoes de <code>Avaliacao</code> e de <code>Questao</code> do banco
 * de dados, ou para o banco de dados.
 * 
 * @author Rodrigo Morian Loures
 */
public interface AvaliacaoRepository {
	/**
	 * Recupera uma instancia de <code>Avaliacao</code> e todas as suas
	 * instancias de <code>Questao</code> do banco de dados a partir de seu
	 * identificador.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return Uma instancia de <code>Avaliacao</code> do banco de dados.
	 */
	public Avaliacao buscarAvaliacao(Long avaliacaoId);

	/**
	 * Recupera uma instancia de <code>Avaliacao</code> e todas as suas
	 * instancias de <code>Questao</code> do banco de dados a partir do
	 * identificador de Turma.
	 * 
	 * @param turmaId
	 *            Identificador unico de <code>Turma</code> para o banco de
	 *            dados.
	 * @return Uma instancia de <code>Avaliacao</code> do banco de dados.
	 */
	public Avaliacao buscarAvaliacaoTurma(Long turmaId);

	/**
	 * Grava uma instancia de <code>Avaliacao</code> e todas as suas
	 * instancias de <code>Questao</code> no banco de dados.
	 * 
	 * @param avaliacao
	 *            Uma instancia de <code>Avaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean gravarAvaliacao(Avaliacao avaliacao);

	/**
	 * Atualiza uma instancia de <code>Avaliacao</code> e todas as suas
	 * instancias de <code>Questao</code> no banco de dados.
	 * 
	 * @param avaliacao
	 *            Uma instancia de <code>Avaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean alterarAvaliacao(Avaliacao avaliacao);

	/**
	 * Exclui uma instancia de <code>Avaliacao</code> e todas as suas
	 * instancias de <code>Questao</code> no banco de dados.
	 * 
	 * @param avaliacao
	 *            Uma instancia de <code>Avaliacao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean excluirAvaliacao(Avaliacao avaliacao);

	// ===================================================================

	/**
	 * Recupera uma instancia de <code>Questao</code> do banco de dados a
	 * partir de seu identificador.
	 * 
	 * @param questaoId
	 *            Identificador unico de <code>Questao</code> para o banco de
	 *            dados.
	 * @return Uma instancia de <code>Questao</code> do banco de dados.
	 */
	public Questao buscarQuestao(Long questaoId);

	/**
	 * Recupera uma <code>List</code> de todas as questoes de uma
	 * <code>Avaliacao</code> do banco de dados a partir do identificador de
	 * <code>Avaliacao</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return Uma <code>List</code> de <code>Questao</code> do banco de
	 *         dados.
	 */
	public List<Questao> buscarListQuestao(Long avaliacaoId);

	/**
	 * Grava uma instancia de <code>Questao</code> no banco de dados.
	 * 
	 * @param questao
	 *            Uma instancia de <code>Questao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean gravarQuestao(Questao questao);

	/**
	 * Atualiza uma instancia de <code>Questao</code> no banco de dados.
	 * 
	 * @param questao
	 *            Uma instancia de <code>Questao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean alterarQuestao(Questao questao);

	/**
	 * Exclui uma instancia de <code>Questao</code> da <code>Avaliacao</code>
	 * no banco de dados.
	 * 
	 * @param questao
	 *            Uma instancia de <code>Questao</code>.
	 * @return Retorna <code>false</code> caso haja algum erro.
	 */
	public boolean excluirQuestao(Questao questao);
}
