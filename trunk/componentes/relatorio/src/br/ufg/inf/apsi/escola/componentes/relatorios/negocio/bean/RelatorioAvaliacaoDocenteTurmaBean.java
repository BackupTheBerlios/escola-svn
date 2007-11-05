package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.bean;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.FormAvaliacao;
import br.ufg.inf.apsi.escola.componentes.acd.modelo.Resposta;
import br.ufg.inf.apsi.escola.componentes.acd.servico.AvaliacaoDocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.RelatorioAvaliacaoDocenteTurma;
import br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource.FonteDeDados;

/**
 * Implenta a interface RelatorioAvaliacaoDocenteTurma e tem como fun��o gerar o
 * Relat�rio de avaliacao de um docente de uma determinada Turma. Para
 * tanto, faz consultas aos componentes pertinentes, organiza os dados, carrega
 * um objeto fonte de dados (FonteDeDados), preenche o modelo de
 * relatorio jasper com os dados da fonte de dados e retorna um objeto
 * jasperPrint pronto para ser exportado para PDF ou HTML.
 * 
 * @author Yoshiyuki
 * 
 */
public class RelatorioAvaliacaoDocenteTurmaBean implements
RelatorioAvaliacaoDocenteTurma {

	/**
	 * Refer�ncia para um objeto de servi�os do componente Administra��o de
	 * Cursos, relacionados a turmas.
	 */
	private TurmaService turmaService;

	/**
	 * Refer�ncia para um objeto de servi�os do componente Avalia��o do
	 * Docente.
	 */
	private AvaliacaoDocenteService avaliacaoDocenteService;

	/**
	 * Refer�ncia para um objeto de servi�os do componente Pessoas F�sica e
	 * Jur�dica.
	 */
	private PessoaService pessoaService;

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
	public RelatorioAvaliacaoDocenteTurmaBean() {
		turmaService = null;
		avaliacaoDocenteService = null;
		pessoaService = null;
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
	 * Recebe a inje��o de depend�ncia do servi�o do componente Avaliacao do Corpo Docente.
	 * 
	 * @param avaliacaoDocenteService Inst�ncia de AvaliacaoDocenteService.
	 */
	public void setAvaliacaoDocenteService(
			AvaliacaoDocenteService avaliacaoDocenteService) {
		this.avaliacaoDocenteService = avaliacaoDocenteService;
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
		Long avaliacaoId = null;
		String nomeDocente = null;
		List<FormAvaliacao> listaFormAvaliacao = null;

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
		turma = turmaService.consultar(idTurma);
		curso = turmaService.consultaCurso(idTurma);
		disciplina = turmaService.consultaDisciplina(idTurma);
		docente = turmaService.consultaDocente(idTurma);
		nomeDocente = pessoaService.consultaPessoaId(docente.getPessoaId());
		avaliacaoId = avaliacaoDocenteService.buscarAvaliacaoId(turma.getId());
		listaFormAvaliacao = avaliacaoDocenteService.buscarFormulariosAvaliacao(avaliacaoId);
		/*
		 * Declara��o de tipos do cabe�alho FormAvaliacao.
		 */
		FormAvaliacao formAvaliacao = null;
		String comparacao;
		List<Resposta> listaRespostas = null;
		HashMap<String, String> linha;
		/*
		 * Declara��o de objetos para formata��o de n�meros.
		 */
		DecimalFormat decimalFormatZeros = new DecimalFormat("00000000");

		/*
		 * La�o para gera��o dos dados do cabe�alho Aluno.
		 */
		for (int indice = 0; indice < listaFormAvaliacao.size(); indice++) {

			formAvaliacao = listaFormAvaliacao.get(indice);
			listaRespostas = formAvaliacao.getRespostas();

			comparacao = curso.getCodigo();
			comparacao = comparacao + "          " + turma.getCodigoTurma();
			comparacao = comparacao + "          " + decimalFormatZeros.format(indice);

			/*
			 * La�o para gera��o dos detalhes, i �, cada linha de dados do relat�rio.
			 */
			linha = new HashMap<String, String>();
			for (int indiceResposta = 0; indiceResposta < listaRespostas.size(); indiceResposta++) {
				linha = new HashMap<String, String>();
				linha.put("codigoTurma", turma.getCodigoTurma());
				linha.put("codigoCurso", curso.getCodigo());
				linha.put("nomeCurso", curso.getNome());
				linha.put("codigoDisciplina", disciplina.getCodigo());
				linha.put("nomeDisciplina", disciplina.getNome());
				linha.put("matriculaDocente", docente.getMatricula());
				linha.put("nomeDocente", nomeDocente);
				linha.put("numeroAvaliacao", "Avalia��o " + (indice + 1));
				linha.put("perguntaQuestao", (indiceResposta + 1) + ") " + listaRespostas.get(indiceResposta).getQuestao().getPergunta());
				linha.put("respostaQuestao", listaRespostas.get(indiceResposta).getResposta());

				linha.put("comparacao", comparacao + "           " + decimalFormatZeros.format(indiceResposta + 1));
				treeSet.add(linha);
			}
		}
		return new FonteDeDados(treeSet.iterator());
	}
}
