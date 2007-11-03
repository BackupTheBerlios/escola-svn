package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource;

import java.util.HashMap;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Classe fonte de dados para relatórios JasperReports.
 * 
 * Implementa a interface JRDataSource da API JasperReports e uma instância
 * dessa classe é utilizada no método estático fillReport da classe
 * JasperFillManager.
 * 
 * @author Yoshiyuki
 * 
 */
public class FonteDeDados implements JRDataSource {

	/**
	 * Iterator que será carregado com os dados do relatório.
	 */
	private Iterator<HashMap<String, String>> iterator;

	/**
	 * Referência utilizada para recuperar o HashMap do iterator com os dados da
	 * linha corrente.
	 */
	private HashMap<String, String> dadosLinha;
	
	/**
	 * Cria um instância de fonte de dados DSIteratorStringString.
	 * 
	 * @param iterator
	 *            Iterator<HashMap<String>,<String>> contendo os dados do
	 *            relatorio. Cada um dos itens deste iterator é um HashMap<String,String>
	 *            que contém os dados de uma linha do relatório. Neste HashMap,
	 *            a chave é o nome do campo configurado no relatório e o valor é
	 *            dado que será impresso no campo.
	 */
	public FonteDeDados(Iterator<HashMap<String, String>> iterator) {
		this.iterator = iterator;
	}

	/**
	 * Método da interface JRDataSource da API JasperReports utilizado para
	 * fornecer os dados à ferramenta do Jasper que preencherá o relatório.
	 * 
	 * @param jRF
	 *            JRField (campo do relatório) para o qual um dado deve ser
	 *            retornado.
	 * @return Object Retorna um object com um dado para o relatório.
	 * @throws JRException
	 *             Exceção do JasperReports.
	 */
	public Object getFieldValue(JRField jRF) throws JRException {
		if (dadosLinha == null){
			throw new JRException("HashMap<String,String> de dados da linha igual a null");
		}
		return dadosLinha.get(jRF.getName());
	}

	/**
	 * Método da interface JRDataSource da API JasperReports utilizado para
	 * checar a existência de mais uma linha para o relatório e, em caso
	 * positivo, setar a próxima linha como a linha corrente.
	 */
	public boolean next() throws JRException {
		if (iterator == null){
			throw new JRException("Iterator<HashMap<String,String>> de dados igual a null");
		}
		if (iterator.hasNext()) {
			dadosLinha = iterator.next();
			return true;
		}
		dadosLinha = null;
		return false;
	}
}
