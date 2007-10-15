package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import java.util.List;

public interface TurmaNegocio {
 
	public abstract void gravar(Turma turma)throws Exception;
	public abstract void excluir(String codigoTurma)throws Exception;
	public abstract List<Turma> consultar()throws Exception;
	public abstract Turma consultar(String codigoTurma)throws Exception;
}
 
