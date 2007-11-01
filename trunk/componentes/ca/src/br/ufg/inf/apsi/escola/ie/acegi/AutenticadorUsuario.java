package br.ufg.inf.apsi.escola.ie.acegi;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import br.ufg.inf.apsi.escola.componentes.admc.servico.AlunoService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.DocenteService;
import br.ufg.inf.apsi.escola.componentes.admc.servico.SecretarioService;
import br.ufg.inf.apsi.escola.componentes.ca.modelo.UsuarioException;
import br.ufg.inf.apsi.escola.componentes.ca.servico.UsuarioService;
import br.ufg.inf.apsi.escola.componentes.pfj.modelo.EscolaException;
import br.ufg.inf.apsi.escola.componentes.pfj.servico.PessoaService;

/**
 * Classe que implementa UserDetailsService do framework AcegiSecurity
 * 
 * @author leandro
 * 
 */
public class AutenticadorUsuario implements UserDetailsService {
	/**
	 * Referencia a implementacao da classe de servico do componente Usuario
	 */
	private UsuarioService usuarioService = null;
	private SecretarioService secretarioService = null;
	private AlunoService alunoService = null;
	private DocenteService docenteService = null;
	private PessoaService pessoaService = null;

	/**
	 * Cria uma nova instancia de AutenticadorUsuario
	 * 
	 * @param usuarioService
	 *            Referencia para implementacao da classe de servico do
	 *            componente Usuario
	 * @param
	 */
	public AutenticadorUsuario(UsuarioService usuarioService,
			PessoaService pessoaService, AlunoService alunoService,
			DocenteService docenteService, SecretarioService secretarioService) {
		this.usuarioService = usuarioService;
		this.pessoaService = pessoaService;
		this.alunoService = alunoService;
		this.docenteService = docenteService;
		this.secretarioService = secretarioService;
	}

	/**
	 * Busca usuario pelo nome
	 * 
	 * @param username
	 *            Username do usuario
	 * @return Instancia de UserDetails, referencia para um MyUserDetails
	 * @throws org.acegisecurity.userdetails.UsernameNotFoundException
	 *             Quando nenhum usuario e encontrado com o username
	 *             referenciado
	 * @throws org.springframework.dao.DataAccessException
	 *             Na occorencia de qualquer outra excecao
	 * @throws UsuarioException
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		Long uid = null;
		String nomePessoa = null;
		Long idPessoa = null;
		String nomeUsuario = null;
		String validade = null;
		Boolean disponibilidade = null;
		String senha = null;
		boolean contaNaoExpirada = true;

		UserDetails userDetails = null;
		GrantedAuthorityImpl[] grantedAuthoritiesImpl = null;
		Object[] vetorDadosUsuario;
		List<String> autorizacoes = new ArrayList<String>();

		try {
			vetorDadosUsuario = usuarioService.consultaUsuario(username);
		} catch (UsuarioException e) {
			throw new DataAccessResourceFailureException(e.getMessage(), e);
		}

		uid = (Long) vetorDadosUsuario[0];
		nomeUsuario = (String) vetorDadosUsuario[1];
		senha = (String) vetorDadosUsuario[2];
		disponibilidade = (Boolean) vetorDadosUsuario[3];
		idPessoa = (Long) vetorDadosUsuario[4];
		validade = (String) vetorDadosUsuario[5];

		// Se o usuário pretendido for o administrador seta a autorização para
		// ADMIN
		// Senão testa cada uma das permissoes possiveis
		if (nomeUsuario.equalsIgnoreCase("administrador")) {
			autorizacoes.add("ADMIN");
			nomePessoa = "Administrador do Sistema";

		} else {

			if (disponibilidade == true)
				try {
					contaNaoExpirada = usuarioService.checarValidade(username);
				} catch (UsuarioException e) {
					throw new DataAccessResourceFailureException(
							e.getMessage(), e);
				}

			if (secretarioService.isSecretario(idPessoa))
				autorizacoes.add("SECRETARIO");
			if (docenteService.isDocente(idPessoa))
				autorizacoes.add("DOCENTE");
			if (alunoService.isAluno(idPessoa))
				autorizacoes.add("ALUNO");

			try {
				nomePessoa = pessoaService.consultaPessoaId(idPessoa);
			} catch (EscolaException ee) {
				ee.getMessage();
			}
		}

		grantedAuthoritiesImpl = new GrantedAuthorityImpl[autorizacoes.size()];
		for (int i = 0; i < autorizacoes.size(); i++) {
			grantedAuthoritiesImpl[i] = new GrantedAuthorityImpl(autorizacoes
					.get(i));
		}

		userDetails = new UsuarioAutenticado(grantedAuthoritiesImpl, senha,
				nomeUsuario, uid, idPessoa, nomePessoa, disponibilidade,
				validade, contaNaoExpirada);

		return userDetails;
	}

	public SecretarioService getSecretarioService() {
		return secretarioService;
	}

	public void setSecretarioService(SecretarioService secretarioService) {
		this.secretarioService = secretarioService;
	}

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public void setDocenteService(DocenteService docenteService) {
		this.docenteService = docenteService;
	}
}
