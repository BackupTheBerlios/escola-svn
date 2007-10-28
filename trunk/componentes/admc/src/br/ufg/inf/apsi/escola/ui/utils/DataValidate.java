package br.ufg.inf.apsi.escola.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class DataValidate implements Validator {
	
	Date data = null;
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
	
	
	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		
		 try {  
		       format.setLenient(false);  
		        data = format.parse((String) value);  
		 } catch (ParseException e) {  
			   FacesMessage message = new FacesMessage();
		       message.setDetail("Formato de Data inválida");
		       message.setSummary("Data inválida");
		       message.setSeverity(FacesMessage.SEVERITY_ERROR);
		       throw new ValidatorException(message);  
		 }  
		

	}

}
