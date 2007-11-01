package br.ufg.inf.apsi.escola.componentes.ca.modelo;

import java.util.GregorianCalendar;

public class Usuario {

	private Long uid;

	private long idPessoa;

	private String username;

	private String senha;

	private boolean disponibilidade;

	private GregorianCalendar validade;

	public Usuario() {
	}

	public Usuario(Long idPessoa, String username, String senha,
			boolean disponibilidade, GregorianCalendar validade) {
		this.idPessoa = idPessoa;
		this.username = username;
		this.senha = senha;
		this.disponibilidade = disponibilidade;
		this.validade = validade;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public GregorianCalendar getValidade() {
		return validade;
	}

	public void setValidade(GregorianCalendar validade) {
		this.validade = validade;
	}
}
