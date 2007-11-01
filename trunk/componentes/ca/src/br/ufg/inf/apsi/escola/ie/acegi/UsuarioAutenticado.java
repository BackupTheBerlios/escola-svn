package br.ufg.inf.apsi.escola.ie.acegi;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * Classe que implementa a interface UserDetails adicionando atributos
 * específicos do Usuario
 * 
 * @author leandro
 * 
 */
@SuppressWarnings("serial")
public class UsuarioAutenticado implements UserDetails {

	private GrantedAuthority[] authorities = null;
	private String password = null;
	private String username = null;
	private Long uid = null;
	private Long idPessoa = null;
	private String nomePessoa = null;
	private boolean disponibilidade = false;
	private String validade = null;
	private boolean contaNaoExpirada = true;

	public UsuarioAutenticado(GrantedAuthority[] authorities, String password,
			String username, Long uid, Long idPessoa, String nomePessoa,
			boolean disponibilidade, String validade, boolean contaNaoExpirada) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.uid = uid;
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.disponibilidade = disponibilidade;
		this.validade = validade;
		this.contaNaoExpirada = contaNaoExpirada;
	}

	@Override
	public GrantedAuthority[] getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return contaNaoExpirada;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return disponibilidade;
	}

	public long getUid() {
		return uid;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public String getValidade() {
		return validade;
	}

}
