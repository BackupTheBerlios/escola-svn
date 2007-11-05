package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import net.sf.jasperreports.engine.JasperPrint;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

import br.ufg.inf.apsi.escola.componentes.acd.modelo.Avaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Questao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaFisica;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;

/**
 * Classe de teste da classe RelatorioAvaliacaoDocenteTurmaBean (Camada de Negocio).
 * 
 * @author Yoshiyuki
 * 
 */
public class RelatorioAvaliacaoDocenteTurmaBeanTest extends TestCase {

	private Mockery contextoTurmaService;
	private Mockery contextoPessoaService;
	private Mockery contextoAvaliacaoDocenteService;

	private TurmaService turmaService;
	private PessoaService pessoaService;
	private AvaliacaoDocenteService avaliacaoDocenteService;
	
	RelatorioAvaliacaoDocenteTurmaBean relatorioAvaliacaoDocenteTurmaBean;

	private Curso curso;
	private Turma turma;
	private Disciplina disciplina;
	
	private Pessoa pessoa0, pessoa1, pessoa2;
	private Docente docente;
	private Aluno aluno1, aluno2;

	private Avaliacao avaliacao;
	private Questao questao1, questao2;
	private FormAvaliacao formAvaliacao1, formAvaliacao2;
	private Resposta resposta11, resposta12;
	private Resposta resposta21, resposta22;
	
	private List<FormAvaliacao> listaFormAvaliacao;
	private List<Resposta> listaResposta1, listaResposta2;
	
	/**
	 * Inicialização de atributos.
	 */
	protected void setUp() throws Exception {
		contextoTurmaService = new JUnit4Mockery();
		contextoPessoaService = new JUnit4Mockery();
		contextoAvaliacaoDocenteService = new JUnit4Mockery();
	
		turmaService = contextoTurmaService.mock(TurmaService.class);
		pessoaService = contextoPessoaService.mock(PessoaService.class);
		avaliacaoDocenteService = contextoAvaliacaoDocenteService.mock(AvaliacaoDocenteService.class);
	
		relatorioAvaliacaoDocenteTurmaBean = new RelatorioAvaliacaoDocenteTurmaBean();
		relatorioAvaliacaoDocenteTurmaBean.setTurmaService(turmaService);
		relatorioAvaliacaoDocenteTurmaBean.setPessoaService(pessoaService);
		relatorioAvaliacaoDocenteTurmaBean.setAvaliacaoDocenteService(avaliacaoDocenteService);
		relatorioAvaliacaoDocenteTurmaBean.setArquivoDeModeloJasper("/home/sponja/workspace-rh/relatorio/web/resources/NFDosAlunosDeUmaTurma.jasper");
		relatorioAvaliacaoDocenteTurmaBean.setArquivoDaImagemDoCabecalho("/home/sponja/workspace-rh/relatorio/web/resources/cabecalho_relatorio.gif");
	
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

		avaliacao = new Avaliacao(turma.getId());
		avaliacao.setId(new Long(1));
		questao1 = new Questao(true,"Pergunta numero 1");
		questao2 = new Questao(true,"Pergunta numero 2");
		avaliacao.adicionarQuestao(questao1);
		avaliacao.adicionarQuestao(questao2);
		
		formAvaliacao1 = new FormAvaliacao(aluno1.getId(), avaliacao);
		formAvaliacao2 = new FormAvaliacao(aluno2.getId(), avaliacao);
		avaliacao.adicionarFormAvaliacao(formAvaliacao1);
		avaliacao.adicionarFormAvaliacao(formAvaliacao2);
		
		resposta11 = new Resposta(questao1,"true");
		resposta12 = new Resposta(questao2,"Resposta pergunta 1");
		resposta21 = new Resposta(questao1,"false");
		resposta22 = new Resposta(questao2,"Resposta pergunta 2");
		formAvaliacao1.adicionarResposta(resposta11);
		formAvaliacao1.adicionarResposta(resposta12);
		formAvaliacao2.adicionarResposta(resposta21);
		formAvaliacao2.adicionarResposta(resposta22);
		
		listaFormAvaliacao = new ArrayList<FormAvaliacao>();
		listaFormAvaliacao.add(formAvaliacao1);
		listaFormAvaliacao.add(formAvaliacao2);
		
		listaResposta1 = new ArrayList<Resposta>();
		listaResposta1.add(resposta11);
		listaResposta1.add(resposta12);
		
		listaResposta2 = new ArrayList<Resposta>();
		listaResposta2.add(resposta21);
		listaResposta2.add(resposta22);
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

					one(turmaService).consultar(new Long(100));
					will(throwException(new Exception()));

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
				}
			});
		} catch (EscolaException e) {
			fail("EscolaException não era esperado.");
		}

		contextoAvaliacaoDocenteService.checking(new Expectations() {
			{
				one(avaliacaoDocenteService).buscarAvaliacaoId(turma.getId());
				will(returnValue(avaliacao.getId()));

				one(avaliacaoDocenteService).buscarFormulariosAvaliacao(avaliacao.getId());
				will(returnValue(listaFormAvaliacao));
			}
		});

		try {
			JasperPrint jp = null;
			jp = relatorioAvaliacaoDocenteTurmaBean.gerarRelatorio(turma.getId());
			assertNotNull(jp);
		} catch (Exception e) {
			fail("Exceção não era esperada.");
		}
		
		/**
		 * Teste de retorno de excecão quando não existir a turma.
		 */
		try {
			JasperPrint jp = null;
			jp = relatorioAvaliacaoDocenteTurmaBean.gerarRelatorio(new Long(100));
			fail("Deveria retornar uma exceção");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

}
