package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Aluno;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.MatriculaTurma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.MatriculaTurmaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.componentes.expnf.servico.ExpressaoNotaFinalService;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Frequencia;
import br.ufg.inf.apsi.escola.componentes.nf.modelo.Nota;
import br.ufg.inf.apsi.escola.componentes.nf.servico.NotaFrequenciaService;
import br.ufg.inf.apsi.escola.componentes.pessoa.negocio.PessoaService;
import br.ufg.inf.apsi.escola.componentes.relatorios.modelo.TurmaNaoEncontradaException;

public class DadosNFDosAlunosDeUmaTurma implements JRDataSource {

	private Iterator<HashMap<String, String>> iterator;
	private HashMap<String, String> linha;
	private TreeSet<HashMap<String, String>> treeSet = new TreeSet<HashMap<String, String>>(
			new Comparator<HashMap<String, String>>() {
				public int compare(HashMap<String, String> linhaA,
						HashMap<String, String> linhaB) {
					String stringA = linhaA.get("comparacao");
					String stringB = linhaB.get("comparacao");
					return stringA.compareTo(stringB);
				}
			});
	private TurmaService turmaService;
	private MatriculaTurmaService matriculaTurmaService;
	private PessoaService pessoaService;
	private NotaFrequenciaService notaFrequenciaService;
	private ExpressaoNotaFinalService expressaoNotaFinalService;

	String codigoTurma;
	String codigoCurso;
	String nomeCurso;
	String codigoDisciplina;
	String nomeDisciplina;
	String matriculaDocente;
	String nomeDocente;
	String expnf;
	String matriculaAluno;
	String nomeAluno;
	String comparacao;

	public DadosNFDosAlunosDeUmaTurma(
			CursoService cursoService,
			TurmaService turmaService,
			MatriculaTurmaService matriculaTurmaService,
			PessoaService pessoaService,
			NotaFrequenciaService notaFrequenciaService,
			ExpressaoNotaFinalService expressaoNotaFinalService,
			String codigoTurma) throws TurmaNaoEncontradaException {
		this.turmaService = turmaService;
		this.matriculaTurmaService = matriculaTurmaService;
		this.notaFrequenciaService = notaFrequenciaService;
		this.expressaoNotaFinalService = expressaoNotaFinalService;

		carregaDados(codigoTurma);
		iterator = treeSet.iterator();
	}

	public Object getFieldValue(JRField jRF) throws JRException {
		return linha.get(jRF.getName());
	}

	public boolean next() throws JRException {
		if (iterator.hasNext()) {
			linha = iterator.next();
			return true;
		}
		return false;
	}

	private void carregaDados(String codigoTurmaArg) throws TurmaNaoEncontradaException {

		try {
			codigoTurma = turmaService.consultar(codigoTurmaArg).getCodigoTurma();
		} catch (Exception e) {
			throw new TurmaNaoEncontradaException();
		}
		
		codigoCurso = turmaService.consultaCurso(codigoTurma).getCodigo();
		nomeCurso = turmaService.consultaCurso(codigoTurma).getNome();
		codigoDisciplina = turmaService.consultaDisciplina(codigoTurma).getCodigo();
		nomeDisciplina = turmaService.consultaDisciplina(codigoTurma).getNome();
		matriculaDocente = turmaService.consultaDocente(codigoTurma).getMatricula();
		
		try {
			nomeDocente = pessoaService.consultaPessoaId((long) turmaService
					.consultaDocente(codigoTurma).getPessoaId());
		} catch (Exception e) {
			nomeDocente = "<<< Erro ao recuperar nome do Docente >>>";
		}
		
		try {
			expnf = turmaService.consultar(codigoTurma).getExpressao();
		} catch (Exception e) {
			expnf = "<<< Erro ao recuperar expressao >>>";
		}

		List<Aluno> listaAlunos = matriculaTurmaService.listaAlunos(codigoTurma);

		for (int item = 0; item < listaAlunos.size(); item++) {

			matriculaAluno = listaAlunos.get(item).getNumeroMatricula();
			try {
				nomeAluno = pessoaService.consultaPessoaId((long) listaAlunos.get(item).getPessoa());
			} catch (Exception e) {
				nomeAluno = "<<< Erro ao recuperar nome do Aluno >>>";
			}

			novaLinha();
			
			comparacao = codigoCurso;
			comparacao = comparacao + "          " + codigoTurma;
			comparacao = comparacao + "          " + matriculaAluno;
			comparacao = comparacao + "          " + nomeAluno;
			
			montaNotas();

		}

	}

	private void novaLinha() {
		linha = new HashMap<String, String>();
		linha.put("codigoTurma", codigoTurma);
		linha.put("codigoCurso", codigoCurso);
		linha.put("nomeCurso", nomeCurso);
		linha.put("codigoDisciplina", codigoDisciplina);
		linha.put("nomeDisciplina", nomeDisciplina);
		linha.put("matriculaDocente", matriculaDocente);
		linha.put("nomeDocente", nomeDocente);
		linha.put("expnf", expnf);
		linha.put("matriculaAluno", matriculaAluno);
		linha.put("nomeAluno", nomeAluno);
	}

	private void montaNotas() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		MatriculaTurma matriculaTurma = matriculaTurmaService.consultar(codigoTurma, matriculaAluno);

		List<Nota> listaNotas = notaFrequenciaService.obterNotasDoAluno(matriculaTurma);
		List<Frequencia> listaFrequencia = notaFrequenciaService.obterFrequenciasDoAluno(matriculaTurma);
		linha.put("nf", decimalFormat.format(expressaoNotaFinalService.calculaNotaFinal(listaNotas, expnf)));
		int presencas = 0;
		for (int item = 0; item < listaFrequencia.size(); item++) {
			if (listaFrequencia.get(item).isEstevePresente()) presencas++;
		}
		linha.put("fq", decimalFormat.format(100 * presencas / (listaFrequencia.size() + 1)));

		int item;
		for (int indice = 0; indice < listaNotas.size(); indice++) {
			if ((indice != 0) && ((indice % 7) == 0)) {
				linha.put("comparacao",comparacao + "          d" + indice);
				treeSet.add(linha);
				novaLinha();
			};
			item = indice + 1;
			linha.put("d" + item, "n" + item + "=");
			linha.put("n" + item, decimalFormat.format(listaNotas.get(indice).getValor()));
		}
		linha.put("comparacao",comparacao + "          d" + (listaNotas.size()+1));
		treeSet.add(linha);
		
	}
}
