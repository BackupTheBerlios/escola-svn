package br.ufg.inf.apsi.escola.componentes.admc.servico;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import java.util.List;

public interface DocenteService {
 
	public void gravar(Docente docente)throws Exception;
	public void excluir(long id)throws Exception;
	public Docente consultar(long id)throws Exception;
	public List<Docente> consultar()throws Exception;
}
 
