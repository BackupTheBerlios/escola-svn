package br.ufg.inf.apsi.escola.componentes.nf.modelo;

import java.util.Date;

public class Frequencia {
	
	private Date data;
	private boolean estevePresente;
	
	public Frequencia(Date data, boolean stevePresente) {
		this.setData(data);
		this.setEstevePresente(estevePresente);
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isEstevePresente() {
		return estevePresente;
	}
	public void setEstevePresente(boolean estevePresente) {
		this.estevePresente = estevePresente;
	}
	
	
}
