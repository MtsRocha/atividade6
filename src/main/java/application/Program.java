package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import atividadecinco.Automovel;
import atividadecinco.Marca;
import atividadecinco.Modelo;

public class Program {

	public static void main(String[] args) throws ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadecinco");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Automovel a1 = new Automovel(null, 2012, 2013, "Muito bom",(float) 500, 10000);

		Modelo m1 = new Modelo(null, "Quadrado", 1000);
		
		Marca mc1 =new Marca(null, "Honda");
		
		mc1.addModelos(m1);
		m1.addAutomovel(a1);
		
		em.persist(a1);
		em.persist(m1);
		em.persist(mc1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
