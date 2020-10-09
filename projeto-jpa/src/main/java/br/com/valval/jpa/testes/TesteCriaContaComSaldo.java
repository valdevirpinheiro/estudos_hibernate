package br.com.valval.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.valval.jpa.modelo.Conta;

public class TesteCriaContaComSaldo {
	 public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	        EntityManager em = emf.createEntityManager();

	        Conta conta = new Conta();
	        conta.setTitular("Leonardo");
	        conta.setNumero(12345);
	        conta.setAgencia(54321);
	        conta.setSaldo(500.0);

	        em.getTransaction().begin();

	        em.persist(conta);

	        em.getTransaction().commit();
	    }
}
