package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoTelefone;

/**
 * Classe definida para modelar os telefones das Pessoas participantes do Sistema Escola.
 * @author gilmar
 *
 */
public class Telefone {
	/**
	 * Atributo definido para modelar o identificador do Telefone.
	 */
	private Long id;
	/**
	 * Atributo definido para modelar o ddd do Telefone.
	 */
	private short DDD;
	/**
	 * Atributo definido para modelar o número do Telefone.
	 */ 
	private long numero;
	/**
	 * Atributo definido para modelar o tipo do Telefone.
	 * Pode ser por exemplo: (Fixo, Celuar, Satélite, Rural, etc.)
	 */ 
	private TipoTelefone tipo;
	/**
	 * Atributo definido para modelar a lista de pessoas que compartilham o telefone
	 */
	private List<Pessoa> pessoas;
	/**
	 * Construtor default
	 *
	 */
	public Telefone(){
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Construtor parametrizado com o número do Telefone.
	 * @param numero
	 */
	public Telefone(long numero){
		setNumero(numero);
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Construtor parametrizado com o ddd e o numero do Telefone. 
	 * @param ddd
	 * @param num
	 */
	public Telefone(short ddd, long num){
		setDDD(ddd);
		setNumero(num);
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Construtor parametrizado com o ddd, o número e o tipo do Telefone.
	 * @param ddd
	 * @param num
	 * @param tp
	 */
	public Telefone(short ddd, long num, String tp){
		setDDD(ddd);
		setNumero(num);
		setTipo(TipoTelefone.valueOf(tp));
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Método definido para obter o ddd do Telefone.
	 * @return DDD
	 */
	public short getDDD() {
		return DDD;
	}
	/**
	 * Método definido para configurar o ddd do Telefone.
	 * @param ddd
	 */
	public void setDDD(short ddd) {
		DDD = ddd;
	}
	/**
	 * Método definido para obter o identificador do Telefone.
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do telefone.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o numero do Telefone.
	 * @return numero
	 */
	public long getNumero() {
		return numero;
	}
	/**
	 * Método definido para configurar o numero do Telefone.
	 * @param numero
	 */
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	/**
	 * Método definido para obter o tipo do Telefone.
	 * @return tipo
	 */
	public TipoTelefone getTipo() {
		return tipo;
	}
	/**
	 * Método definido para configurar o tipo do Telefone.
	 * @param tipo
	 */
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Método definido para obter a lista de pessoas associadas ao telefone.
	 * @return pessoas
	 */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	/**
	 * Método definido para configurar a lista de pessoas associadas ao telefone.
	 * @param pessoas the pessoas to set
	 */
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	/**
	 *Método definido para configurar a apresentação de um Telefone no formato de um objeto da classe String. 
	 *@return String
	 */
	public String toString(){
		StringBuffer dadosTelefone = new StringBuffer();
		dadosTelefone.append("\t " + "DDD " + getDDD() + " \n");
		dadosTelefone.append("\t " + "número " + getNumero() + " \n");
		dadosTelefone.append("\t " + "Tipo " + getTipo() + "\t\t\n");
		return dadosTelefone.toString();
	}
		
}
 
