package br.ufg.inf.apsi.escola.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import br.ufg.inf.apsi.escola.componentes.admc.modelo.Curso;
import br.ufg.inf.apsi.escola.componentes.admc.modelo.Disciplina;
import br.ufg.inf.apsi.escola.componentes.admc.servico.CursoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DisciplinaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class DisciplinaController {

	private CursoService cursoService = null;
	private List<Curso> cursos = null;
	private DisciplinaService disciplinaService = null;
	private LocalServiceFactory localServiceFactory = null;
	private DataModel model;
	private String codigo;
	private String nome;
	private String ementa;
	private int cargaHoraria;
	private long curso;
	private long id;
	

	

	public DisciplinaController() {
		localServiceFactory = new LocalServiceFactory();
		disciplinaService = localServiceFactory.obterDisciplinaService();
		cursoService = localServiceFactory.obterCursoService();

	}

	public String novo() {
		try {
			this.setId(-1);
			this.setCodigo(new String());
			this.setNome(new String());
			this.setEmenta(new String());
			this.setCargaHoraria(0);
			this.setCurso(0L);
			this.cursos = cursoService.consultar();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "novoDisciplina";
	}

	public String gravar() {
		
		Disciplina disciplina=null;
		
		try {
			Curso curso =cursoService.consultar(getCurso());
			
			if (getId() != -1) {
				disciplina = new Disciplina(getId(),getNome(),getCodigo(),
						getEmenta(), getCargaHoraria(),curso);
				
			} else {
				disciplina = new Disciplina(getNome(),getCodigo(),
						getEmenta(), getCargaHoraria(),curso);
			}
			disciplinaService.gravar(disciplina);
		
		} catch (Exception e) {
			e.printStackTrace();

		}

		limpar();
		
		return null;
	}

	
	public String editar(){
		Disciplina disciplina= getDisciplinaFromEditOrDelete();
		try{
		this.setId(disciplina.getId());
		this.setCodigo(disciplina.getCodigo());
		this.setNome(disciplina.getNome());
		this.setEmenta(disciplina.getEmenta());
		this.setCargaHoraria(disciplina.getCargaHoraria());
		this.setCurso(disciplina.getCurso().getId());
		this.cursos = cursoService.consultar();
		return "editarDisciplina";
		}catch(Exception e){
			return null;
		}
		
	}
	
	public DataModel getTodos() throws Exception {
		
		
		try{
			model = new ListDataModel(disciplinaService.consultar());
			
		}catch(Exception e){
			
		}
		
		return model;
	}

	public void limpar(){
		this.setCodigo(null);
		this.setCargaHoraria(0);
		this.setCurso(0);
		this.setEmenta(null);
		this.setNome(null);
		this.setId(-1);
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

	public String getEmenta(){
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public SelectItem[] getCursos(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		SelectItem[] a={new SelectItem(0,"")};
		try{
			this.cursos = cursoService.consultar();
			if(!this.cursos.isEmpty()){
		
			for (Curso curso : cursos) {
			   items.add(new SelectItem(curso.getId(),curso.getNome()));	
			}
			}else{
				items.add(new SelectItem(0,""));
			}
			return items.toArray(a);
		}catch(Exception e){
			items.add(new SelectItem(0,""));
			return items.toArray(a);
		}
	}
	
	public void setCursos(List<Curso> cursos){
			
		this.cursos = cursos;
		
	}

	public Disciplina getDisciplinaFromEditOrDelete(){
		Disciplina disciplina = (Disciplina) model.getRowData();
		return disciplina;
	}
	
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public long getCurso() {
		return curso;
	}

	public void setCurso(long curso) {
		this.curso = curso;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
