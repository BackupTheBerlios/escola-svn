package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import java.util.List;

public interface AlunoRepositorio {
 
	public abstract void gravar(Aluno aluno) throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Aluno consultar(long id)throws Exception ;
	public abstract List<Aluno> consultar() throws Exception;
}
 
