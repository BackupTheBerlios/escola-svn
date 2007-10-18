package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
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
	private Long idPessoa;
	private String username;
	private boolean disponibilidade;
	private GregorianCalendar validade;
	private String numeroDocumento;
	private String nomePessoa;
	private Map<Long, String> pessoa = new HashMap<Long, String>();

	private UsuarioService usuarioService = null;
	private PessoaService pessoaService = null;
	private LocalServiceFactory localServiceFactory = null;

	/**
	 * <p>
	 * Construct a new Page bean instance.
	 * </p>
	 */
	public CadastrarUsuario() {
		localServiceFactory = new LocalServiceFactory();
		usuarioService = localServiceFactory.obtemUsuarioService();
		pessoaService = localServiceFactory.obtemPessoaService();
	}

	public String voltar() {

		return "voltar";
	}
	
	public String procurar(){
		return "";
	}

	public void gravar(ActionEvent event) {

		try {
			usuarioService.cadastrarUsuario(getIdPessoa(), getUsername(),
					getDisponibilidade(), getValidade());
			FacesMessage msgs = new FacesMessage("Usuário inserido com sucesso!");
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
		Long id = null;
		
		if (pessoa.size() != 0) {
			chaves = pessoa.keySet();
		}
		
		it = chaves.iterator();
		while(it.hasNext()){
			id = it.next();
		}
		return id;
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
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
}
