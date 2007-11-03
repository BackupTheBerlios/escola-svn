package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.repositorioParaTeste.RepositorioTeste;

public class LocalMatriculaTurmaService implements MatriculaTurmaService {

	private RepositorioTeste repositorio;
	
	public LocalMatriculaTurmaService(){
		repositorio = RepositorioTeste.getRepositorioTeste();
	}

	public MatriculaTurma consultar(String matriculaAluno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public MatriculaTurma consultar(Long idTurma, String matriculaAluno) {
		MatriculaTurma[] mt =  repositorio.getMatriculaTurma();
		for(int i=1;i<mt.length;i++) 
			if (mt[i].getTurma().getId().equals(idTurma))
				if (mt[i].getMatriculaAluno().equals(matriculaAluno))
					return mt[i];
		return null;
	}

	public void excluir(String matriculaAluno) throws Exception {
		// TODO Auto-generated method stub

	}

	public void gravar(MatriculaTurma matriculaTurma) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Aluno> listaAlunos(Long idTurma) {
		List<Aluno> l = new ArrayList<Aluno>(); 
		MatriculaTurma[] mt =  repositorio.getMatriculaTurma();
		for(int i=1;i<mt.length;i++) 
			if (mt[i].getTurma().getId().equals(idTurma))
				l.add(repositorio.getAlunoHM().get(mt[i].getMatriculaAluno()));

		return l;
	}

}
