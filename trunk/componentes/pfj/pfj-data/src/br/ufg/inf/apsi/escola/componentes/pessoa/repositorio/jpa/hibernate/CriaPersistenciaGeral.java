package br.ufg.inf.apsi.escola.componentes.pessoa.repositorio.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 * Classe definida para gerenciar a persistência das entidades do sistema.
 * @author gilmar
 *
 */
public class CriaPersistenciaGeral {
		/**
		 * atributo definido para representar a fábrica de gerenciadores de entidades
		 */
		private EntityManagerFactory emf = null;
		/**
		 * atributo definido para representar o gerenciador de entidade
		 */
		private EntityManager em = null;
		/**
		 * atributo definido para representar as transações utilizadas na interação com o repositório
		 */
		private EntityTransaction tx; 
		/**
		 * Construtor
		 */
		public CriaPersistenciaGeral(){
			emf = Persistence.createEntityManagerFactory("escola");
			em = emf.createEntityManager();
			tx = em.getTransaction();
		}
		/**
		 * Encerra a conexão.
		 */
		public void finaliza(){
			em.close();
			emf.close();	
		}

		/**
		 * obtem o gerenciador de entidades
		 * @return em
		 */
		public EntityManager getEm() {
			return em;
		}

		/**
		 * obtém a transação
		 * @return the tx
		 */
		public EntityTransaction getTx() {
			return tx;
		}
		
}


