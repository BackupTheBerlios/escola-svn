package br.ufg.inf.apsi.escola.componentes.admc.servico.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.repositorioParaTeste.RepositorioTeste;
public class LocalTurmaService implements TurmaService {

	private RepositorioTeste repositorio;
	
	public LocalTurmaService(){
		repositorio = RepositorioTeste.getRepositorioTeste();
	}
	
	public Curso consultaCurso(String codigoTurma) {
		return null;
	}

	public Disciplina consultaDisciplina(String codigoTurma) {
		return null;
	}

	public Docente consultaDocente(String codigoTurma) {
		return null;
	}

	public List<Turma> consultar() throws Exception {
		return null;
	}

	public Turma consultar(String codigoTurma) throws Exception {
		return null;
	}

	public List<Turma> consultarTurmasAluno(Long idPessoa) {
		List<Turma> l = new ArrayList<Turma>();

		MatriculaTurma[] amt = repositorio.getMatriculaTurma();
		HashMap<String,Aluno> hmAluno = repositorio.getAlunoHM();
		
		Aluno aluno;
		
		for(int i=1;i<amt.length;i++){
			aluno = hmAluno.get(amt[i].getMatriculaAluno());
			if (aluno.getPessoa() == idPessoa){
				l.add(amt[i].getTurma());
			}
		}
		return l;
	}

	public List<Turma> consultarTurmasDocente(String matriculaDocente) {
		List<Turma> l = new ArrayList<Turma>();

		Turma[] at = repositorio.getTurma();
		for(int i=1;i<at.length;i++)
			if (at[i].getDocente().getMatricula().equals(matriculaDocente))
				l.add(at[i]);
		return l;
	}

	public void excluir(String codigoTurma) throws Exception {

	}

	public void gravar(Turma turma) throws Exception {

	}
}
