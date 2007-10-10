package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;

public interface DisciplinaRepositorio {
 
	public void gravar(Disciplina disciplina)throws Exception;
	public void excluir(long id) throws Exception;
	public Disciplina consultar(long id) throws Exception;
	
}
 
