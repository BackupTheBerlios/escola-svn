package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.acegisecurity.context.SecurityContextHolder;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class AlterarSenha {

	private String username = null;
	private String usuarioLogado = null;
	private String senhaAtual = null;
	private String senhaNova = null;
	private ServiceFactory serviceFactory = new LocalServiceFactory();
	private UsuarioService usuarioService = serviceFactory
			.obtemUsuarioService();

	public AlterarSenha() {
	}

	public void alterarSenhaAction(ActionEvent event) {
		username = obterUsuarioLogado();

		try {
			usuarioService.alterarSenha(username, senhaAtual, senhaNova);
			FacesMessage msgs = new FacesMessage("Senha alterada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		} catch (UsuarioException e) {
			FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		} 
	}
	
	public String voltar() {
		return "voltar";
	}

	public String alterarSenha() {
		return "alterarSenha";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
	
	public String obterUsuarioLogado(){
		
		return usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public String getUsuarioLogado() {
		return obterUsuarioLogado();
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
