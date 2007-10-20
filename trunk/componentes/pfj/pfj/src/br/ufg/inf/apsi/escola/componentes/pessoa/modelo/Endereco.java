package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.excecoes.TipoEndereco;

/**
 * Classe definida para modelar os Endereços das Pessoas participantes do sistema Escola.
 * @author gilmar
 *
 */

public class Endereco {
	/**
	 * Atributo definido para modelar o identificador do endereço.
	 */
	private Long id;
	/**
	 * Atributo definido para o Logradouro componente do endereço.
	 */
	private Logradouro logradouro;
	/**
	 * atributo definido para modelar o número de um Endereço.
	 * Exemplo: (234, 356A, 932C, S/N).
	 */ 
	private String numero;
	/**
	 * Atributo definido para modelar o complemento de um Endereço. Exemplo: (Qd. 35A, Lt. 12C).
	 */
	private String complemento;
	/**
	 * Atributo definido para modelar o Cep de um Endereço.
	 */ 
	private Integer cep;
	/**
	 * Atributo definido para modelar o Bairro, componente do endereço.
	 */
	private Bairro bairro;
	/**
	 * Atributo definido para modelar o Tipo de um Endereço. Exemplo: COMERCIAL, RESIDENCIAL.
	 */
	private TipoEndereco tipo;
	/**
	 * Atributo definido para modelar a lista de pessoas que compartilham o endereço.
	 */
	private List<Pessoa> pessoas;
		
	/**
	 * Construtor default.
	 *
	 */
	public Endereco(){
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Construtor parametrizado com os atributos necessários para a instanciação de um Endereço.
	 * @param tipoEndereco
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 */
	public Endereco(String tipoEndereco, 
			Logradouro logradouro, 
			String numero, 
			String complemento, 
			Integer cep, 
			Bairro bairro){
		setTipo(TipoEndereco.valueOf(tipoEndereco));
		setNumero(numero);
		setComplemento(complemento);
		setCep(cep);
		setLogradouro(logradouro);
		setBairro(bairro);
		pessoas = new ArrayList<Pessoa>();
	}
	/**
	 * Método definido para obter o Bairro constante do Endereço.
	 * @return bairro
	 */
	public Bairro getBairro() {
		return bairro;
	}
	/**
	 * Método definido para configurar o Bairro constante do Endereço.
	 * @param bairro
	 */
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	/**
	 * Método definido para obter o identificador do Endereço.
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
	 * Método definido para obter o Cep do Endereço.
	 * @return Integer
	 */
	public Integer getCep() {
		return cep;
	}
	/**
	 * Método definido para configurar o Cep do Endereço.
	 * @param cep
	 */
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	/**
	 * Método definido para obter o complemento do Endereço.
	 * @return complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * Método definido para configurar o complemento do Endereço.
	 * @param complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	 * Método definido para obter o Logradouro componente do Endereço.
	 * @return logradouro
	 */
	public Logradouro getLogradouro() {
		return logradouro;
	}
	/**
	 * Método definido para configurar o Logradouro componente do Endereço.
	 * @param logradouro
	 */
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	/**
	 * Método definido para obter o número do Endereço.
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Método definido para configurar o número do Endereço.
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Método definido para obter o tipo do Endereço.
	 * @return tipo
	 */
	public TipoEndereco getTipo() {
		return tipo;
	}

	/**
	 * Método definido para configurar o tipo do Endereço.
	 * @param tipo
	 */
	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	/**
	 * Método definido para obter a lista de pessoas associadas ao endereço.
	 * @return pessoas
	 */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	/**
	 * Método definido para configurar a lista de pessoas associadas ao endereço.
	 * @param pessoas
	 */
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}	 

	
	/**
	 * Método definido para configurar a apresentação de um Endereço no formato de um objeto da classe String.
	 * @return String
	 */
	
	public String toString(){
		StringBuffer dadosEndereco = new StringBuffer();
		dadosEndereco.append("Tipo do Endereço.....: " + getTipo() + "\n");
		dadosEndereco.append("Logradouro...........: " + getLogradouro().getTipo() + " " + getLogradouro().getNome() + "\n");
		dadosEndereco.append("Número...............: " + getNumero() + "\n");
		dadosEndereco.append("Complemento..........: " + getComplemento() + "\n" );
		dadosEndereco.append("Cep..................: " + getCep() + "\n");
		dadosEndereco.append("Bairro...............: " + getBairro().toString() + "\n");
		return dadosEndereco.toString();
	}
	
}	
	
	
 
