package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.Date;

/**
 * Classe definida para modelar uma Pessoa Física participante do sistema Escola.
 * @author Gilmar
 *
 */

public class PessoaFisica extends Pessoa {
	/**
	 * Atributo definido para modelar o sexo da Pessoa Física.
	 */
	private String sexo;
	/**
	 * Atributo definido para modelar a data de nascimento da Pessoa Física
	 */ 
	private Date dataNascimento;
	/**
	 * Atributo definida para modelar a nacionalidade da pessoa física.
	 */
	private String nacionalidade;
	/**
	 * Atributo definido para modelar a natualidade da pessoa física.
	 */
	private String naturalidade;
	/**
	 * Construtor default.
	 *
	 */		
	public PessoaFisica(){
		super();
	}
	/**
	 * Construtor parametizado com o nome da Pessoa Física.
	 * @param nome
	 */
	public PessoaFisica(String nome){
		super(nome);
	}
	
	/**
	 * Método definido para obter o tipo da Pessoa Física.
	 * @return "Pessoa Fisica"
	 */		
	public String getTipo(){
		return "Pessoa Fisica";
	}
	
	/**
	 * Método definido para obter a data de nascimento da Pessoa Física.
	 * @return dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * Método definido para configurar a data de nascimento da Pessoa Física.
	 * @param dataNascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * Método definido para obter o sexo da Pessoa Física.
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Método definido para configurar o sexo da Pessoa Física.
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * Método definido para obter a nacionalidade da pessoa física.
	 * @return nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}
	/**
	 * Método definido para configurar a nacionalidade da pessoa física.
	 * @param nacionalidade
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	/**
	 * Método definido para obter a naturalidade da pessoa física.
	 * @return naturalidade
	 */
	public String getNaturalidade() {
		return naturalidade;
	}
	/**
	 * Método definido para configurar a naturalidade da pessoa física.
	 * @param naturalidade
	 */
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	/**
	 * Método definido para configurar a apresentação de uma Pessoa Física no formato de um objeto da classe String.
	 * @return String
	 */
	public String toString(){
		StringBuffer dadospf = new StringBuffer();
		dadospf.append("Nome.................: " + super.getNome() + "\n");
		dadospf.append("Tipo.................: " + getTipo() + "\n");
		dadospf.append("Sexo.................: " + getSexo() + "\n");
		dadospf.append("Data de Nascimento...: " + getDataNascimento() + "\n");
		dadospf.append("Nacionalidade........: " + getNacionalidade() + "\n");
		dadospf.append("Naturalidade.........: " + getNaturalidade() + "\n");
		dadospf.append("Email(s).............: " + getListaEmails().toString() + "\n");
		dadospf.append("Telefones:" + "\n");
		dadospf.append(getListaTelefones().toString() + "\n");
		dadospf.append("Enderecos:" + "\n");
		dadospf.append(getListaEnderecos().toString() + "\n");
		dadospf.append("Documentos:" + "\n");
		dadospf.append(getListaDocumentos().toString() + "\n");
		return dadospf.toString();
	}
}
 
