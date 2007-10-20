package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.regex.*;

/**
 * Classe definida para modelar os Emails das Pessoas participantes do sistema Escola.
 * @author gilmar
 *
 */


public class Email {
	/**
	 * Atributo definido para modelar o identificador do Email.
	 */
	private Long id;
	/**
	 * Atributo definido para modelar o Email propriamente dito.
	 */
	private String email;
	/**
	 * Atributo definido para representar a pessoa, titular do email.
	 */
	private Pessoa titularEmail;
	/**
	 * Construtor default.
	 *
	 */
	public Email(){}
	/**
	 * Construtor parametrizado com um objeto String representando o Email.
	 * @param email
	 */
	public Email(String email){
		setEmail(email);
	}
	/**
	 * Método definido para obter um Email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Método definido para configurar um Email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Método definido para obter o identificador de um Email.
	 * @return id
	 */
	public Long getId() {
		return id;
	}	
	
	/**
	 * Método definido para configurar o identificador de um email.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Método definido para obter o titular de um email.
	 * @return titularEmail
	 */
	public Pessoa getTitularEmail() {
		return titularEmail;
	}
	/**
	 * Método definido para configurar o titular de um email.
	 * @param titularEmail
	 */
	public void setTitularEmail(Pessoa titularEmail) {
		this.titularEmail = titularEmail;
	}
	/**
	 * Método definido para validar um Email.
	 * @param email
	 * @return boolean
	 */
	public boolean validar(String email){
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (!m.find()){
			return false;
		}else{	
			return true;
		}
	}
	/**
	 * Método definido para configurar a apresentação de um Email no formato de um objeto da classe String.
	 * @return String
	 */
	public String toString(){
		return getEmail();
	}
	
}
 
