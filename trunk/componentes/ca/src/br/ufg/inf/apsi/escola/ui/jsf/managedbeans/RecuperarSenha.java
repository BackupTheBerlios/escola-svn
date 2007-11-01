package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.servicos.ServiceFactory;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

public class RecuperarSenha {

	private String usuario = null;
	private ServiceFactory serviceFactory = new LocalServiceFactory();
	private UsuarioService usuarioService = serviceFactory
			.obtemUsuarioService();

	public RecuperarSenha() {}

	public String recuperar() {
		String retorno = "falha";

			try {
				usuarioService.recuperarSenha(getUsuario());
				FacesMessage msgs = new FacesMessage("A senha foi enviada para seu e-mail!");
				FacesContext.getCurrentInstance().addMessage(null, msgs);
			} catch (UsuarioException e) {
				FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, msgs);
			}

			retorno = "sucesso";

		return retorno;
	}

	public String recuperarSenha() {
		return "recuperarSenha";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
