package org.datanucleus.test;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.datanucleus.util.NucleusLogger;
import org.junit.Test;

import app.domain.model.Person;

public class SimpleTest {
	@Test
	public void testSimple() {
		NucleusLogger.GENERAL.info(">> test START");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MyTest");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Person person = new Person();
			em.persist(person);

			tx.commit();
		} catch (Throwable thr) {
			NucleusLogger.GENERAL.error(">> Exception thrown persisting data",
					thr);
			fail("Failed to persist data : " + thr.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}

		emf.close();
		NucleusLogger.GENERAL.info(">> test END");
	}
}
