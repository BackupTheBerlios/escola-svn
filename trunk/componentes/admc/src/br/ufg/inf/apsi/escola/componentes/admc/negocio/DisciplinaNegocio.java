package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;

public interface DisciplinaNegocio {
 
	public abstract void gravar(Disciplina disciplina)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Disciplina consultar(long id)throws Exception;
	
}
 
