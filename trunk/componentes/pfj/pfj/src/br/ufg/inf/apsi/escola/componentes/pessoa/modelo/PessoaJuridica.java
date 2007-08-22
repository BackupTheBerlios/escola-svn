package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;

/**
 * Classe definida para modelar uma Pessoa Jurídica.
 * @author gilmar
 *
 */
public class PessoaJuridica extends Pessoa {
	/**
	 * Atributo definido para modelar o nome de fantasia da Pessoa Jurídica.
	 */
	private String nomeFantasia; 
	/**
	 * Construtor Default
	 */
	public PessoaJuridica(){
		super();
	}
	/**
	 * Construtor parametrizado com o nome da Pessoa Jurídica 
	 * @param nome
	 */
	public PessoaJuridica(String nome){
		super(nome);
	}
	
	/**
	 * Método definido para obter o tipo da Pessoa Jurídica.
	 */
	public String getTipo(){
		return "Pessoa Juridica";
	}
	
	/**
	 * Método definido para obter o nome de fantasia da Pessoa Jurídica.
	 * @return
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	/**
	 * Método definido para configurar o nome de fantasia da Pessoa Jurídica.
	 * @param nomeFantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	/**
	 * Método definido para configurar a apresentação de uma Pessoa Jurídica no formato de um objeto da classe String.
	 */
	public String toString(){
		StringBuffer dadospj = new StringBuffer();
		dadospj.append("Nome.................: " + super.getNome() + "\n");
		dadospj.append("Nome de Fantasia.....: " + getNomeFantasia() + "\n");
		dadospj.append("Tipo.................: " + getTipo() + "\n");
		dadospj.append("Email(s).............: " + getListaEmails().toString() + "\n");
		dadospj.append("Telefones............: " + "\n");
		dadospj.append(getListaTelefones().toString() + "\n");
		dadospj.append("Endereços.............: " + "\n");
		dadospj.append(getListaEnderecos().toString() + "\n");
		dadospj.append("Documentos.............: " + "\n");
		dadospj.append(getListaDocumentos().toString() + "\n");
		return dadospj.toString();
	}
	 
}
 
