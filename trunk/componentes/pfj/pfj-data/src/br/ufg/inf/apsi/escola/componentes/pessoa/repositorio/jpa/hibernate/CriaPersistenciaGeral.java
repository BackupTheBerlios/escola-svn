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
		private EntityManagerFactory emf = null;
		private EntityManager em = null;
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
		 * @return
		 */
		public EntityManager getEm() {
			return em;
		}

		/**
		 * @return the tx
		 */
		public EntityTransaction getTx() {
			return tx;
		}
		
}


