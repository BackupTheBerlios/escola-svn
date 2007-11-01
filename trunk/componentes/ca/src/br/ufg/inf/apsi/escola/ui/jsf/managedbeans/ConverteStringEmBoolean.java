package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConverteStringEmBoolean implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		return Boolean.parseBoolean(value);
	}

	public String getAsString(FacesContext arg0, UIComponent component,
			Object value) {

		String disponibilidade = (String) value;

		return disponibilidade;
	}

}
