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
	 * FonteDeDados para realização de testes com carga de dados.
	 */
	private FonteDeDados dataSource;

	/**
	 * FonteDeDados para realização de testes sem dados.
	 */
	private FonteDeDados dataSourceNull;

	/**
	 * Inicialização dos objetos FontesDeDados para Teste. Executado antes de
	 * todos os métodos de teste.
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
	 * Teste do método GetFieldValue.
	 */
	public void testGetFieldValue() {
		JRDesignField jrdf = new JRDesignField();

		/*
		 * O método deve gerar a exceção em caso de tentativa de recuperação de
		 * objeto sem nunca ter executado o método next().
		 */
		jrdf.setName("Campo01");
		try {
			dataSource.getFieldValue(jrdf);
			fail("Exceção no teste recuperação de dados sem next() não foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exceção não previta gerada no teste recuperação de dados sem next().");
		}

		/*
		 * O método deve gerar a exceção quando, na instanciação do objeto, for
		 * passado null no parâmetro do construtor.
		 */
		jrdf.setName("Campo01");
		try {
			dataSourceNull.getFieldValue(jrdf);
			fail("Exceção no teste de recuperação com iterator=null não foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exceção não prevista gerada no teste de recuperação com iterator = null.");
		}

		/*
		 * Teste de recuperação da primeira linha à terceira linha.
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
			 * Teste de um campo que não existe. Deve retornar null.
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
			 * Teste de um campo que não existe. Deve retornar null.
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
			 * Teste de um campo que não existe. Deve retornar null.
			 */
			jrdf.setName("Campo04");
			assertNull((String) dataSource.getFieldValue(jrdf));

			dataSource.next();

			jrdf.setName("Campo01");

		} catch (Exception e) {
			fail("Exceção não prevista gerada em momento não esperado.");
		}

		/*
		 * O método deve gerar a exceção quando houver tentativa de recuperação
		 * de dados após um next() com retorno falso.
		 */
		try {
			dataSource.getFieldValue(jrdf);
			fail("Exceção no teste de recuperação com iterator=null não foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exceção não prevista gerada no teste de recuperação após next() com retorno falso.");
		}

	}

	/**
	 * Teste do método next.
	 */
	public void testNext() throws Exception {
		/*
		 * O método deve gerar exceção em caso de chamada de next() quando o
		 * iterator for null.
		 */
		try {
			dataSourceNull.next();
			fail("Exceção no teste com iterator=null não foi gerada.");
		} catch (JRException e) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Exceção não previta gerada no teste com iterator=null.");
		}
		try {
			assertTrue(dataSource.next());
			assertTrue(dataSource.next());
			assertTrue(dataSource.next());
			assertFalse(dataSource.next());
			assertFalse(dataSource.next());
			assertFalse(dataSource.next());
		} catch (Exception e) {
			fail("Exceção não prevista gerada em momento não esperado.");
		}
	}

}
