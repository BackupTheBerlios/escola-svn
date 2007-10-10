package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import java.util.List;

public interface DocenteNegocio {
 
	public abstract void gravar(Docente docente)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Docente consultar(long id)throws Exception;
	public abstract List<Docente> consultar()throws Exception;
}
 
