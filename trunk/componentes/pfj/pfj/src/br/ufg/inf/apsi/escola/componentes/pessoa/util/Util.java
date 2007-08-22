package br.ufg.inf.apsi.escola.componentes.pessoa.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Classe definida para a formatação de datas.
 * @author gilmar
 *
 */
public class Util {
	private static DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Formata data a partir de um string passado como parâmetro.
	 * @param data
	 * @return
	 */
	public static Date formataData(String data) {
		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(data);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	/**
	 * Formata a data a partir de uma data passada como parâmetro.
	 * @param data
	 * @return
	 */
	public static String formataData(Date data) {
		return formato.format(data);
	}
}

