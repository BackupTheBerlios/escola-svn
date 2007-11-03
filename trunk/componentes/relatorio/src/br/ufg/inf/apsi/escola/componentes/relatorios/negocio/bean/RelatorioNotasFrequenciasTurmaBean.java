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
 * Implenta a interface RelatorioNFDeAlunosPorTurma e tem como fun��o gerar o
 * Relat�rio de Notas e Freq��ncias dos Alunos de uma determinada Turma. Para
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
	 * Refer�ncia para um objeto de servi�os do componente Administra��o de
	 * Cursos, relacionados a turmas.
	 */
	private TurmaService turmaService;

	/**
	 * Refer�ncia para um objeto de servi�os do componente Administra��o de
	 * Cursos, relacionados a matricula de aluno em turmas.
	 */
	private MatriculaTurmaService matriculaTurmaService;

	/**
	 * Refer�ncia para um objeto de servi�os do componente Pessoas F�sica e
	 * Jur�dica.
	 */
	private PessoaService pessoaService;

	/**
	 * Refer�ncia para um objeto de servi�os do componente Notas e Freq��ncias.
	 */
	private NotaFrequenciaService notaFrequenciaService;

	/**
	 * Refer�ncia para um objeto do servi�o Express�o de Nota Final.
	 */
	private ExpressaoNotaService expressaoNotaService;
	/**
	 * Atributo String que conter� o nome do arquivo jasper (modelo do
	 * relat�rio) a ser utilizado como modelo do relat�rio.
	 */
	private String arquivoDeModeloJasper;

	/**
	 * Atributo String que conter� o nome do arquivo de imagem a ser utilizado
	 * no cabe�alho do relat�rio.
	 */
	private String arquivoDaImagemDoCabecalho;

	/**
	 * Cria uma inst�ncia de RelatorioNFDeAlunosPorTurmaBean e inicializa dos os
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
	 * Recebe a inje��o de depend�ncia do servi�o, do componente Administra��o
	 * de Curso, relacionado a turma.
	 * 
	 * @param turmaService Inst�ncia de TurmaService.
	 */
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	/**
	 * Recebe a inje��o de depend�ncia do servi�o, do componente Administra��o
	 * de Curso, relacionado a matricula de aluno em turma.
	 * 
	 * @param matriculaTurmaService Inst�ncia de MatriculaTurmaService.
	 */
	public void setMatriculaTurmaService(
			MatriculaTurmaService matriculaTurmaService) {
		this.matriculaTurmaService = matriculaTurmaService;
	}

	/**
	 * Recebe a inje��o de depend�ncia do servi�o do componente Notas e
	 * Freq��ncias.
	 * 
	 * @param notaFrequenciaService Inst�ncia de NotaFrequenciaService.
	 */
	public void setNotaFrequenciaService(
			NotaFrequenciaService notaFrequenciaService) {
		this.notaFrequenciaService = notaFrequenciaService;
	}

	/**
	 * Recebe a inje��o de depend�ncia do servi�o do componente Pessoas F�sica e
	 * Jur�dica.
	 * 
	 * @param pessoaService Inst�ncia de PessoaService.
	 */
	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	/**
	 * Recebe a inje��o de depend�ncia do servi�o Express�o de Nota Final.
	 * 
	 * @param expressaoNotaService Inst�ncia de expressaoNotaService.
	 */
	public void setExpressaoNotaService(
			ExpressaoNotaService expressaoNotaService) {
		this.expressaoNotaService = expressaoNotaService;
	}

	/**
	 * Recebe a inje��o da String que conter� o nome do arquivo jasper (modelo
	 * do relat�rio) a ser utilizado como modelo do relat�rio.
	 * 
	 * @param arquivoDeModeloJasper String contendo do arquivo.
	 */
	public void setArquivoDeModeloJasper(String arquivoDeModeloJasper) {
		this.arquivoDeModeloJasper = arquivoDeModeloJasper;
	}

	/**
	 * Recebe a inje��o da String que conter� o nome do arquivo de imagem a ser
	 * utilizado no cabe�alho do relat�rio.
	 * 
	 * @param arquivoDaImagemDoCabecalho String contendo do arquivo. 
	 */
	public void setArquivoDaImagemDoCabecalho(String arquivoDaImagemDoCabecalho) {
		this.arquivoDaImagemDoCabecalho = arquivoDaImagemDoCabecalho;
	}

	/**
	 * Gera o relat�rio.
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JasperPrint Instancia de relat�rio JasperReports.
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
	 * Processa os dados para o relat�rio buscando os nos componentes e gera a fonte de dados. 
	 * 
	 * @param idTurma Long com o id da turma.
	 * @return JRDataSource Fonte de dados a ser utilizado no preenchimento do relat�rio.
	 * @throws Exception
	 */
	private JRDataSource carregarDataSource(Long idTurma) throws Exception {
		/*
		 * Declara��o de tipos do cabe�alho do relat�rio.
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
		 * Busca e carga de informa��es do cabe�alho do relat�rio.
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
		 * Declara��o de tipos do cabe�alho Aluno.
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
		 * Declara��o de objetos para formata��o de n�meros.
		 */
		DecimalFormat decimalFormatDecimal = new DecimalFormat("0.00");
		DecimalFormat decimalFormatZeros = new DecimalFormat("0000");

		/*
		 * La�o para gera��o dos dados do cabe�alho Aluno.
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
			 * La�o para gera��o dos detalhes, i �, cada linha de dados do relat�rio.
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
