package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;

public interface AlunoNegocio {
 
	public abstract void gravar(Aluno aluno)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Aluno consultar(long id)throws Exception;
	public abstract List<Aluno> consultar()throws Exception;
	public abstract Aluno consultar(String numeroMatricula)throws Exception;
}
 
