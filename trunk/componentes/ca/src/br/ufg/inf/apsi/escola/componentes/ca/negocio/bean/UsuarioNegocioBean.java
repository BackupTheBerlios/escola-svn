package br.ufg.inf.apsi.escola.componentes.ca.negocio.bean;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	PessoaService pessoaService;
	EmailService emailservice;

	public UsuarioNegocioBean(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
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

	public void removerUsuario(long uid) throws UsuarioException {

		try {
			usuarioRepositorio.excluirUsuario(uid);
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

	public String consultaUsuario(String username) throws UsuarioException {

		String dadosUsuario = "";
		String dataFormatada;
		Date data;
		DateFormat formata;

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		data = usuario.getValidade().getTime();
		formata = DateFormat.getDateInstance();
		dataFormatada = formata.format(data);

		dadosUsuario = usuario.getUid() + "\n" + usuario.getUsername() + "\n"
				+ usuario.getSenha() + "\n" + usuario.getDisponibilidade()
				+ "\n" + dataFormatada + "\n" + usuario.getIdPessoa() + "\n";

		return dadosUsuario;
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
		String nomePessoa = "";

		List<String> emails = new ArrayList<String>();
		// List<String> documentos = new ArrayList<String>();

		try {
			emails = pessoaService.listaEmailsPessoa(usuario.getIdPessoa());
			/*
			 * documentos = pessoaService.listaDocumentosPessoa(usuario
			 * .getIdPessoa()); nomePessoa =
			 * pessoaService.consultaPessoaDocumento(documentos .get(0));
			 */
		} catch (EscolaException ee) {
			throw new UsuarioException(ee.getMessage());
		}

		emailDestino = emails.get(0);

		/*mensagem = "Caro "
				+ nomePessoa
				+ ",\n"
				+ "esta é a sua senha para uso no Sistema de Pós-Graduação - SISPG.\n"
				+ usuario.getSenha() + "\n"
				+ "Caso deseje trocá-la, basta clicar no link abaixo: \n"
				+ "http://";*/
		
		mensagem = "texto";

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

	public void alterarDisponibilidade(long uid, boolean disponibilidade)
			throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(uid);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
		usuario.setDisponibilidade(disponibilidade);
		alterarUsuario(usuario);
	}

	public void alterarValidade(long uid, GregorianCalendar validade)
			throws UsuarioException {

		try {
			usuario = usuarioRepositorio.obterUsuario(uid);
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

		} catch (UsuarioNaoEncontradoException e) {
			throw new UsuarioException("Usuário não existe!");
		}

		return usuario.getDisponibilidade();
	}

	public boolean checarValidade(String username) throws UsuarioException {

		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
				.getInstance();

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException e) {
			throw new UsuarioException("Usuário não existe!");
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
