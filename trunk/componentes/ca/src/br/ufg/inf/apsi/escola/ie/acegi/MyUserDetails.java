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
public class MyUserDetails implements UserDetails {

	private GrantedAuthority[] authorities = null;
	private String password = null;
	private String username = null;
	private long uid;
	private String nomePessoa;
	private boolean disponibilidade;
	private String validade;

	public MyUserDetails(GrantedAuthority[] authorities, String password,
			String username, long uid, String nomePessoa,
			boolean disponibilidade, String validade) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.disponibilidade = disponibilidade;
		this.nomePessoa = nomePessoa;
		this.uid = uid;
		this.validade = validade;
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
		return true;
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

	public String getNomePessoa() {
		return nomePessoa;
	}

	public String getValidade() {
		return validade;
	}

}
