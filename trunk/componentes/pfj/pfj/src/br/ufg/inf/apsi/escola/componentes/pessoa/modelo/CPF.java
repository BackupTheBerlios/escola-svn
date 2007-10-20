package br.ufg.inf.apsi.escola.componentes.pessoa.modelo;



/**
 * Classe definida para modelar um Documento cujo tipo é Cpf.
 * @author gilmar
 *
 */

public class CPF extends Documento {
	/**
	 * Construtor Default
	 */
	public CPF(){
		super();
	}
	/**
	 * Construtor parametizado com o número
	 * @param numero
	 * @param p
	 */
	public CPF(String numero, Pessoa p){
		super(numero, p);
	}
	/**
	 * Método definido para retornar o tipo de um cpf.
	 * @return "CPF"
	 */
	
	@Override
	public String getTipo() {
		return "CPF";
	}

	/**
	 * Método definido para validar o número de um Cpf.
	 * @param cpf
	 * @return boolean
	 */
	public boolean validar(String cpf){
		int soma = 0;

		try {
			Long.parseLong(cpf);
		} 
		catch (Exception e) {
			System.out.println("Somente números são permitidos!");   
			return false;
		}
		if(cpf.length() == 11) {
			for (int i=0; i < 9; i++)
				soma += (10 - i) * (cpf.charAt(i) - '0');
			soma = 11 - (soma % 11);
			if (soma > 9) soma = 0;
			if (soma == (cpf.charAt(9) - '0')) {
				soma = 0;
				for (int i=0; i < 10; i++)
					soma += (11 - i) * (cpf.charAt(i) - '0');
				soma = 11 - (soma % 11);
				if (soma > 9) soma = 0;
				if (soma == (cpf.charAt(10) - '0')) {
					return true;
				}
			}
		}
		return false;	
	}

}
 
