package br.ufg.inf.apsi.escola.ui.jsf.managedbeans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConverteStringEmData implements Converter {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		
		Calendar dataCalendar = Calendar.getInstance();
		// if (StringUtils.isBlank(value))
		// value = "00/00/0000";
		try {
			Date data = (Date) dateFormat.parse(value);
			dataCalendar.setTime(data);
		} catch (ParseException e) {
			throw new ConverterException("Data em formato inválido");
		}
		return dataCalendar;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		if (value == null)
			return "";
		String dataFormatada = null;
		dataFormatada = dateFormat.format(((Calendar) value).getTime());
		return dataFormatada;
	}
}