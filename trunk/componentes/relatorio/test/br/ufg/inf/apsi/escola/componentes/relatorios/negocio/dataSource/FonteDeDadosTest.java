package br.ufg.inf.apsi.escola.componentes.relatorios.negocio.dataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import junit.framework.TestCase;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignField;

/**
 * Classe de teste da classe FonteDeDados.
 * 
 * @author Yoshiyuki Kuwae
 */
public class FonteDeDadosTest extends TestCase {

	/**
	 * FonteDeDados para realiza��o de testes com carga de dados.
	 */
	private FonteDeDados dataSource;

	/**
	 * FonteDeDados para realiza��o de testes sem dados.
	 */
	private FonteDeDados dataSourceNull;

	/**
	 * Inicializa��o dos objetos FontesDeDados para Teste. Executado antes de
	 * todos os m�todos de teste.
	 */
	protected void setUp() throws Exception {
		HashMap<String, String> hmss;
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

		hmss = new HashMap<String, String>();
		hmss.put("Campo01", "valorLinha01Campo01");
		hmss.put("Campo02", "valorLinha01Campo02");
		hmss.put("Campo03", "valorLinha01Campo03");
		arrayList.add(hmss);

		hmss = new HashMap<String, String>();
		hmss.put("Campo01", "valorLinha02Campo01");
		hmss.put("Campo02", "valorLinha02Campo02");
		hmss.put("Campo03", "valorLinha02Campo03");
		arrayList.add(hmss);

		hmss = new HashMap<String, String>();
		hmss.put("Campo01", "valorLinha03Campo01");
		hmss.put("Campo02", "valorLinha03Campo02");
		hmss.put("Campo03", "valorLinha03Campo03");
		arrayList.add(hmss);

		Iterator<HashMap<String, String>> iterator = arrayList.iterator();

		dataSource = new FonteDeDados(iterator);
		dataSourceNull = new FonteDeDados(null);

	}

	/**
	 * Teste do m�todo GetFieldValue.
	 */
	public void testGetFieldValue() {
		JRDesignField jrdf = new JRDesignField();

		/*
		 * O m�todo deve gerar a exce��o em caso de tentativa de recupera��o de
		 * objeto sem nunca ter executado o m�todo next().
		 */
		jrdf.setName("Campo01");
		try {
			dataSource.getFieldValue(jrdf);
			fail("Exce��o no teste recupera��o de dados sem next() n�o foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exce��o n�o previta gerada no teste recupera��o de dados sem next().");
		}

		/*
		 * O m�todo deve gerar a exce��o quando, na instancia��o do objeto, for
		 * passado null no par�metro do construtor.
		 */
		jrdf.setName("Campo01");
		try {
			dataSourceNull.getFieldValue(jrdf);
			fail("Exce��o no teste de recupera��o com iterator=null n�o foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exce��o n�o prevista gerada no teste de recupera��o com iterator = null.");
		}

		/*
		 * Teste de recupera��o da primeira linha � terceira linha.
		 */
		try {
			dataSource.next();

			jrdf.setName("Campo01");
			assertEquals("valorLinha01Campo01", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo02");
			assertEquals("valorLinha01Campo02", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo03");
			assertEquals("valorLinha01Campo03", (String) dataSource
					.getFieldValue(jrdf));
			/*
			 * Teste de um campo que n�o existe. Deve retornar null.
			 */
			jrdf.setName("Campo04");
			assertNull((String) dataSource.getFieldValue(jrdf));

			dataSource.next();

			jrdf.setName("Campo01");
			assertEquals("valorLinha02Campo01", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo02");
			assertEquals("valorLinha02Campo02", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo03");
			assertEquals("valorLinha02Campo03", (String) dataSource
					.getFieldValue(jrdf));
			/*
			 * Teste de um campo que n�o existe. Deve retornar null.
			 */
			jrdf.setName("Campo04");
			assertNull((String) dataSource.getFieldValue(jrdf));

			dataSource.next();

			jrdf.setName("Campo01");
			assertEquals("valorLinha03Campo01", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo02");
			assertEquals("valorLinha03Campo02", (String) dataSource
					.getFieldValue(jrdf));
			jrdf.setName("Campo03");
			assertEquals("valorLinha03Campo03", (String) dataSource
					.getFieldValue(jrdf));
			/*
			 * Teste de um campo que n�o existe. Deve retornar null.
			 */
			jrdf.setName("Campo04");
			assertNull((String) dataSource.getFieldValue(jrdf));

			dataSource.next();

			jrdf.setName("Campo01");

		} catch (Exception e) {
			fail("Exce��o n�o prevista gerada em momento n�o esperado.");
		}

		/*
		 * O m�todo deve gerar a exce��o quando houver tentativa de recupera��o
		 * de dados ap�s um next() com retorno falso.
		 */
		try {
			dataSource.getFieldValue(jrdf);
			fail("Exce��o no teste de recupera��o com iterator=null n�o foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exce��o n�o prevista gerada no teste de recupera��o ap�s next() com retorno falso.");
		}

	}

	/**
	 * Teste do m�todo next.
	 */
	public void testNext() throws Exception {
		/*
		 * O m�todo deve gerar exce��o em caso de chamada de next() quando o
		 * iterator for null.
		 */
		try {
			dataSourceNull.next();
			fail("Exce��o no teste com iterator=null n�o foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exce��o n�o previta gerada no teste com iterator=null.");
		}
		try {
			assertTrue(dataSource.next());
			assertTrue(dataSource.next());
			assertTrue(dataSource.next());
			assertFalse(dataSource.next());
			assertFalse(dataSource.next());
			assertFalse(dataSource.next());
		} catch (Exception e) {
			fail("Exce��o n�o prevista gerada em momento n�o esperado.");
		}
	}

}
