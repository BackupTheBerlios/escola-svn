package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.List;

/**
 * Classe definida para modelar um Bairro, componente de um endereco.
 * @author gilmar
 *
 */


public class Bairro {

	/**
	 * Atributo definido para modelar o identificador do Bairro.
	 */
	private Long id;

	/**
	 * Atributo definido para modelar o nome do Bairro.
	 */
	private String nome;
	/**
	 * Atributo definido para modelar a cidade onde o bairro se localiza.
	 */
	private Cidade cidade;
	/**
	 * Atributo definido para representar a lista de endereços de um determinado bairro.
	 */
	private List<Endereco> listaEnderecos;
	/**
	 * Construtor default.
	 */
	public Bairro(){}
	/**
	 * Construtor parametrizado com o nome do Bairro.
	 * @param nome
	 */
	public Bairro(String nome){
		setNome(nome);
	}
	/**
	 * Construtor parametrizado com o nome do Bairro e a cidade onde se localiza.
	 * @param nome
	 * @param cidade
	 */
	public Bairro(String nome, Cidade cidade){
		setNome(nome);
		setCidade(cidade);
	}
	/**
	 * Método definido para obter o identificador do Bairro.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do bairro.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o nome do Bairro.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método definido para configurar o nome do Bairro.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método definida para obter a cidade onde se localiza o bairro.
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Método definido para configurar a cidade onde o bairro se localiza
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	/**
	 * Método definido para obter a lista de endereços do bairro.
	 * @return listaEnderecos
	 */
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}
	/**
	 * Método definido para configurar a lista de endereços do bairro.
	 * @param listaEnderecos
	 */
	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	/**
	 * Método definido para configurar a apresentação de um Bairro no formato de um objeto da classe String.
	 * @return
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(getNome() + "\n");
		sb.append(getCidade().toString());
		return sb.toString();
	}
}

