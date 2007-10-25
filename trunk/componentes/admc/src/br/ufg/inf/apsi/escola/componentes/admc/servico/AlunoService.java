package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;

public interface AlunoService {
 
	public abstract void gravar(Aluno aluno)throws Exception;
	public abstract void excluir(long id)throws Exception;
	public abstract Aluno consultar(long id)throws Exception;
	public abstract List<Aluno> consultar()throws Exception;
}
 
