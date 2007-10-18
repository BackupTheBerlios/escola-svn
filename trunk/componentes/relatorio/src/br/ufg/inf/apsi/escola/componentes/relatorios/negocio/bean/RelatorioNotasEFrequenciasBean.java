package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.expnf.servico.ExpressaoNotaFinalService;
import br.ufg.inf.apsi.escola.componentes.nf.servico.NotaFrequenciaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.relatorios.modelo.TurmaNaoEncontradaException;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioNotasEFrequencias;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource.DadosNFDosAlunosDeUmaTurma;

public class RelatorioNotasEFrequenciasBean implements
		RelatorioNotasEFrequencias {
	private CursoService cursoService;
	private TurmaService turmaService;
	private MatriculaTurmaService matriculaTurmaService;
	private PessoaService pessoaService;
	private NotaFrequenciaService notaFrequenciaService;
	private ExpressaoNotaFinalService expressaoNotaFinalService;
	
	public RelatorioNotasEFrequenciasBean() {
		cursoService = null;
		turmaService = null;
		matriculaTurmaService = null;
		pessoaService = null;
		notaFrequenciaService = null;
		expressaoNotaFinalService = null;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	public void setMatriculaTurmaService(
			MatriculaTurmaService matriculaTurmaService) {
		this.matriculaTurmaService = matriculaTurmaService;
	}

	public void setNotaFrequenciaService(NotaFrequenciaService notaFrequenciaService) {
		this.notaFrequenciaService = notaFrequenciaService;
	}

	public void setExpressaoNotaFinalService(
			ExpressaoNotaFinalService expressaoNotaFinalService) {
		this.expressaoNotaFinalService = expressaoNotaFinalService;
	}

	public void relatorioNFDosAlunosDeUmaTurma(String codigoTurma, OutputStream outputStream) throws FileNotFoundException, JRException, TurmaNaoEncontradaException {
		DadosNFDosAlunosDeUmaTurma dataSource = new DadosNFDosAlunosDeUmaTurma(
				cursoService,
				turmaService,
				matriculaTurmaService,
				pessoaService,
				notaFrequenciaService,
				expressaoNotaFinalService,
				codigoTurma);
		
		HashMap<Object,Object> parameters = new HashMap<Object,Object>();
		FileInputStream inputStream = new FileInputStream("NFDosAlunosDeUmaTurma.jasper");
		JasperRunManager.runReportToPdfStream(inputStream, outputStream, parameters, dataSource);
		
	}

	public OutputStream relatorioNFDeUmAlunoEmTodasTurmas(Long idPessoa) {
		return null;
	}

	public OutputStream relatorioNFDeUmAlunoEmUmaTurma(Long idPessoa,
			String codigoTurma) {
		return null;
	}


}
