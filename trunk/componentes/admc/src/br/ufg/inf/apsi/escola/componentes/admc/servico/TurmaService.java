package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;

/**
 * 
 * @author Fernando Nery Barros
 * 
 */
public interface TurmaService {

	public abstract void gravar(Turma turma) throws Exception;

	public abstract void excluir(String codigoTurma) throws Exception;

	public abstract List<Turma> consultar() throws Exception;

	public abstract Turma consultar(String codigoTurma) throws Exception;
}
