package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

import java.util.Date;
/**
 * Classe definida para modelar um Documento do tipo RG.
 * @author Gilmar
 *
 */

public class RG extends Documento {
	/**
	 * Atributo definido para modelar a data de emissão de uma RG.
	 */
	private Date dataEmissao;
	/**
	 * Atributo definido para modelar o Órgão Emissor do RG.
	 */ 
	private String orgaoExpedidor;
	/**
	 * Construtor default.
	 *
	 */
	public RG(){
		super();
	}
	/**
	 * Construtor parametrizado com o número, a pessoa titular, a data de emissão e o órgão expedidor.
	 * @param numero
	 * @param p
	 * @param d
	 * @param oe
	 */
	public RG(String numero, Pessoa p, Date d, String oe){
		super(numero, p);
		setDataEmissao(d);
		setOrgaoExpedidor(oe);
	}
	/**
	 * Método definido para obter a data de emissão de um RG.
	 * @return dataEmissao
	 */
	public Date getDataEmissao() {
		return dataEmissao;
	}
	/**
	 * Método definido para configurar a data de emissão de um RG.
	 * @param dataEmissao
	 */
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	/**
	 * Método definido para obter o órgão expedidor de um RG
	 * @return orgaoEmissor
	 */
	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}
	/**
	 * Método definido para configurar o órgão emissor de um RG.
	 * @param orgaoExpedidor
	 */
	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}
	/**
	 * Método definido para retornar o tipo de um rg.
	 */
	@Override
	public String getTipo() {
		return "RG";
	}
	
	/**
	 * Método definido para configurar a apresentação de um RG no formato de um objeto da classe String.
	 * @return String
	 */
	public String toString(){
		StringBuffer dadosrg = new StringBuffer();
		dadosrg.append("Dados do RG:" + "\n");
		dadosrg.append("Numero...............: " + getNumero() + "\n");
		dadosrg.append("Data Emissao.........: " + getDataEmissao().toString() + "\n");
		dadosrg.append("Órgão Expedidor......: " + getOrgaoExpedidor() + "\n");
		return dadosrg.toString();
	};
	/**
	 * @see br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Documento#validar(String)
	 */
	@Override
	public boolean validar (String num){
		return true;
	}
	 
}
 
