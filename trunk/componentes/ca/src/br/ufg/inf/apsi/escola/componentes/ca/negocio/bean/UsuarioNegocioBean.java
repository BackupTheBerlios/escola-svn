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
import br.ufg.inf.apsi.escola.componentes.ca.repositorio.UsuarioRepository;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;
import br.ufg.inf.apsi.escola.ie.email.EmailService;

/**
 * Implementação da interface de negócio do componente Controle de Acesso
 * 
 * @author leandro
 * 
 */
class UsuarioNegocioBean implements UsuarioNegocio {

	private UsuarioRepository usuarioRepositorio = null;
	private Usuario usuario = null;
	PessoaService pessoaService = null;
	EmailService emailService = null;

	/**
	 * Cria uma nova instânica de UsuarioNegocioBean
	 * 
	 * @param usuarioRepositorio
	 * 
	 */
	public UsuarioNegocioBean(UsuarioRepository usuarioRepositorio,
			PessoaService pessoaService, EmailService emailService) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.pessoaService = pessoaService;
		this.emailService = emailService;
	}

	/**
	 * Operação definida para cadastrar um novo usuário no sistema
	 */
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

	/**
	 * Operação definida para remover um usuário dado seu username
	 */
	void alterarUsuario(Usuario usuario) throws UsuarioException {
		if (usuario != null)
			usuarioRepositorio.updateUsuario(usuario);
		else
			throw new UsuarioException("Usuario invalido");
	}

	/**
	 * Operação definida para remover um usuário dado seu username
	 */
	public void removerUsuario(String username) throws UsuarioException {

		try {
			usuarioRepositorio.excluirUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
	}

	/**
	 * Operação definida para listar todos os usuários
	 */
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

	/**
	 * Operação definida para retornar os dados de um determinado usuário
	 */
	public Object[] consultaUsuario(String username) throws UsuarioException {

		String dataFormatada;
		Date data;
		DateFormat formata;
		// String nomePessoa;
		Object[] vetorDados = new Object[6];

		try {

			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		data = usuario.getValidade().getTime();
		formata = DateFormat.getDateInstance();
		dataFormatada = formata.format(data);

		/*
		 * try { nomePessoa =
		 * pessoaService.consultaPessoaId(usuario.getIdPessoa()); } catch
		 * (EscolaException ee) { throw new UsuarioException(ee.getMessage()); }
		 */

		vetorDados[0] = usuario.getUid();
		vetorDados[1] = usuario.getUsername();
		vetorDados[2] = usuario.getSenha();
		vetorDados[3] = usuario.getDisponibilidade();
		vetorDados[4] = usuario.getIdPessoa();
		vetorDados[5] = dataFormatada;

		return vetorDados;
	}

	/**
	 * * Operacao definida para listar usuários de acordo com a disponibilidade
	 */
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

	/**
	 * Operacao definida para listar usuários de acordo com o período informado
	 */
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

	/**
	 * Operação definida para recuperar a senha de um usuário que a esqueceu. Um
	 * e-mail será enviado com a senha
	 */
	public void recuperarSenha(String username) throws UsuarioException {
		Usuario usuario = null;

		try {
			usuario = usuarioRepositorio.obterUsuario(username);
		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}
		enviarEmailSenha(usuario);
	}

	/**
	 * Operação definida para enviar um email para o Usuario referenciado
	 * 
	 * @param usuario
	 * @throws UsuarioException
	 */
	void enviarEmailSenha(Usuario usuario) throws UsuarioException {
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

		emailService.enviarEmailTexto(emailDestino, emailRemetente,
				nomeRemetente, assunto, mensagem);
	}

	/**
	 * Operação definida para gerar uma senha aleatória para o usuário que for
	 * cadastrado
	 * 
	 * @return A senha como uma String
	 */
	String gerarSenha() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";
		for (int x = 0; x < 8; x++) {
			int i = (int) Math.floor(Math.random() * 62);
			pass += chars.charAt(i);
		}
		return pass;
	}

	/**
	 * Operacao definida para alterar a senha de um usuário. Deve-se passar o
	 * username, a senha antiga e a nova senha pretendida.
	 */
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

	/**
	 * Operação definida para alterar a disponibilidade da conta de um usuário.
	 */
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

	/**
	 * Operação definida para alterar o prazo de validade da conta de um
	 * usuário.
	 */
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

	/**
	 * Operação definida para checar se o username já existe.
	 * 
	 * @param username
	 * @return true ou false
	 */
	boolean checarUsername(String username) {

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

	/**
	 * Operação definida para checar se a conta do usuário está ou não
	 * disponível.
	 */
	public boolean checarUsuarioDisponivel(String username)
			throws UsuarioException {

		try {

			usuario = usuarioRepositorio.obterUsuario(username);

		} catch (UsuarioNaoEncontradoException unee) {
			throw new UsuarioException(unee.getMessage());
		}

		return usuario.getDisponibilidade();
	}

	/**
	 * Operação definida para checar se a conta do usuário está dentro do
	 * período de validade.
	 */
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

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public EmailService getEmailservice() {
		return emailService;
	}

	public void setEmailservice(EmailService emailService) {
		this.emailService = emailService;
	}

}
