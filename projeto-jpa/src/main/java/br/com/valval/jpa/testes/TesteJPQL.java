package br.com.valval.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.valval.jpa.modelo.Conta;
import br.com.valval.jpa.modelo.Movimentacao;

public class TesteJPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		//Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}