package br.ufg.inf.apsi.escola.componentes.admc.servico;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.ProgramaDisciplina;
import java.util.List;

public interface ProgramaDisciplinaService {
 
	public abstract void gravar(ProgramaDisciplina programa)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract ProgramaDisciplina consultar(long id)throws Exception;
	public abstract List<ProgramaDisciplina> consultar()throws Exception;
}
 
