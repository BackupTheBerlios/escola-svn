package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import net.sf.jasperreports.engine.JasperPrint;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.expnf.servico.ExpressaoNotaService;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;
import br.ufg.inf.apsi.escola.componentes.nf.servico.NotaFrequenciaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;

/**
 * Classe de teste da classe RelatorioNotasFrequenciasTurmaBean (Camada de Negocio).
 * 
 * @author Yoshiyuki
 * 
 */
public class RelatorioNotasFrequenciasTurmaBeanTest extends TestCase {

	private Mockery contextoTurmaService;
	private Mockery contextoMatriculaTurmaService;
	private Mockery contextoPessoaService;
	private Mockery contextoNotaFrequenciaService;
	private Mockery contextoExpressaoNotaService;

	private TurmaService turmaService;
	private MatriculaTurmaService matriculaTurmaService;
	private PessoaService pessoaService;
	private NotaFrequenciaService notaFrequenciaService;
	private ExpressaoNotaService expressaoNotaService;

	private RelatorioNotasFrequenciasTurmaBean relatorioNotasFrequenciasTurmaBean;

	private Curso curso;
	private Disciplina disciplina;
	private Turma turma;
	private MatriculaTurma matriculaTurma1, matriculaTurma2;
	private Pessoa pessoa0, pessoa1, pessoa2;
	private Docente docente;
	private Aluno aluno1, aluno2;
	private Nota notaA11, notaA12, notaA13, notaA14;
	private Nota notaA21, notaA22, notaA23, notaA24;
	private Frequencia freqA11, freqA12, freqA13, freqA14, freqA15;
	private Frequencia freqA21, freqA22, freqA23, freqA24, freqA25;
	private List<Aluno> listaAluno;
	private List<Nota> listaNotaA1, listaNotaA2;
	private List<Frequencia> listaFreqA1, listaFreqA2;

	/**
	 * Inicialização de atributos.
	 */
	protected void setUp() throws Exception {
		contextoTurmaService = new JUnit4Mockery();
		contextoMatriculaTurmaService = new JUnit4Mockery();
		contextoPessoaService = new JUnit4Mockery();
		contextoNotaFrequenciaService = new JUnit4Mockery();
		contextoExpressaoNotaService = new JUnit4Mockery();

		turmaService = contextoTurmaService.mock(TurmaService.class);
		matriculaTurmaService = contextoMatriculaTurmaService.mock(MatriculaTurmaService.class);
		pessoaService = contextoPessoaService.mock(PessoaService.class);
		notaFrequenciaService = contextoNotaFrequenciaService.mock(NotaFrequenciaService.class);
		expressaoNotaService = contextoExpressaoNotaService.mock(ExpressaoNotaService.class);

		relatorioNotasFrequenciasTurmaBean = new RelatorioNotasFrequenciasTurmaBean();
		relatorioNotasFrequenciasTurmaBean.setTurmaService(turmaService);
		relatorioNotasFrequenciasTurmaBean.setMatriculaTurmaService(matriculaTurmaService);
		relatorioNotasFrequenciasTurmaBean.setPessoaService(pessoaService);
		relatorioNotasFrequenciasTurmaBean.setNotaFrequenciaService(notaFrequenciaService);
		relatorioNotasFrequenciasTurmaBean.setExpressaoNotaService(expressaoNotaService);
		relatorioNotasFrequenciasTurmaBean.setArquivoDeModeloJasper("/home/sponja/workspace-rh/relatorio/web/resources/NFDosAlunosDeUmaTurma.jasper");
		relatorioNotasFrequenciasTurmaBean.setArquivoDaImagemDoCabecalho("/home/sponja/workspace-rh/relatorio/web/resources/cabecalho_relatorio.gif");

		curso = new Curso("C0001/07","Especialização em Segurança de Redes");
		curso.setId(new Long(1));
		disciplina = new Disciplina("IDS - Sistema de Detecção de Intrusão","D00001/07","Blablabla...",390, curso);
		disciplina.setId(new Long(1));
		pessoa0 = new PessoaFisica("Joao Costa"); 
		pessoa1 = new PessoaFisica("Maria de Lourdes"); 
		pessoa2 = new PessoaFisica("Severino Medeiros");
		pessoa0.setId(new Long(1));
		pessoa1.setId(new Long(2));
		pessoa2.setId(new Long(3));
		aluno1 = new Aluno(pessoa1.getId(),"A000001/07",curso);
		aluno2 = new Aluno(pessoa2.getId(),"A000002/07",curso);
		curso.addAluno(aluno1);
		curso.addAluno(aluno2);
		docente = new Docente("D001", "Mestrado concluido", new ArrayList<Turma>(), pessoa0.getId());
		turma = new Turma("T00001/07", "(n1+n2+n3+n4)/4", 4, false, true, disciplina, docente);
		docente.addTurma(turma);
		matriculaTurma1 = new MatriculaTurma("A000001/07", turma);
		matriculaTurma2 = new MatriculaTurma("A000002/07", turma);
		notaA11 = new Nota(8.6);
		notaA12 = new Nota(7.8);
		notaA13 = new Nota(9.1);
		notaA14 = new Nota(7.7);
		notaA21 = new Nota(6.7);
		notaA22 = new Nota(8.5);
		notaA23 = new Nota(9.4);
		notaA24 = new Nota(9.8);
		freqA11 = new Frequencia(new Date(),true);
		freqA12 = new Frequencia(new Date(),false);
		freqA13 = new Frequencia(new Date(),true);
		freqA14 = new Frequencia(new Date(),true);
		freqA15 = new Frequencia(new Date(),true);
		freqA21 = new Frequencia(new Date(),true);
		freqA22 = new Frequencia(new Date(),false);
		freqA23 = new Frequencia(new Date(),true);
		freqA24 = new Frequencia(new Date(),false);
		freqA25 = new Frequencia(new Date(),true);
		listaAluno = new ArrayList<Aluno>();
		listaAluno.add(aluno1);
		listaAluno.add(aluno2);
		listaNotaA1 = new ArrayList<Nota>();
		listaNotaA1.add(notaA11);
		listaNotaA1.add(notaA12);
		listaNotaA1.add(notaA13);
		listaNotaA1.add(notaA14);
		listaNotaA2 = new ArrayList<Nota>();
		listaNotaA2.add(notaA21);
		listaNotaA2.add(notaA22);
		listaNotaA2.add(notaA23);
		listaNotaA2.add(notaA24);
		listaFreqA1 = new ArrayList<Frequencia>();
		listaFreqA1.add(freqA11);
		listaFreqA1.add(freqA12);
		listaFreqA1.add(freqA13);
		listaFreqA1.add(freqA14);
		listaFreqA1.add(freqA15);
		listaFreqA2 = new ArrayList<Frequencia>();
		listaFreqA2.add(freqA21);
		listaFreqA2.add(freqA22);
		listaFreqA2.add(freqA23);
		listaFreqA2.add(freqA24);
		listaFreqA2.add(freqA25);

	}

