package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource;

import java.util.HashMap;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Classe fonte de dados para relat�rios JasperReports.
 * 
 * Implementa a interface JRDataSource da API JasperReports e uma inst�ncia
 * dessa classe � utilizada no m�todo est�tico fillReport da classe
 * JasperFillManager.
 * 
 * @author Yoshiyuki
 * 
 */
public class FonteDeDados implements JRDataSource {

	/**
	 * Iterator que ser� carregado com os dados do relat�rio.
	 */
	private Iterator<HashMap<String, String>> iterator;

	/**
	 * Refer�ncia utilizada para recuperar o HashMap do iterator com os dados da
	 * linha corrente.
	 */
	private HashMap<String, String> dadosLinha;
	
	/**
	 * Cria um inst�ncia de fonte de dados DSIteratorStringString.
	 * 
	 * @param iterator
	 *            Iterator<HashMap<String>,<String>> contendo os dados do
	 *            relatorio. Cada um dos itens deste iterator � um HashMap<String,String>
	 *            que cont�m os dados de uma linha do relat�rio. Neste HashMap,
	 *            a chave � o nome do campo configurado no relat�rio e o valor �
	 *            dado que ser� impresso no campo.
	 */
	public FonteDeDados(Iterator<HashMap<String, String>> iterator) {
		this.iterator = iterator;
	}

	/**
	 * M�todo da interface JRDataSource da API JasperReports utilizado para
	 * fornecer os dados � ferramenta do Jasper que preencher� o relat�rio.
	 * 
	 * @param jRF
	 *            JRField (campo do relat�rio) para o qual um dado deve ser
	 *            retornado.
	 * @return Object Retorna um object com um dado para o relat�rio.
	 * @throws JRException
	 *             Exce��o do JasperReports.
	 */
	public Object getFieldValue(JRField jRF) throws JRException {
		if (dadosLinha == null){
			throw new JRException("HashMap<String,String> de dados da linha igual a null");
		}
		return dadosLinha.get(jRF.getName());
	}

	/**
	 * M�todo da interface JRDataSource da API JasperReports utilizado para
	 * checar a exist�ncia de mais uma linha para o relat�rio e, em caso
	 * positivo, setar a pr�xima linha como a linha corrente.
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
