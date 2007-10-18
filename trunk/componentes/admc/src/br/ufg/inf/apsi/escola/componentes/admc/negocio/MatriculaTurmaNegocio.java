package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;

public interface MatriculaTurmaNegocio {
 
	public abstract void gravar(MatriculaTurma matriculaTurma)throws Exception;
	public abstract void excluir(String matriculaAluno)throws Exception;
	public abstract MatriculaTurma consultar(String matriculaAluno)throws Exception;
	public abstract List<MatriculaTurma> consultar()throws Exception;
}
 
