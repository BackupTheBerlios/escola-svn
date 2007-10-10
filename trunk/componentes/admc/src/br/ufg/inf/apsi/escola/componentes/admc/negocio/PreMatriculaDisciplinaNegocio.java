package br.ufg.inf.apsi.escola.componentes.admc.negocio;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.PreMatriculaDisciplina;

public interface PreMatriculaDisciplinaNegocio {
 
	public void gravar(PreMatriculaDisciplina preMatricula)throws Exception;
	public void excluir(String matriculaAluno)throws Exception;
	public PreMatriculaDisciplina consultar(String matriculaAluno)throws Exception;
}
 
