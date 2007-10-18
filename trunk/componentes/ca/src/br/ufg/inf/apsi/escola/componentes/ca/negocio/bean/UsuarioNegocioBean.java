package br.ufg.inf.apsi.escola.componentes.ca.negocio.bean;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.ca.modelo.NenhumUsuarioEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.Usuario;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioNaoEncontradoException;
import br.ufg.inf.apsi.escola.componentes.ca.negocio.UsuarioNegocio;
import br.ufg.inf.apsi.escola.componentes.ca.repositorio.UsuarioRepositorio;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;
import br.ufg.inf.apsi.escola.ie.email.EmailService;

class UsuarioNegocioBean implements UsuarioNegocio {

	private UsuarioRepositorio usuarioRepositorio = null;
	private Usuario usuario = null;
	PessoaService pessoaService = null;
	EmailService emailservice = null;

	public UsuarioNegocioBean(UsuarioRepositorio usuarioRepositorio,
			PessoaService pessoaService, EmailService emailService) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.pessoaService = pessoaService;
		this.emailservice = emailService;
	}

	public void cadastrarUsuario(long idPessoa, String username,
			boolean disponibilidade, GregorianCalendar validade)
			throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
			throw new UsuarioException("Username já cadastrado!");
		} catch (UsuarioNaoEncontradoException e) {
			usuario = new Usuario();
			usuario.setIdPessoa(idPessoa);
			usuario.setUsername(username);
			usuario.setDisponibilidade(disponibilidade);
			usuario.setValidade(validade);
			usuario.setSenha(gerarSenha());
			usuarioRepositorio.incluirUsuario(usuario);
			enviarEmailSenha(usuario);
		}
	}

	public void alterarUsuario(Usuario usuario) throws UsuarioException {
		if (usuario != null)
			usuarioRepositorio.updateUsuario(usuario);
		else
			throw new UsuarioException("Usuario invalido");
	}

	public void removerUsuario(String username) throws UsuarioException {

		try {
			usuarioRepositorio.excluirUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
	}

	public List<String> listaTodosUsuarios() throws UsuarioException {

		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		List<String> listaUsernames = new ArrayList<String>();

		try {
			listaDeUsuarios = usuarioRepositorio.buscarTodosUsuarios();
		} catch (NenhumUsuarioEncontradoException nuee) {
			throw new UsuarioException(nuee.getMessage());
		}

		for (Object o : listaDeUsuarios) {
			Usuario u = (Usuario) o;
			listaUsernames.add(u.getUsername());
		}

		return listaUsernames;
	}

	public Object[] consultaUsuario(String username) throws UsuarioException {

		String dataFormatada;
		Date data;
		DateFormat formata;
		String nomePessoa;
		Object[] vetorDados = new Object[6];

		try {

			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		data = usuario.getValidade().getTime();
		formata = DateFormat.getDateInstance();
		dataFormatada = formata.format(data);

		try {
			nomePessoa = pessoaService.consultaPessoaId(usuario.getIdPessoa());
		} catch (EscolaException ee) {
			throw new UsuarioException(ee.getMessage());
		}

		vetorDados[0] = usuario.getUid();
		vetorDados[1] = usuario.getUsername();
		vetorDados[2] = usuario.getSenha();
		vetorDados[3] = usuario.getDisponibilidade();
		vetorDados[4] = nomePessoa;
		vetorDados[5] = dataFormatada;

		return vetorDados;
	}

	public Usuario obterUsuario(String username) throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		return usuario;
	}

	public List<String> listaUsuariosDisponibilidade(boolean disponibilidade)
			throws UsuarioException {

		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		List<String> listaUsernames = new ArrayList<String>();

		try {
			listaDeUsuarios = usuarioRepositorio
					.buscarUsuariosPelaDisponibilidade(disponibilidade);
		} catch (NenhumUsuarioEncontradoException nuee) {
			throw new UsuarioException(nuee.getMessage());
		}

		for (Object o : listaDeUsuarios) {
			Usuario u = (Usuario) o;
			listaUsernames.add(u.getUsername());
		}

		return listaUsernames;
	}

	public List<String> listaUsuariosValidade(Calendar dataValidade)
			throws UsuarioException {

		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		List<String> listaUsernames = new ArrayList<String>();

		try {
			listaDeUsuarios = usuarioRepositorio
					.buscarUsuariosPelaValidade(dataValidade);
		} catch (NenhumUsuarioEncontradoException nuee) {
			throw new UsuarioException(nuee.getMessage());
		}

		for (Object o : listaDeUsuarios) {
			Usuario u = (Usuario) o;
			listaUsernames.add(u.getUsername());
		}

		return listaUsernames;
	}

	public void recuperarSenha(String username) throws UsuarioException {
		Usuario usuario = null;

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
		enviarEmailSenha(usuario);
	}

	public void enviarEmailSenha(Usuario usuario) throws UsuarioException {
		String emailRemetente = "secretaria@inf.ufg.br";
		String nomeRemetente = "Instituto de Informatica";
		String assunto = "Senha do Sistema SISPG";
		String mensagem = "";
		String emailDestino = "";
		List<String> emails = new LinkedList<String>();

		try {
			emails = pessoaService.listaEmailsPessoa(usuario.getIdPessoa());
		} catch (EscolaException ee) {
			throw new UsuarioException(ee.getMessage());
		}

		emailDestino = emails.get(0);

		mensagem = "Confira abaixo seus dados para uso no Sistema de Pós-Graduação - SISPG.\n"
				+ "Username = "
				+ usuario.getUsername()
				+ "\n"
				+ "Senha = "
				+ usuario.getSenha() + "\n";

		emailservice.enviarEmailTexto(emailDestino, emailRemetente,
				nomeRemetente, assunto, mensagem);
	}

	public String gerarSenha() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";
		for (int x = 0; x < 8; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += chars.charAt(i);
		}
		return pass;
	}

	public void alterarSenha(String username, String senhaAntiga,
			String senhaNova) throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(username);

			if (!senhaAntiga.equals(usuario.getSenha()))
				throw new UsuarioException("Senha informada não confere!");
			else {
				usuario.setSenha(senhaNova);
				alterarUsuario(usuario);
			}
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
	}

	public void alterarDisponibilidade(String username, boolean disponibilidade)
			throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
		usuario.setDisponibilidade(disponibilidade);
		alterarUsuario(usuario);
	}

	public void alterarValidade(String username, GregorianCalendar validade)
			throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
		usuario.setValidade(validade);
		alterarUsuario(usuario);
	}

	public boolean checarUsername(String username) {

		boolean retorno = false;

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
			retorno = true;
		} catch (UsuarioNaoEncontradoException e) {
			return retorno;
		} catch (UsuarioException e) {
			return retorno;
		}

		return retorno;
	}

	public boolean checarUsuarioDisponivel(String username)
			throws UsuarioException {

		try {

			usuario = usuarioRepositorio.obterUsuario(username);

		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		return usuario.getDisponibilidade();
	}

	public boolean checarValidade(String username) throws UsuarioException {

		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
				.getInstance();

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		return usuario.getValidade().after(cal);
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setEmailservice(EmailService emailservice) {
		this.emailservice = emailservice;
	}

}
