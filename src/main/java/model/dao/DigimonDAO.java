package model.dao;

import database.Connection;

import java.util.List;

import javax.persistence.EntityManager;
import model.entity.Digimon;

public class DigimonDAO {
	private EntityManager entityManager;
	
	public DigimonDAO() {
		this.entityManager = Connection.getEntityManager();
	}
	
	public Digimon find(int id) {
		Digimon digimon = this.entityManager.find(Digimon.class, id);		
		//Connection.closeConnection();
		
        return digimon;
	}
	
	public List<Digimon> findAll() {
		return this.entityManager.createQuery("SELECT d FROM Digimon d", Digimon.class).getResultList();
	}
	
}
