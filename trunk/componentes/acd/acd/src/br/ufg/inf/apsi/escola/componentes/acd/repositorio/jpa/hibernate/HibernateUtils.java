package br.ufg.inf.apsi.escola.componentes.acd.repositorio.jpa.hibernate;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Esta classe fornece servicos de recuperar, gravar, alterar e excluir Objetos
 * do banco de dados, ou para o banco de dados, usando a API do Hibernate.
 * 
 * @author Rodrigo Morian Loures
 */

public class HibernateUtils {
	private static Configuration cfg;
	private static Session session;
	private static SessionFactory sf;
	private static Transaction tx;

	/**
	 * Recupera um Objeto do banco de dados a partir de sua classe e do seu
	 * identificador.
	 * 
	 * @param clazz
	 *            Classe que se deseja recuperar.
	 * @param id
	 *            Identificador unico do Objeto para o banco de dados.
	 * @return Um Objeto do tipo "clazz", ou null no caso do Objeto nao ser
	 *         encontrado.
	 */
	public static Object obtem(Class clazz, Serializable id) {
		Object obj = null;

		start();
		beginTransaction();
		obj = session.get(clazz, id);
		commitTransaction();
		return obj;
	}

	/**
	 * Recupera um Objeto do banco de dados a partir de uma consulta HQL passada
	 * na <code>String</code> como parametro.
	 * 
	 * @param hqlQuery
	 *            Consulta HQL que se deseja executar, deve retornar somente um
	 *            Objeto.
	 * @return Um Objeto de acordo com a execucao de hqlQuery, ou null no caso
	 *         do Objeto nao ser encontrado.
	 */
	public static Object obtem(String hqlQuery) {
		Object obj = null;
		Query q = null;

		start();
		beginTransaction();
		q = session.createQuery(hqlQuery);
		obj = q.uniqueResult();
		commitTransaction();

		return obj;
	}

	/**
	 * Recupera uma colecao de Objetos - <code>List</code> - do banco de dados
	 * a partir de uma consulta HQL passada na <code>String</code> como
	 * parametro.
	 * 
	 * @param hqlQuery
	 *            Consulta HQL que se deseja executar.
	 * @return Uma <code>List</code> de Objeto de acordo com a execucao de
	 *         hqlQuery, ou null no caso de nenhum Objeto nao ser encontrado
	 */
	public static Object obtemList(String hqlQuery) {
		Object obj = null;
		Query q = null;

		start();
		beginTransaction();
		q = session.createQuery(hqlQuery);
		obj = q.list();
		commitTransaction();

		return obj;
	}

	/**
	 * Grava um Objeto no banco de dados.
	 * 
	 * @param object
	 *            Objeto que se deseja gravar no banco de dados.
	 */
	public static void persiste(Object object) {
		start();
		beginTransaction();
		session.save(object);
		commitTransaction();
	}

	/**
	 * Atualiza um Objeto no banco de dados.
	 * 
	 * @param object
	 *            Objeto que se deseja alterar no banco de dados.
	 */
	public static void update(Object object) {
		start();
		beginTransaction();
		session.update(object);
		commitTransaction();
	}

	/**
	 * Exclui um Objeto do banco de dados.
	 * 
	 * @param object
	 *            Objeto que se deseja Excluir.
	 */
	public static void remove(Object object) {
		start();
		beginTransaction();
		session.delete(object);
		commitTransaction();
	}

	/**
	 * Inicia a configuracao basica da API Hibernate.
	 */
	public static void start() {
		BasicConfigurator.configure();
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}

	/**
	 * Abre uma sessao com o banco de dados e inicia uma transacao com o mesmo.
	 */
	public static void beginTransaction() {
		session = sf.openSession();
		tx = session.beginTransaction();
	}

	/**
	 * Faz o "Commit" da transacao com o banco de dados e fecha a sessao com o
	 * mesmo.
	 */
	public static void commitTransaction() {
		tx.commit();
		session.close();
	}

	/**
	 * Faz o "Rollback" da transacao com o banco de dados e fecha a sessao com o
	 * mesmo.
	 */
	public static void rollbackTransaction() {
		tx.rollback();
		session.close();
	}

	/**
	 * Abre e retorna uma sessao com o banco de dados.
	 * 
	 * @return Uma nova sessao com o banco de dados.
	 */
	public static Session newSession() {
		session = sf.openSession();
		return getSession();
	}

	/**
	 * Retorna a atual sessao com o banco de dados.
	 * 
	 * @return A atual sessao com o banco de dados.
	 */
	public static Session getSession() {
		return session;
	}

	/**
	 * Verifica se é possível estabelecer conexão com banco de dados.
	 * 
	 * @return <code>true</code> se e somente se conexão foi realizada
	 *         satisfatoriamente.
	 */
	public static boolean testaConexao() {
		boolean ok = true;
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		try {
			session.connection().getMetaData();
		} catch (HibernateException he) {
			he.printStackTrace();
			ok = false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			ok = false;
		}
		return ok;
	}
}