	/**
	 * Teste do método GerarRelatorio.
	 */
	public void testGerarRelatorio() {
	
		try {
			contextoTurmaService.checking(new Expectations() {
				{
					one(turmaService).consultar(turma.getId());
					will(returnValue(turma));

					one(turmaService).consultaCurso(turma.getId());
					will(returnValue(curso));

					one(turmaService).consultaDisciplina(turma.getId());
					will(returnValue(disciplina));

					one(turmaService).consultaDocente(turma.getId());
					will(returnValue(docente));
				}
			});
		} catch (Exception e) {
			fail("Exceção não esperada.");
		}

		try {
			contextoPessoaService.checking(new Expectations() {
				{
					one(pessoaService).consultaPessoaId(pessoa0.getId());
					will(returnValue(pessoa0.getNome()));
	
					one(pessoaService).consultaPessoaId(pessoa1.getId());
					will(returnValue(pessoa1.getNome()));
	
					one(pessoaService).consultaPessoaId(pessoa2.getId());
					will(returnValue(pessoa2.getNome()));
				}
			});
		} catch (EscolaException e) {
			fail("EscolaException não era esperado.");
		}

		contextoMatriculaTurmaService.checking(new Expectations() {
			{
				one(matriculaTurmaService).listaAlunos(turma.getId());
				will(returnValue(listaAluno));

				one(matriculaTurmaService).consultar(turma.getId(), aluno1.getNumeroMatricula());
				will(returnValue(matriculaTurma1));

				one(matriculaTurmaService).consultar(turma.getId(), aluno2.getNumeroMatricula());
				will(returnValue(matriculaTurma2));
			}
		});

		contextoNotaFrequenciaService.checking(new Expectations() {
			{
				one(notaFrequenciaService).obterFrequenciasDoAluno(matriculaTurma1);
				will(returnValue(listaFreqA1));

				one(notaFrequenciaService).obterNotasDoAluno(matriculaTurma1);
				will(returnValue(listaNotaA1));
				
				one(notaFrequenciaService).obterFrequenciasDoAluno(matriculaTurma2);
				will(returnValue(listaFreqA2));
				
				one(notaFrequenciaService).obterNotasDoAluno(matriculaTurma2);
				will(returnValue(listaNotaA2));
			}
		});

		contextoExpressaoNotaService.checking(new Expectations() {
			{
				one(expressaoNotaService).calculaNotaFinal(listaNotaA1, turma.getExpressao());
				will(returnValue(8.3));

				one(expressaoNotaService).calculaNotaFinal(listaNotaA2, turma.getExpressao());
				will(returnValue(8.6));
			}
		});

		try {
			JasperPrint jp = null;
			jp = relatorioNotasFrequenciasTurmaBean.gerarRelatorio(turma.getId());
			assertNotNull(jp);
		} catch (Exception e) {
			fail("Exceção não era esperada.");
		}
		
	}
	
}
