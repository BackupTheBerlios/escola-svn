package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;


import java.util.List;

/**
 * Classe definida para modelar um País.
 * Utilizado como componente do endereço de uma Pessoa.
 * @author gilmar
 *
 */
public class Pais {
	/**
	 * Atributo definido para modelar o identificador do País.
	 */
	private Long id;
	/**
	 * Atributo definido para modelar o nome do País.
	 */
	private String nome;
	/**
	 * Atributo definido para representar os Estados que estão relacionados ao País.
	 */
	private List<Estado> listaEstados;
	/**
	 * Construtor Default
	 *
	 */
	public Pais(){}
	/**
	 * Construtor parametrizado com o nome do Pais.
	 * @param nome
	 */
	public Pais(String nome){
		setNome(nome);
	}
	/**
	 * Método definido para obter o identificador do País.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do país.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o nome do País.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método definido para configurar o nome do País.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método definido para obter a lista de estados, associados ao país.
	 * @return listaEstados
	 */
	public List<Estado> getListaEstados() {
		return listaEstados;
	}
	/**
	 * Método definido para configurar a lista de estados, associados ao país.
	 * @param listaEstados
	 */
	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}
	/**
	 * Método definido para configurar a apresentação de um País no formato de um objeto da classe String.
	 * @return String
	 */
	public String toString(){
		return getNome();
	}
}
 
