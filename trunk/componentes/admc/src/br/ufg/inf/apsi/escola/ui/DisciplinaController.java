package br.ufg.inf.apsi.escola.ui;

import java.util.ArrayList;
import java.util.List;

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
	private Curso curso;

	public DisciplinaController() {
		localServiceFactory = new LocalServiceFactory();
		disciplinaService = localServiceFactory.obterDisciplinaService();
		cursoService = localServiceFactory.obterCursoService();

	}

	public String novo() {
		try {
			this.setCodigo(new String());
			this.setNome(new String());
			this.setEmenta(new String());
			this.setCargaHoraria(0);
			this.setCurso(new Curso());
			this.cursos = cursoService.consultar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "novo";
	}

	public String gravar() {

		try {
			Curso curso = cursoService.consultar(getCurso().getId());
			Disciplina disciplina = new Disciplina(getCodigo(), getNome(),
					getEmenta(), getCargaHoraria());
			curso.addDisciplina(disciplina);
			disciplinaService.gravar(disciplina);
			cursoService.gravar(curso);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	public DataModel consultar() throws Exception {

		model = new ListDataModel(disciplinaService.consultar());

		return model;
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

	public String getEmenta() {
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

	public SelectItem getCursoItem() {
		return new SelectItem(this.curso.getId(),this.curso.getNome());
	}

	public void setCursoItem(SelectItem curso) {
		try{
		setCurso(this.cursoService.consultar((Long)curso.getValue()));
		}catch(Exception e){
			
		}
	}
	
	public SelectItem[] getCursosItens(){
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

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
