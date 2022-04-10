package model.dao;

import database.Connection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.entity.Player;

public class PlayerDAO {
	private EntityManager entityManager;
	
	public PlayerDAO() {
		this.entityManager = Connection.getEntityManager();
	}
	
	public Player find(int id) {
		Player player = this.entityManager.find(Player.class, id);		
		//Connection.closeConnection();
		
        return player;
	}
	
	public Player checkPassword(String email, String password) {
		
		Player player = null;
		try {
			Query query = this.entityManager.createQuery("FROM Player p where p.email = :email and"
					+ "	p.password = :password", Player.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			
			player = (Player) query.getSingleResult();			
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			Connection.closeConnection();
		}
        
        return player;
	}
	
	public void insert(Player player) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(player);
		this.entityManager.getTransaction().commit();
		//Connection.closeConnection();
	}
	
	public void remove(int id) {
		Player player = find(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(player);
		this.entityManager.getTransaction().commit();
		//Connection.closeConnection();
	}
	
	public void edit(int id, String name, String email, String password) {
		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setEmail(email);
		player.setPassword(password);
	
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(player);
		this.entityManager.getTransaction().commit();
		
		//Connection.closeConnection();
	}
	
}
