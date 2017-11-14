package persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Cliente;

public class ClienteDao {


	EntityManager em;
	EntityTransaction transaction;

	public ClienteDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AJAX");
		em = factory.createEntityManager();
	}

	public void create(Cliente c) throws Exception {
		transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		transaction.commit();
	}

	public void update(Cliente c) throws Exception {
		transaction = em.getTransaction();
		transaction.begin();
		em.merge(c);
		transaction.commit();
	}

	public void delete(Cliente c) {
		transaction = em.getTransaction();
		transaction.begin();
		   em.remove( em.getReference(Cliente.class, c.getIdCliente()));
		transaction.commit();

	}

	public List<Cliente> findAll() {
		List<Cliente> lista = em.createQuery("select obj from Cliente as obj").getResultList();
		return lista;
	}

	
	public Cliente findByCode(Integer cod) {
		Query q = em.
			createQuery("select c from Cliente as c where  c.idCliente= :param1 ");
		           q.setParameter("param1", cod);
		Cliente c = (Cliente) q.getSingleResult();
		return c;
	}
	
	
	public static void main(String[] args) {
		try{
//			Cliente c1 = new Cliente(null,"bruno","bruno@soneca.com", new Date("01/10/1950"));
//			Cliente c2 = new Cliente(null,"thalita","thalita@tata.com", new Date("10/10/1997"));
//			Cliente c3 = new Cliente(null,"lion","lion@tata.com", new Date("14/12/1997"));			
//			
//			new ClienteDao().create(c1);
//			new ClienteDao().create(c2);
//			new ClienteDao().create(c3);
//			
//		 System.out.println("Dados gravados.... "+ c1 + ","+ c2 +"," +c3);
//		 
//		 new ClienteDao().create(new Cliente(null,"carlinho","carlinho@gmail", new Date(20/01/1995)));
//		 

		new ClienteDao().findAll().forEach(System.out::println);
//		
//		List<Cliente>cliente = new ClienteDao().findAll();
//		
//		System.out.println(cliente.toString());
		 
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
