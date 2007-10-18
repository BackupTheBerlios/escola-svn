package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *Classe definida para modelar uma Pessoa, participante do sistema Escola. 
 */
public  class Pessoa {
	/**
	 * Atributo definido para modelar o identificador da Pessa.
	 */
	protected Long id;
	/**
	 * Atributo definido para modelar o nome da Pessoa.
	 */
	protected String nome;
	/**
	 * Atributo definido para modelar o tipo da Pessoa
	 */
	protected String tipo;
	/**
	 * Atributo definido para modelar a lista de enderecos da pessoa.
	 */
	protected List<Endereco> listaEnderecos;
	/**
	 * Atributo definido para modelar a lista de Emails que a Pessoa possui.
	 */
	protected List<Email> listaEmails;
	/**
	 * Atributo definido para modelar a lista de Telefones que a Pessoa possui.
	 */ 
	protected List<Telefone> listaTelefones;
	/**
	 * Atributo definido para modelar a lista de documentos da pessoa;
	 */
	protected List<Documento> listaDocumentos;
	
	
	/**
	 * Construtor Default
	 */
	public Pessoa(){
		setListas();
	}
	/**
	 * Construtor parametrizado com o nome da Pessoa
	 * @param nome
	 */
	public Pessoa(String nome){
		setNome(nome);
		setListas();
	}
	
	/**
	 * Método definido para obter o identificador da Pessoa.
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador da pessoa.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter a lista de Emails da Pessoa.
	 * @return
	 */
	public List<Email> getListaEmails() {
		return listaEmails;
	}
	/**
	 * Método definido para configurar a lista de Emails da Pessoa.
	 * @param emails
	 */
	public void setListaEmails(List<Email> emails) {
		this.listaEmails = emails;
	}
	/**
	 * Método definido para obter a lista de Endereços da Pessoa.
	 * @return
	 */
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}
	/**
	 * Método definido para configurar a lista de Endereços da Pessoa.
	 * @param listaEnderecos
	 */
	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		
		this.listaEnderecos = listaEnderecos;
		
	}
	
	/**
	 * Método definido para obter o nome da Pessoa.
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método definido para configurar o nome da Pessoa.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método definido para obter a lista de Telefones da Pessoa.
	 * @return
	 */
	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}
	/**
	 * Método definido para configurar a lista de Telefones da Pessoa.
	 * @param telefones
	 */
	public void setListaTelefones(List<Telefone> telefones) {
		this.listaTelefones = telefones;
	}
	
	/**
	 * Método definida para obter o tipo de uma Pessoa.
	 * @return
	 */
	public  String getTipo(){ return "F";}
	/**
	 * Método definida para configurar o tipo de uma pessoa
	 *@param tipo
	 */
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	/**
	 * Método definida para obter a lista de documentos da pessoa.
	 * @return
	 */
	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	/**
	 * Método definido para configurar a lista de documentos da pessoa.
	 * @param listaDocumentos
	 */
	public void setListaDocumentos(List<Documento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}
	/**
	 * Operação definida para configurar a lista de emails, de endereços, de documentos e de telefones da pessoa.
	 */
	public void setListas(){
		listaDocumentos = new ArrayList<Documento>();
		listaEmails = new ArrayList<Email>();
		listaEnderecos = new ArrayList<Endereco>();
		listaTelefones = new ArrayList<Telefone>();
	}	
}
 
