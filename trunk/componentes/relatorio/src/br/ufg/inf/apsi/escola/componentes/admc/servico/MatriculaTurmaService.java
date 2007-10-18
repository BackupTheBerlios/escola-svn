package br.ufg.inf.apsi.escola.componentes.admc.servico;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;

public interface MatriculaTurmaService {
 
	public void gravar(MatriculaTurma matriculaTurma)throws Exception;
	public void excluir(String matriculaAluno)throws Exception;
	public List<Aluno> listaAlunos(String codigoTurma);
	public MatriculaTurma consultar(String matriculaAluno)throws Exception;
	public MatriculaTurma consultar(String codigoTurma,String matriculaAluno);
}
 
