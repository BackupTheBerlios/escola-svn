package br.ufg.inf.apsi.escola.servicos.local;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.PreMatriculaDisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.ie.EscolaServiceDelegate;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;

public class LocalServiceFactory implements ServiceFactory {

	/**
	 * Referencia uma implementacao de EscolaServiceDelegate
	 */
	private EscolaServiceDelegate escolaServiceDelegate = null;

	/** Creates a new instance of LocalServiceFactory */
	public LocalServiceFactory() {
		escolaServiceDelegate = EscolaServiceDelegate.getInstancia();
	}

	public PessoaService obterPessoaService(){
		return (PessoaService) escolaServiceDelegate.obtemServico("localPessoaService");
	}
	
	public AlunoService obterAlunoService() {
		return (AlunoService) escolaServiceDelegate
				.obtemServico("localAlunoService");
	}

	public CursoService obterCursoService() {
		return (CursoService) escolaServiceDelegate
				.obtemServico("localCursoService");
	}

	public DisciplinaService obterDisciplinaService() {
		return (DisciplinaService) escolaServiceDelegate
				.obtemServico("localDisciplinaService");
	}

	public MatriculaTurmaService obterMatriculaTurmaService() {
		return (MatriculaTurmaService) escolaServiceDelegate
				.obtemServico("localMatriculaTurmaService");
	}

	public PreMatriculaDisciplinaService obterPreMatriculaDisciplinaService() {
		return (PreMatriculaDisciplinaService) escolaServiceDelegate
				.obtemServico("localPreMatriculaDisciplinaService");
	}

	public TurmaService obterTurmaService() {
		return (TurmaService) escolaServiceDelegate
				.obtemServico("localTurmaService");
	}

	public DocenteService obterDocenteService() {
		return (DocenteService) escolaServiceDelegate
				.obtemServico("localDocenteService");
	}

}
