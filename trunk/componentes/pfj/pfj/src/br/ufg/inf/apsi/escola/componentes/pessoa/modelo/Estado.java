package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.List;

/**
 * Classe definida para modelar os Estados, dos quais as cidades fazem parte.
 * @author gilmar
 *
 */

public class Estado {
	/**
	 * Atributo definido para modelar o identificador do Estado.
	 */
	private Long id;
	/**
	 * Atributo defindido para modelar a sigla do Estado.
	 */
	private String sigla;
	/**
	 * Atributo definido para modelar o nome do Estado.
	 */ 
	private String nome;
	/**
	 * Atributo definido para país do qual o estado faz parte.
	 */
	private Pais pais;
	/**
	 * Atributo definido para modelar a lista de Cidades de um determinado Estado.
	 */
	private List<Cidade> listaCidades;
	/**
	 * Construtor default.
	 *
	 */
	public Estado(){}
	/**
	 * Construtor parametrizado com um String que pode ser o nome ou a sigla do estado.
	 * @param nome
	 */
	public Estado(String nome){
		if (nome.trim().length() == 2){
			setSigla(nome);
			setNome("");
		}else{ 
			setNome(nome);
			setSigla("");
		}	
	}
	/**
	 * Construtor parametrizado com o nome e a sigla do Estado.
	 * @param sigla
	 * @param nome
	 */
	public Estado(String sigla, String nome){
		setNome(nome);
		setSigla(sigla);
	}
	/**
	 * Construtor parametrizado com um String que pode ser o nome ou a sigla do Estado e o País.
	 * @param nome
	 * @param pais
	 */
	public Estado(String nome, Pais pais){
		if (nome.trim().length() == 2){
			setSigla(nome);
			setNome("");
		}else{ 
			setNome(nome);
			setSigla("");
		}	
		setPais(pais);
	}
	/**
	 * Construtor parametrizado com a sigla e o nome do Estado e o país.
	 * @param sigla
	 * @param nome
	 * @param p
	 */
	public Estado(String sigla, String nome, Pais p){
		setSigla(sigla);
		setNome(nome);
		setPais(p);
	}
	/**
	 * Método definido para obter o identificador do Estado.
	 * @return id
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do estado.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o nome do Estado.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método definido para configurar o nome do Estado.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método definido para obter o País do qual um Estado faz parte.
	 * @return pais
	 */
	public Pais getPais() {
		return pais;
	}
	/**
	 * Método definido para configurar o País do qual o Estado faz parte.
	 * @param pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	/**
	 * Método definido para obter a sigla do Estado.
	 * @return sigla
	 */
	public String getSigla() {
		return sigla;
	}
	/**
	 * Método definido para configurar a sigla do Estado.
	 * @param sigla
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/**
	 * Método definido para obter a lista de cidades associadas ao estado.
	 * @return the listaCidades
	 */
	public List<Cidade> getListaCidades() {
		return listaCidades;
	}
	/**
	 * Método definido para configurar a lista de cidades, associadas ao estado.
	 * @param listaCidades the listaCidades to set
	 */
	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}
	/**
	 * Método definido para configurar a apresentação de um Estado no formato de um objeto da classe String.
	 * @return String
	 */
	public String toString(){
		StringBuffer dadosEstado = new StringBuffer();
		dadosEstado.append("Estado...............: " + getNome() + "(" +getSigla() + ")" + "\n");
		dadosEstado.append("País.................: " + getPais().toString());
		return dadosEstado.toString();
	}
}
 
