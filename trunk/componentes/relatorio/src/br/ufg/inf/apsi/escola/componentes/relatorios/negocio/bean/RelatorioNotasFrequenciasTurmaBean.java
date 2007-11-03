package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioNotasFrequenciasTurma;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource.FonteDeDados;

/**
 * Implenta a interface RelatorioNFDeAlunosPorTurma e tem como função gerar o
 * Relatório de Notas e Freqüências dos Alunos de uma determinada Turma. Para
 * tanto, faz consultas aos componentes pertinentes, organiza os dados, carrega
 * um objeto fonte de dados (FonteDeDados), preenche o modelo de
 * relatorio jasper com os dados da fonte de dados e retorna um objeto
 * jasperPrint pronto para ser exportado para PDF ou HTML.
 * 
 * @author Yoshiyuki
 * 
 */
public class RelatorioNotasFrequenciasTurmaBean implements
		RelatorioNotasFrequenciasTurma {

	/**
	 * Referência para um objeto de serviços do componente Administração de
	 * Cursos, relacionados a turmas.
	 */
	private TurmaService turmaService;

	/**
	 * Referência para um objeto de serviços do componente Administração de
	 * Cursos, relacionados a matricula de aluno em turmas.
	 */
	private MatriculaTurmaService matriculaTurmaService;

	/**
	 * Referência para um objeto de serviços do componente Pessoas Física e
	 * Jurídica.
	 */
	private PessoaService pessoaService;

	/**
	 * Referência para um objeto de serviços do componente Notas e Freqüências.
	 */
	private NotaFrequenciaService notaFrequenciaService;

	/**
	 * Referência para um objeto do serviço Expressão de Nota Final.
	 */
	private ExpressaoNotaService expressaoNotaService;
	/**
	 * Atributo String que conterá o nome do arquivo jasper (modelo do
	 * relatório) a ser utilizado como modelo do relatório.
	 */
	private String arquivoDeModeloJasper;

	/**
	 * Atributo String que conterá o nome do arquivo de imagem a ser utilizado
	 * no cabeçalho do relatório.
	 */
	private String arquivoDaImagemDoCabecalho;

	/**
	 * Cria uma instância de RelatorioNFDeAlunosPorTurmaBean e inicializa dos os
	 * atributo com null.
	 */
	public RelatorioNotasFrequenciasTurmaBean() {
		turmaService = null;
		matriculaTurmaService = null;
		pessoaService = null;
		notaFrequenciaService = null;
		expressaoNotaService = null;
		arquivoDeModeloJasper = null;
		arquivoDaImagemDoCabecalho = null;
	}

	/**
	 * Recebe a injeção de dependência do serviço, do componente Administração
	 * de Curso, relacionado a turma.
	 * 
	 * @param turmaService Instância de TurmaService.
	 */
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	/**
	 * Recebe a injeção de dependência do serviço, do componente Administração
	 * de Curso, relacionado a matricula de aluno em turma.
	 * 
	 * @param matriculaTurmaService Instância de MatriculaTurmaService.
	 */
	public void setMatriculaTurmaService(
			MatriculaTurmaService matriculaTurmaService) {
		this.matriculaTurmaService = matriculaTurmaService;
	}

	/**
	 * Recebe a injeção de dependência do serviço do componente Notas e
	 * Freqüências.
	 * 
	 * @param notaFrequenciaService Instância de NotaFrequenciaService.
	 */
	public void setNotaFrequenciaService(
			NotaFrequenciaService notaFrequenciaService) {
		this.notaFrequenciaService = notaFrequenciaService;
	}

	/**
	 * Recebe a injeção de dependência do serviço do componente Pessoas Física e
	 * Jurídica.
	 * 
	 * @param pessoaService Instância de PessoaService.
	 */
	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	/**
	 * Recebe a injeção de dependência do serviço Expressão de Nota Final.
	 * 
	 * @param expressaoNotaService Instância de expressaoNotaService.
	 */
	public void setExpressaoNotaService(
			ExpressaoNotaService expressaoNotaService) {
		this.expressaoNotaService = expressaoNotaService;
	}

	/**
	 * Recebe a injeção da String que conterá o nome do arquivo jasper (modelo
	 * do relatório) a ser utilizado como modelo do relatório.
	 * 
	 * @param arquivoDeModeloJasper String contendo do arquivo.
	 */
	public void setArquivoDeModeloJasper(String arquivoDeModeloJasper) {
		this.arquivoDeModeloJasper = arquivoDeModeloJasper;
	}

	/**
	 * Recebe a injeção da String que conterá o nome do arquivo de imagem a ser
	 * utilizado no cabeçalho do relatório.
	 * 
	 * @param arquivoDaImagemDoCabecalho String contendo do arquivo. 
	 */
	public void setArquivoDaImagemDoCabecalho(String arquivoDaImagemDoCabecalho) {
		this.arquivoDaImagemDoCabecalho = arquivoDaImagemDoCabecalho;
	}

	/**
	 * Gera o relatório.
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JasperPrint Instancia de relatório JasperReports.
	 * @throws Exception
	 */
	public JasperPrint gerarRelatorio(Long idTurma) throws Exception {
		JRDataSource dataSource = carregarDataSource(idTurma);
		HashMap<Object, Object> parameters = new HashMap<Object, Object>();
		parameters.put("imagemDoCabecalho", arquivoDaImagemDoCabecalho);
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				arquivoDeModeloJasper, parameters, dataSource);
		return jasperPrint;
	}

	/**
	 * Processa os dados para o relatório buscando os nos componentes e gera a fonte de dados. 
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JRDataSource Fonte de dados a ser utilizado no preenchimento do relatório.
	 * @throws Exception
	 */
	private JRDataSource carregarDataSource(Long idTurma) throws Exception {
		/*
		 * Declaração de tipos do cabeçalho do relatório.
		 */
		Turma turma = null;
		Curso curso = null;
		Disciplina disciplina = null;
		Docente docente = null;
		String nomeDocente = null;
		String expnf = null;
		List<Aluno> listaAlunos = null;

		TreeSet<HashMap<String, String>> treeSet = new TreeSet<HashMap<String, String>>(
				new Comparator<HashMap<String, String>>() {
					public int compare(HashMap<String, String> linhaA,
							HashMap<String, String> linhaB) {
						String stringA = linhaA.get("comparacao");
						String stringB = linhaB.get("comparacao");
						return stringA.compareTo(stringB);
					}
				});

		/*
		 * Busca e carga de informações do cabeçalho do relatório.
		 */
		try {
			turma = turmaService.consultar(idTurma);
			curso = turmaService.consultaCurso(idTurma);
			disciplina = turmaService.consultaDisciplina(idTurma);
			docente = turmaService.consultaDocente(idTurma);
			nomeDocente = pessoaService.consultaPessoaId(docente.getPessoaId());
			expnf = turma.getExpressao();
			listaAlunos = matriculaTurmaService.listaAlunos(idTurma);
		} catch (Exception e) {
			throw e;
		}
		/*
		 * Declaração de tipos do cabeçalho Aluno.
		 */
		Aluno aluno = null;
		String nomeAluno;
		String comparacao;
		String nf;
		String fq;
		MatriculaTurma matriculaTurma;
		List<Frequencia> listaFrequencia;
		List<Nota> listaNotas;
		HashMap<String, String> linha;
		/*
		 * Declaração de objetos para formatação de números.
		 */
		DecimalFormat decimalFormatDecimal = new DecimalFormat("0.00");
		DecimalFormat decimalFormatZeros = new DecimalFormat("0000");

		/*
		 * Laço para geração dos dados do cabeçalho Aluno.
		 */
		for (int indiceAluno = 0; indiceAluno < listaAlunos.size(); indiceAluno++) {

			aluno = listaAlunos.get(indiceAluno);

			try {
				nomeAluno = pessoaService.consultaPessoaId(aluno.getPessoa());
			} catch (Exception e) {
				nomeAluno = "<<< Erro ao recuperar nome do Aluno >>>";
			}

			comparacao = curso.getCodigo();
			comparacao = comparacao + "          " + turma.getCodigoTurma();
			comparacao = comparacao + "          " + aluno.getNumeroMatricula();
			comparacao = comparacao + "          " + nomeAluno;

			matriculaTurma = matriculaTurmaService.consultar(turma.getId(), aluno.getNumeroMatricula());

			listaFrequencia = notaFrequenciaService
					.obterFrequenciasDoAluno(matriculaTurma);
			int presencas = 0;
			for (int item = 0; item < listaFrequencia.size(); item++) {
				if (listaFrequencia.get(item).isEstevePresente())
					presencas++;
			}
			fq = decimalFormatDecimal.format(100 * presencas
					/ (listaFrequencia.size() + 1));

			listaNotas = notaFrequenciaService
					.obterNotasDoAluno(matriculaTurma);
			nf = decimalFormatDecimal.format(expressaoNotaService
					.calculaNotaFinal(listaNotas, expnf));

			/*
			 * Laço para geração dos detalhes, i é, cada linha de dados do relatório.
			 */
			int item = 0;
			linha = new HashMap<String, String>();
			for (int indiceNota = 0; indiceNota < listaNotas.size(); indiceNota++) {
				if ((indiceNota % 7) == 0) {
					if (indiceNota != 0) {
						linha.put("comparacao", comparacao + "          n"
								+ decimalFormatZeros.format(indiceNota + 1));
						treeSet.add(linha);
					}
					linha = new HashMap<String, String>();
					linha.put("codigoTurma", turma.getCodigoTurma());
					linha.put("codigoCurso", curso.getCodigo());
					linha.put("nomeCurso", curso.getNome());
					linha.put("codigoDisciplina", disciplina.getCodigo());
					linha.put("nomeDisciplina", disciplina.getNome());
					linha.put("matriculaDocente", docente.getMatricula());
					linha.put("nomeDocente", nomeDocente);
					linha.put("expnf", expnf);
					linha.put("matriculaAluno", aluno.getNumeroMatricula());
					linha.put("nomeAluno", nomeAluno);
					linha.put("fq", fq);
					linha.put("nf", nf);
					item = 0;
				}
				;
				item++;
				linha.put("d" + item, "n" + (indiceNota + 1) + "=");
				linha.put("n" + item, decimalFormatDecimal.format(listaNotas.get(
						indiceNota).getValor()));
			}
			linha.put("comparacao", comparacao + "          n"
					+ decimalFormatZeros.format(listaNotas.size() + 1));
			treeSet.add(linha);
		}
		return new FonteDeDados(treeSet.iterator());
	}
}
