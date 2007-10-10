package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;

public interface TurmaRepositorio {
 
	public abstract void gravar(Turma turma)throws Exception;
	public abstract void excluir(String codigoTurma)throws Exception;
	public abstract List consultar()throws Exception;
	public abstract Turma consultar(String codigoTurma)throws Exception;
}
 
