package br.ufg.inf.apsi.escola.componentes.acd.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;

/**
 * Esta interface oferece todos os servicos necessarios para um componente
 * externo trabalhar com a "Avaliacao do Corpo Docente". Ela oferece servicos de
 * manipulacao de <code>Avaliacao</code>, <code>Questao</code>,
 * <code>FormAvaliacao</code> e <code>Resposta</code>, podendo persistir e
 * recuperar esses objetos.
 * 
 * @author Rodrigo Morian Loures
 */
public interface AvaliacaoDocenteService {
	/**
	 * Recupera uma <code>Avaliacao</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return A <code>Avaliacao</code> conforme identificador.
	 */
	public Avaliacao buscarAvaliacao(Long avaliacaoId);

	/**
	 * Recupera o identificador unico de uma <code>Avaliacao</code>.
	 * 
	 * @param turmaId
	 *            Identificador unico de <code>Turma</code> para o banco de
	 *            dados.
	 * @return O identificador inico de <code>Avaliacao</code> conforme
	 *         identificador unico da <code>Turma</code>
	 */
	public Long buscarAvaliacaoId(Long turmaId);

	/**
	 * Cadastra uma <code>Avaliacao</code> para a <code>Turma</code>.
	 * Verifica se o periodo letivo da <code>Turma</code> esta em andamento.
	 * 
	 * @param turmaId
	 *            Identificador unico de <code>Turma</code> para o banco de
	 *            dados.
	 * @return Identificador unico de <code>Avaliacao</code> para o banco de
	 *         dados, ou "0L" caso haja uma falha.
	 */
	public Long cadastrarAvaliacao(Long turmaId);

	/**
	 * Exclui a <code>Avaliacao</code> de uma <code>Turma</code>. Verifica
	 * se a <code>Avaliacao</code> ja foi preenchida por algum
	 * <code>Aluno</code>, se sim, ela nao podera ser excluida.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return <code>false</code> caso haja uma falha ou ela nao possa ser
	 *         excluida.
	 */
	public boolean excluirAvaliacao(Long avaliacaoId);

	// ===================================================================

	/**
	 * Recupera uma <code>Questao</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param questaoId
	 *            Identificador unico de <code>Questao</code> para o banco de
	 *            dados.
	 * @return A <code>Questao</code> conforme identificadores.
	 */
	public Questao buscarQuestao(Long avaliacaoId, Long questaoId);

	/**
	 * Recupera uma colecao de todas as questoes de uma <code>Avaliacao</code> -
	 * uma <code>List</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return Uma <code>List</code> com todas as questoes da
	 *         <code>Avaliacao</code>.
	 */
	public List<Questao> buscarQuestoes(Long avaliacaoId);

	/**
	 * Cadastra uma <code>Questao</code> para a <code>Avaliacao</code>.
	 * Verifica se o periodo letivo da <code>Turma</code> esta em andamento, e
	 * se a <code>Avaliacao</code> já foi preenchida por algum
	 * <code>Aluno</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param objetiva
	 *            <code>true</code> - questao objetiva, <code>false</code> -
	 *            questao subjetiva.
	 * @param pergunta
	 *            Pergunta para a <code>Questao</code>.
	 * @return <code>false</code> caso haja uma falha ou a
	 *         <code>Questao</code> nao possa ser cadastrada.
	 */
	public boolean cadastrarQuestao(Long avaliacaoId, boolean objetiva,
			String pergunta);

	/**
	 * Altera uma <code>Questao</code> da <code>Avaliacao</code>. Verifica
	 * se o periodo letivo da <code>Turma</code> esta em andamento, e se a
	 * <code>Avaliacao</code> já foi preenchida por algum <code>Aluno</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param objetiva
	 *            <code>true</code> - questao objetiva, <code>false</code> -
	 *            questao subjetiva.
	 * @param pergunta
	 *            Pergunta para a <code>Questao</code>.
	 * @return <code>false</code> caso haja uma falha ou a
	 *         <code>Questao</code> nao possa ser alterada.
	 */
	public boolean alterarQuestao(Long avaliacaoId, Long questaoId,
			boolean objetiva, String pergunta);

