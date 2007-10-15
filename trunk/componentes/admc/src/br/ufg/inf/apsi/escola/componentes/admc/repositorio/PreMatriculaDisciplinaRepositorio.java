package br.ufg.inf.apsi.escola.componentes.admc.repositorio;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;

public interface PreMatriculaDisciplinaRepositorio {
 
	public void gravar(PreMatriculaDisciplina preMatricula)throws Exception;
	public void excluir(String matriculaAluno)throws Exception;
	public PreMatriculaDisciplina consultar(String matriculaAluno)throws Exception;
	public List<PreMatriculaDisciplina> consultar() throws Exception;
}
 
