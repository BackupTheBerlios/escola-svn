package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;

public interface ProgramaDisciplinaRepositorio {
 
	public abstract void gravar(ProgramaDisciplina programa)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract ProgramaDisciplina consultar(long id)throws Exception;
	public abstract List<ProgramaDisciplina> consultar() throws Exception;
}
 
