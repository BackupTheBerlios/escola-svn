package br.ufg.inf.apsi.escola.ui;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class CursoController {

	private long id = -1;

	private String codigo;

	private String nome;

	private Integer cargaHoraria;

	private CursoService cursoService;

	private LocalServiceFactory localServiceFactory;

	private DataModel model;

	public CursoController() {
		localServiceFactory = new LocalServiceFactory();
		cursoService = localServiceFactory.obterCursoService();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String novo() {
		setId(-1);
		setCodigo(new String());
		setNome(new String());
		setCargaHoraria(new Integer(0));
		return "novoCurso";
	}

	public String gravar() {
		Curso curso = null;

		if (getId() != -1) {
			curso = new Curso(getId(), getCodigo(), getNome(),
					getCargaHoraria());
		} else {
			curso = new Curso(getId(), getCodigo(), getNome(),
					getCargaHoraria());
		}

		try {
			cursoService.gravar(curso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		limpar();

		return "";
	}

	public String selecionaCurso() {
		setId(((Curso) model.getRowData()).getId());
		setNome(((Curso) model.getRowData()).getNome());
		setCodigo(((Curso) model.getRowData()).getCodigo());
		setCargaHoraria(((Curso) model.getRowData()).getCargaHoraria());

		return "";
	}

	public String excluir() {
		setId(((Curso) model.getRowData()).getId());

		try {
			cursoService.excluir(getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public DataModel getConsultar() {
		List<Curso> listaCursoQuery = null;
		try {
			listaCursoQuery = cursoService.consultar();
			model = new ListDataModel(listaCursoQuery);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	private void limpar() {
		setCodigo(null);
		setNome(null);
		setId(-1);
		setCargaHoraria(null);
	}

}
