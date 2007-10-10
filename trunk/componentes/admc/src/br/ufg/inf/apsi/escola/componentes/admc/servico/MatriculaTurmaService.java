package br.ufg.inf.apsi.escola.componentes.admc.servico;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;

public interface MatriculaTurmaService {
 
	public void gravar(MatriculaTurma matriculaTurma)throws Exception;
	public void excluir(String matriculaAluno)throws Exception;
	public MatriculaTurma consultar(String matriculaAluno)throws Exception;
}
 
