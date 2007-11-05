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
 * Implenta a interface RelatorioAvaliacaoDocenteTurma e tem como função gerar o
 * Relatório de avaliacao de um docente de uma determinada Turma. Para
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
	 * Referência para um objeto de serviços do componente Administração de
	 * Cursos, relacionados a turmas.
	 */
	private TurmaService turmaService;

	/**
	 * Referência para um objeto de serviços do componente Avaliação do
	 * Docente.
	 */
	private AvaliacaoDocenteService avaliacaoDocenteService;

	/**
	 * Referência para um objeto de serviços do componente Pessoas Física e
	 * Jurídica.
	 */
	private PessoaService pessoaService;

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
	public RelatorioAvaliacaoDocenteTurmaBean() {
		turmaService = null;
		avaliacaoDocenteService = null;
		pessoaService = null;
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
	 * Recebe a injeção de dependência do serviço do componente Avaliacao do Corpo Docente.
	 * 
	 * @param avaliacaoDocenteService Instância de AvaliacaoDocenteService.
	 */
	public void setAvaliacaoDocenteService(
			AvaliacaoDocenteService avaliacaoDocenteService) {
		this.avaliacaoDocenteService = avaliacaoDocenteService;
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
		 * Busca e carga de informações do cabeçalho do relatório.
		 */
		turma = turmaService.consultar(idTurma);
		curso = turmaService.consultaCurso(idTurma);
		disciplina = turmaService.consultaDisciplina(idTurma);
		docente = turmaService.consultaDocente(idTurma);
		nomeDocente = pessoaService.consultaPessoaId(docente.getPessoaId());
		avaliacaoId = avaliacaoDocenteService.buscarAvaliacaoId(turma.getId());
		listaFormAvaliacao = avaliacaoDocenteService.buscarFormulariosAvaliacao(avaliacaoId);
		/*
		 * Declaração de tipos do cabeçalho FormAvaliacao.
		 */
		FormAvaliacao formAvaliacao = null;
		String comparacao;
		List<Resposta> listaRespostas = null;
		HashMap<String, String> linha;
		/*
		 * Declaração de objetos para formatação de números.
		 */
		DecimalFormat decimalFormatZeros = new DecimalFormat("00000000");

		/*
		 * Laço para geração dos dados do cabeçalho Aluno.
		 */
		for (int indice = 0; indice < listaFormAvaliacao.size(); indice++) {

			formAvaliacao = listaFormAvaliacao.get(indice);
			listaRespostas = formAvaliacao.getRespostas();

			comparacao = curso.getCodigo();
			comparacao = comparacao + "          " + turma.getCodigoTurma();
			comparacao = comparacao + "          " + decimalFormatZeros.format(indice);

			/*
			 * Laço para geração dos detalhes, i é, cada linha de dados do relatório.
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
				linha.put("numeroAvaliacao", "Avaliação " + (indice + 1));
				linha.put("perguntaQuestao", (indiceResposta + 1) + ") " + listaRespostas.get(indiceResposta).getQuestao().getPergunta());
				linha.put("respostaQuestao", listaRespostas.get(indiceResposta).getResposta());

				linha.put("comparacao", comparacao + "           " + decimalFormatZeros.format(indiceResposta + 1));
				treeSet.add(linha);
			}
		}
		return new FonteDeDados(treeSet.iterator());
	}
}