	/**
	 * Exclui uma <code>Questao</code> da <code>Avaliacao</code>. Verifica
	 * se o periodo letivo da <code>Turma</code> esta em andamento, e se a
	 * <code>Avaliacao</code> já foi preenchida por algum <code>Aluno</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param questaoId
	 *            Identificador unico de <code>Questao</code> para o banco de
	 *            dados.
	 * @return <code>false</code> caso haja uma falha ou a
	 *         <code>Questao</code> nao possa ser excluida.
	 */
	public boolean excluirQuestao(Long avaliacaoId, Long questaoId);

	// ===================================================================

	/**
	 * Recupera um <code>FormAvaliacao</code>.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @return O <code>FormAvaliacao</code> conforme identificador.
	 */
	public FormAvaliacao buscarFormAvaliacao(Long formAvaliacaoId);

	/**
	 * Recupera o identificador unico de <code>FormAvaliacao</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param alunoId
	 *            Identificador unico de <code>Aluno</code> para o banco de
	 *            dados.
	 * @return O identificador unico do <code>FormAvaliacao</code> conforme a
	 *         <code>Avaliacao</code> e o <code>Aluno</code>.
	 */
	public Long buscarFormAvaliacaoId(Long avaliacaoId, Long alunoId);

	/**
	 * Recupera uma colecao de todos os formularios de avaliacao de uma
	 * <code>Avaliacao</code> - um <code>Set</code>.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return Um <code>Set</code> com todos os formularios de avaliacao de
	 *         uma <code>Avaliacao</code>.
	 */
	public List<FormAvaliacao> buscarFormulariosAvaliacao(Long avaliacaoId);

	/**
	 * Cadastra um <code>FormAvaliacao</code> para a <code>Avaliacao</code>
	 * e para um <code>Aluno</code>. Verifica se o periodo letivo da
	 * <code>Turma</code> esta em andamento.
	 * 
	 * @param avaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @param alunoId
	 *            Identificador unico de <code>Aluno</code> para o banco de
	 *            dados.
	 * @return Identificador unico de <code>FormAvaliacao</code> para o banco
	 *         de dados, ou "0L" caso haja uma falha.
	 */
	public Long cadastrarFormAvaliacao(Long avaliacaoId, Long alunoId);

	/**
	 * Exclui um <code>FormAvaliavao</code> da <code>Avaliacao</code>.
	 * Verifica se o periodo letivo da <code>Turma</code> esta em andamento.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>Avaliacao</code> para o banco
	 *            de dados.
	 * @return <code>false</code> caso haja uma falha ou o
	 *         <code>FormAvaliacao</code> nao possa ser excluido.
	 */
	public boolean excluirFormAvaliacao(Long formAvaliacaoId);

	// ===================================================================

	/**
	 * Recupera uma <code>Resposta</code>.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @param respostaId
	 *            Identificador unico de <code>Resposta</code> para o banco de
	 *            dados.
	 * @return A <code>Resposta</code> conforme identificadores.
	 */
	public Resposta buscarResposta(Long formAvaliacaoId, Long respostaId);

	/**
	 * Recupera uma colecao de todas as respostas de um
	 * <code>FormAvaliacao</code> - uma <code>List</code>.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @return Uma <code>List</code> com todas as respostas do
	 *         <code>FormAvaliacao</code>.
	 */
	public List<Resposta> buscarRespostas(Long formAvaliacaoId);

	/**
	 * Altera ou informa uma <code>Resposta</code> do
	 * <code>FormAvaliacao</code>. Verifica se o periodo letivo da
	 * <code>Turma</code> esta em andamento.
	 * 
	 * @param formAvaliacaoId
	 *            Identificador unico de <code>FormAvaliacao</code> para o
	 *            banco de dados.
	 * @param respostaId
	 *            Identificador unico de <code>Resposta</code> para o banco de
	 *            dados.
	 * @param resposta
	 *            Resposta da <code>Questao</code>.
	 * @return <code>false</code> caso haja uma falha ou a
	 *         <code>Resposta</code> nao possa ser alterada.
	 */
	public boolean alterarResposta(Long formAvaliacaoId, Long respostaId,
			String resposta);
}
