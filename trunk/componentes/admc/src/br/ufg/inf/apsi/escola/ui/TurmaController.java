/**
 * 
 */
package br.ufg.inf.apsi.escola.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Docente;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Turma;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.TurmaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * @author Fernando Nery Barros
 * 
 */
public class TurmaController {

	private boolean situacao;

	private boolean preMatricula;

	private String codigoTurma;

	private long docenteId;

	private long disciplinaId;

	private TurmaService turmaService;

	private LocalServiceFactory localServiceFactory;

	private List<Docente> docentes;

	private List<Disciplina> disciplinas;

	private int qtdeNotas;

	private String expressao;

	private DataModel model;

	private long idTurma;

	public TurmaController() {
		localServiceFactory = new LocalServiceFactory();
		turmaService = localServiceFactory.obterTurmaService();
	}

	public int getQtdeNotas() {
		return qtdeNotas;
	}

	public void setQtdeNotas(int qtdeNotas) {
		this.qtdeNotas = qtdeNotas;
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

	public long getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(long docenteId) {
		this.docenteId = docenteId;
	}

	public long getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public boolean isPreMatricula() {
		return preMatricula;
	}

	public void setPreMatricula(boolean preMatricula) {
		this.preMatricula = preMatricula;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public SelectItem[] getDocentes() {
		DocenteService docenteService = localServiceFactory
				.obterDocenteService();

		List<SelectItem> items = new ArrayList<SelectItem>();
		SelectItem[] a = { new SelectItem(0, "") };
		try {
			this.docentes = docenteService.consultar();
			if (!this.docentes.isEmpty()) {

				for (Docente docente : docentes) {
					items.add(new SelectItem(docente.getId(), docente
							.getMatricula()));
				}
			} else {
				items.add(new SelectItem(0, ""));
			}
			return items.toArray(a);
		} catch (Exception e) {
			items.add(new SelectItem(0, ""));
			return items.toArray(a);
		}
	}

	public SelectItem[] getDisciplinas() {
		DisciplinaService disciplinaService = localServiceFactory
				.obterDisciplinaService();

		List<SelectItem> items = new ArrayList<SelectItem>();
		SelectItem[] a = { new SelectItem(0, "") };
		try {
			this.disciplinas = disciplinaService.consultar();
			if (!this.disciplinas.isEmpty()) {

				for (Disciplina disciplina : disciplinas) {
					items.add(new SelectItem(disciplina.getId(), disciplina
							.getNome()));
				}
			} else {
				items.add(new SelectItem(0, ""));
			}
			return items.toArray(a);
		} catch (Exception e) {
			items.add(new SelectItem(0, ""));
			return items.toArray(a);
		}
	}

	/**
	 * M�todo limpa a tela de cadastro de turma.
	 * 
	 * @return ""
	 */
	public String novo() {

		setSituacao(false);
		setCodigoTurma(null);
		setDisciplinaId(0);
		setDocenteId(0);
		setExpressao(null);
		setPreMatricula(false);
		setQtdeNotas(0);
		return "";
	}

	public String gravar() {
		try {
			DocenteService docenteService = localServiceFactory
					.obterDocenteService();
			DisciplinaService disciplinaService = localServiceFactory
					.obterDisciplinaService();

			Docente docente = docenteService.consultar(docenteId);

			Disciplina disciplina = disciplinaService.consultar(disciplinaId);

			Turma turma = new Turma(idTurma, codigoTurma, expressao, qtdeNotas,
					preMatricula, situacao, disciplina, docente);

			turmaService.gravar(turma);

			novo();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public DataModel getConsultar() {
		List<Turma> listaQuery = null;
		try {
			listaQuery = turmaService.consultar();

			model = new ListDataModel();

		} catch (Exception e) {
			model = new ListDataModel(listaQuery);
		}
		return model;
	}

	public String selecionaTurma() {
		idTurma = ((Turma) model.getRowData()).getId();
		setCodigoTurma(((Turma) model.getRowData()).getCodigoTurma());
		setSituacao(((Turma) model.getRowData()).getSituacao());
		setDisciplinaId(((Turma) model.getRowData()).getDisciplina().getId());
		setDocenteId(((Turma) model.getRowData()).getDocente().getId());
		setPreMatricula(((Turma) model.getRowData()).isPreMatricula());
		setQtdeNotas(((Turma) model.getRowData()).getQtdeNotas());
		setExpressao(((Turma) model.getRowData()).getExpressao());

		return "";
	}

	public String excluir() {
		idTurma = ((Turma) model.getRowData()).getId();

		try {
			turmaService.excluir(idTurma);
		} catch (Exception e) {

			e.printStackTrace();
			return "";
		}
		return "";
	}

}
