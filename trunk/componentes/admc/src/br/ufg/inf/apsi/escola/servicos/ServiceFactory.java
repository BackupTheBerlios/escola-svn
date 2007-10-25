package br.ufg.inf.apsi.escola.servicos;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;

public interface ServiceFactory {

	PessoaService obterPessoaService();
	AlunoService obterAlunoService();
	CursoService obterCursoService();
	DisciplinaService obterDisciplinaService();
	MatriculaTurmaService obterMatriculaTurmaService();
	PreMatriculaDisciplinaService obterPreMatriculaDisciplinaService();
	TurmaService obterTurmaService();
	
}
