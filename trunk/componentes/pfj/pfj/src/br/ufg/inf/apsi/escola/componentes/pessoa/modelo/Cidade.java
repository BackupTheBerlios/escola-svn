package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.List;

/**
 * Classe definida para modelar uma cidade, componente de um endereço.
 * @author gilmar
 *
 */

public class Cidade {
	/**
	 * Atributo definido para modelar o identidicador da Cidade.
	 */
	private Long id;
	/**
	 * Atributo definido para modelar o nome da Cidade.
	 */
	private String nome;
	/**
	 * Atributo definido para o estado (uf) do qual a cidade faz parte. 
	 */ 
	private Estado estado;
	/**
	 * Atributo definido para representar a lista de bairros de uma determinada cidade.
	 */
	private List<Bairro> listaBairros;
	/**
	 * Construtor default.
	 */
	public Cidade(){}
	/**
	 * Construtor parametrizado com o nome da Cidade.
	 * @param nome
	 */
	public Cidade(String nome){
		setNome(nome);
	}
	/**
	 * Construtor parametrizado com o nome da Cidade e o Estado a que ela pertence.
	 * @param nome
	 * @param est
	 */
	public Cidade(String nome, Estado est){
		setNome(nome);
		setEstado(est);
	}
	/**
	 * Método definido para obter o idenficador da Cidade.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador da cidade.
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o Estado a que a Cidade pertence.
	 * @return estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * Método definido para configurar o Estado a que a Cidade pertence.
	 * @param estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	/**
	 * Método definido para obter o nome de uma Cidade.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método definido para configurar o nome de uma Cidade.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método definido para obter a lista de bairros da cidade.
	 * @return listaBairros
	 */
	public List<Bairro> getListaBairros() {
		return listaBairros;
	}
	/**
	 * Método definido para configurar a lista de bairros de uma cidade.
	 * @param listaBairros
	 */
	public void setListaBairros(List<Bairro> listaBairros) {
		this.listaBairros = listaBairros;
	}
	/**
	 * Método definido para configurar a apresentação de uma Cidade no formato de um objeto da classe String.
	 * @return String
	 */
	
	public String toString(){
		StringBuffer dadosCidade = new StringBuffer();
		dadosCidade.append("Cidade...............: " + getNome() + "\n");
		dadosCidade.append(getEstado().toString());
		return dadosCidade.toString();
	}
	 
}
 
