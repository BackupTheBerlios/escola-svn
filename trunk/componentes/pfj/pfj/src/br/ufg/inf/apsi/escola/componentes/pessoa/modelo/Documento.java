package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.Date;

/**
 * Classe definida para modelar genericamente um Documento de uma Pessoa componente do sistema Escola.
 * @author gilmar
 *
 */

public abstract class Documento {
	/**
	 * Atributo definido para modelar o identificador do documento.
	 */
	protected Long id;
	/**
	 * Atributo definido para modelar o número do Documento.
	 */ 
	protected String numero;
	/**
	 * Atributo definido para modelar o tipo do documento.
	 */
	protected String tipo;
	/**
	 * Atributo definido para representar a pessoa titular de um determinado documento.
	 */
	protected Pessoa titular;
	/**
	 * Construtor default
	 */
	public Documento(){}
	/**
	 * Construtor parametrizado com seu número o número e a pessoa titular.
	 * Garante a inexistência de um documento sem titular.
	 * @param numero
	 * @param p
	 */
	public Documento(String numero, Pessoa p){
		setNumero(numero);
		setTitular(p);
	}
	/**
	 * Metodo definido para obter o identificador do Documento.
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método definido para configurar o identificador do documento.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Método definido para obter o número do Documento.
	 * @return
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Método definido para configurar o número do Documento.
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Método definido para obter o titular do documento
	 * @return
	 */
	public Pessoa getTitular() {
		return titular;
	}
	/**
	 * Método definido para configurar o titular do documento.
	 * @param titular
	 */
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}
	/**
	 * Método definido para apresentar um documento no formato de um objeto da classe String.
	 */
	public String toString(){
		return getNumero();
	}
	/**
	 * Método definido para validar o número de um Documento.
	 * @param num
	 * @return
	 */
	public abstract boolean validar(String num);
	/**
	 * Método definido para retornar o tipo de um documento.
	 * @return
	 */
	public abstract String getTipo();
	
	/**
	 * Método definido para configurar o tipo de um documento.
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Método definido para retornar uma instância concreta de documento
	 * @param numero
	 * @param dataEmissao
	 * @param orgaoExpedidor
	 * @return
	 */
	public static Documento getDocumento(String numero, Date dataEmissao, String orgaoExpedidor){
		Documento doc;
		RG doc1 = new RG();
		//retorna um cnpj
		if ((numero.length() == 14)&& ((dataEmissao == null) ||(orgaoExpedidor == null))){
			doc = new CNPJ();
			doc.setNumero(numero);
		}	
		//retorna um cpf
		else if ((numero.length() == 11) && ((dataEmissao == null) ||(orgaoExpedidor == null))){
				doc = new CPF();
				doc.setNumero(numero);
		}

		//retorna um rg
		else{
			doc = new RG();
			if (doc instanceof RG) {
				doc1 = (RG) doc;
				doc1.setNumero(numero);
				doc1.setDataEmissao(dataEmissao);
				doc1.setOrgaoExpedidor(orgaoExpedidor);
			}
		}
		if( doc instanceof RG) {
			return doc1;
			
		}else return doc;
			
	} 
	
}
