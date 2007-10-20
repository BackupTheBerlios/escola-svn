package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;



/**
 * Classe definida para modelar um Documento cujo tipo é Cnpj.
 * @author gilmar
 *
 */
public class CNPJ extends Documento {
	/**
	 * Construtor Default
	 */
	public CNPJ(){
		super();
	}
	/**
	 * Construtor parametizado com o número
	 * @param numero
	 * @param p
	 */
	public CNPJ(String numero, Pessoa p){
		super(numero, p);
	}
	/**
	 * Método definido para retornar o tipo de um cnpj.
	 * @return "CNPJ"
	 */
	@Override
	public String getTipo() {
		return "CNPJ";
	}
	
	/**
	 * Método definido para efetuar a validação de um número de Cnpj.
	 * @param cnpj
	 * @return boolean
	 */
	public boolean validar(String cnpj){
		int soma = 0;

		try {
			Long.parseLong(cnpj);
		} 
		catch (Exception e) {
			System.out.println("Somente números são permitidos!");
			return false;
		}
		if(cnpj.length() == 14) {
			for (int i=0, j = 5; i < 12; i++) {
				soma += j-- * (cnpj.charAt(i) - '0');
				if (j < 2) j = 9;
			}
			soma = 11 - (soma % 11);
			if (soma > 9) soma = 0;
				if (soma == (cnpj.charAt(12) - '0')) {
					soma = 0;
					for (int i=0, j = 6; i < 13; i++) {
						soma += j-- * (cnpj.charAt(i) - '0');
						if (j < 2) 
							j = 9;
					}
				soma = 11 - (soma % 11);
				if (soma > 9) soma = 0;
					if (soma == (cnpj.charAt(13) - '0')){
						return true;
					}
				}
		}
		return false;
	}

}

