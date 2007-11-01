package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class ListarUsuarios {

	private ServiceFactory serviceFactory = new LocalServiceFactory();
	private UsuarioService usuarioService = serviceFactory
			.obtemUsuarioService();

	private String username;
	private List<String> usuariosCadastrados = new ArrayList<String>();
	private HtmlDataTable htmlDataTable = new HtmlDataTable();

	public ListarUsuarios() {

	}

	public String voltar() {
		
		return "voltar";
	}
	
	public void excluir(ActionEvent event) {

		username = (String)htmlDataTable.getRowData();
		
		try {
			usuarioService.removerUsuario(username);
			
			FacesMessage msgs = new FacesMessage("Usuário excluído com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		} catch (UsuarioException e) {
			FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		} 
	}

	public List<String> getUsuariosCadastrados() {
		try {
			usuariosCadastrados = usuarioService.listaTodosUsuarios();
		} catch (UsuarioException e) {
			usuariosCadastrados = null;
		}

		return usuariosCadastrados;
	}

	public void setUsuariosCadastrados(List<String> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}

	public void pageFirst() {
		getHtmlDataTable().setFirst(0);
	}

	public void pagePrevious() {
		getHtmlDataTable().setFirst(
				getHtmlDataTable().getFirst() - getHtmlDataTable().getRows());
	}

	public void pageNext() {
		getHtmlDataTable().setFirst(
				getHtmlDataTable().getFirst() + getHtmlDataTable().getRows());
	}

	public void pageLast() {
		int count = getHtmlDataTable().getRowCount();
		int rows = getHtmlDataTable().getRows();

		getHtmlDataTable().setFirst(
				count - ((count % rows != 0) ? count % rows : rows));
	}

	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}

	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}