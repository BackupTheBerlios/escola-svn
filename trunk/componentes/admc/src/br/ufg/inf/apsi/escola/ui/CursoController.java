package br.ufg.inf.apsi.escola.ui;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class CursoController {

	private CursoService cursoService = null;
	private LocalServiceFactory localServiceFactory = null;
	private Curso curso = null;
	private DataModel model;
	private String mensagem = "";

	public CursoController() {
		localServiceFactory = new LocalServiceFactory();
		cursoService = localServiceFactory.obterCursoService();
		this.curso = new Curso();
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return this.curso;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String novo() {
		this.setCurso(new Curso());
		mensagem = "";
		return "novo";
	}

	public String gravar() {
		try {
			cursoService.gravar(this.curso);
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = "Erro ao Gravar Curso " + curso.getCodigo();
			return "retornoGravar";
		}
		this.setCurso(new Curso());
		mensagem = "";
		return "retornoGravar";
	}

	public String alterar() {
		this.setCurso((Curso) model.getRowData());
		mensagem = "";
		return "alterar";
	}

	public String excluir() {
		Curso cursoAExcluir = (Curso) model.getRowData();
		try {
			cursoService.excluir(cursoAExcluir.getId());
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = "Erro ao Excluir Curso " + cursoAExcluir.getCodigo();
			return "retornoExcluir";
		}
		this.setCurso(new Curso());
		mensagem = "";
		return "retornoExcluir";
	}

	public DataModel consultar() throws Exception {
		model = new ListDataModel(cursoService.consultar());
		return model;
	}

}
