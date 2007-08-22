package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.util.TipoLogradouro;

/**
 * Classe definido para modelar os Logradouros componentes dos Enderecos das Pessoas participantes do sistema Escola.
 * @author gilmar
 *
 */

public class Logradouro {
	/**
	 * Atributo definido para modelar o identificador do Logradouro.
	 */
	private Long id;
	/**
	 * Atributo definido para modelar o nome do Logradouro.
	 */
	private String nome;
	/**
	 * Atributo definido para modelar o tipo do Logradouro.
	 */
	private TipoLogradouro tipo;
	/**
	 * Atributo definido para representar os vários Endereços de um Logradouro.
	 */
	private List<Endereco> listaEnderecos;
	/**
	 * Construtor Default.
	 */
	public Logradouro(){}
	/**
	 * Construtor parametizado com o nome do Logradouro.
	 * @param nome
	 */
	public Logradouro(String nome){
		setNome(nome);
	}
	/**
	 * Construtor parametrizado com o nome e o tipo de logradouro.
	 * @param tipo
	 * @param nome
	 */
	public Logradouro(String tipo, String nome){
		setNome(nome);
		setTipo(TipoLogradouro.valueOf(tipo));			
	}
	/**
	 * Método definido para obter o identificador do logradouro.
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do logradouro.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o nome do Logradouro.
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método definido para configurar o nome do Logradouro.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método definido para obter o tipo do Logradouro.
	 * @return
	 */
	public TipoLogradouro getTipo() {
		return tipo;
	}

	/**
	 * Método definido para configurar o tipo do Logradouro.
	 * @param tipo
	 */
	public void setTipo(TipoLogradouro tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Método definido para obter a lista de endereços que o logradouro participa.
	 * @return
	 */
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}
	/**
	 * Método definido para configurar a lista de endereços que o logradouro participa.
	 * @param listaEnderecos
	 */
	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	/**
	 * Método definido para configurar a apresentação de um Logradouro no formato de um objeto da classe String.
	 * @return
	 */
	public String toString(){
		return getTipo() + " " +getNome();
	}
}
