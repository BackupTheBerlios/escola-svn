package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import java.util.List;

public interface AlunoNegocio {
 
	public abstract void gravar(Aluno aluno)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Aluno consultar(long id)throws Exception;
	public abstract List<Aluno> consultar()throws Exception;
}
 
