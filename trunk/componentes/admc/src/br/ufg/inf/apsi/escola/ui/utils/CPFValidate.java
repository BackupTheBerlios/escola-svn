package br.ufg.inf.apsi.escola.ui.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CPFValidate implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		
		String strCpf = (String) value;
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		String cpf = "";

		cpf = strCpf.replace('.', ' ');
		cpf = cpf.replace('-', ' ');

		strCpf = cpf.substring(0, 3) + cpf.substring(4, 7)
				+ cpf.substring(8, 11) + cpf.substring(12, 14);
		strCpf.trim();

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount))
					.intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
			// e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro
			// digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		// Primeiro resto da divisão por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
		// menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divisão por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
		// menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que está sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf
				.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		if(!nDigVerific.equals(nDigResult)){
			FacesMessage message = new FacesMessage();
		    message.setDetail("Formato de CPF inválido");
		    message.setSummary("CPF inválido");
		    message.setSeverity(FacesMessage.SEVERITY_ERROR);
		    throw new ValidatorException(message);  
			
		}

	}

}
