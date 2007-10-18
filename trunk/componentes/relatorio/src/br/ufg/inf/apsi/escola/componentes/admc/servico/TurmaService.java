package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;

/**
 * 
 * @author Fernando Nery Barros
 * 
 */
public interface TurmaService {

	/**
	 * 
	 * @param turma
	 * @throws Exception
	 */

	public abstract void gravar(Turma turma) throws Exception;

	/**
	 * 
	 * @param codigoTurma
	 * @throws Exception
	 */
	public abstract void excluir(String codigoTurma) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */

	public abstract List<Turma> consultar() throws Exception;

	/**
	 * 
	 * @param codigoTurma
	 * @return
	 * @throws Exception
	 */

	public abstract Turma consultar(String codigoTurma) throws Exception;
	
	public abstract List<Turma> consultarTurmasDocente(String matriculaDocente);

	public abstract List<Turma> consultarTurmasAluno(Long idPessoa);

	public abstract Curso consultaCurso(String codigoTurma);

	public abstract Disciplina consultaDisciplina(String codigoTurma);

	public abstract Docente consultaDocente(String codigoTurma);
}
