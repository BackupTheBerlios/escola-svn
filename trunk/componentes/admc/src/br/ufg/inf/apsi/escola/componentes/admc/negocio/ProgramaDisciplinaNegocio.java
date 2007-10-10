package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;
import java.util.List;

public interface ProgramaDisciplinaNegocio {
 
	public abstract void gravar(ProgramaDisciplina programaDisciplina)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract ProgramaDisciplina consultar(long id)throws Exception;
	public abstract List<ProgramaDisciplina> consultar()throws Exception;
}
 
