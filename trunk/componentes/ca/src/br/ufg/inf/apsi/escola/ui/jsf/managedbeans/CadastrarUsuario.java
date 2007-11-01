package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;

/**
 * 
 * @author leandro
 * 
 */
public class CadastrarUsuario {
	private Long idPessoa = null;
	private String username = null;
	private boolean disponibilidade = false;
	private GregorianCalendar validade = null;
	private String numeroDocumento = null;
	private String nomePessoa = null;
	private Map<Long, String> pessoa = new HashMap<Long, String>();

	private UsuarioService usuarioService = null;
	private PessoaService pessoaService = null;
	private LocalServiceFactory localServiceFactory = null;

	public CadastrarUsuario() {
		localServiceFactory = new LocalServiceFactory();
		usuarioService = localServiceFactory.obtemUsuarioService();
		pessoaService = localServiceFactory.obtemPessoaService();
	}

	public String voltar(HttpServletRequest request) {
		
		 request.getSession(false).setAttribute(nomePessoa, null);
		 //request.getSession(false).invalidate();

		return "voltar";
	}

	public void gravar(ActionEvent event) {

		try {
			usuarioService.cadastrarUsuario(getIdPessoa(), username,
					disponibilidade, validade);
			FacesMessage msgs = new FacesMessage(
					"Usuário inserido com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		} catch (UsuarioException e) {
			FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, e
					.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		}
	}

	public void consultarPessoa(ActionEvent event) {
		try {
			pessoa = pessoaService.consultaPessoaPorDocumento(numeroDocumento);
		} catch (EscolaException e) {
			FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, e
					.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msgs);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdPessoa() {
		Set<Long> chaves = null;
		Iterator<Long> it;

		if (pessoa.size() != 0) {
			chaves = pessoa.keySet();
			it = chaves.iterator();
			while (it.hasNext()) {
				idPessoa = it.next();
			}
		}

		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public GregorianCalendar getValidade() {
		return validade;
	}

	public void setValidade(GregorianCalendar validade) {
		this.validade = validade;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNomePessoa() {
	//	if (getIdPessoa() != null)
			nomePessoa = pessoa.get(getIdPessoa());
		//else
			//nomePessoa = " ";

		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Map<Long, String> getPessoa() {
		return pessoa;
	}

	public void setPessoa(Map<Long, String> pessoa) {
		this.pessoa = pessoa;
	}
}
