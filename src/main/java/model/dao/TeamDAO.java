package model.dao;

import database.Connection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;

import model.entity.Digimon;
import model.entity.Player;
import model.entity.Team;

public class TeamDAO {
	private EntityManager entityManager;
	
	public TeamDAO() {
		this.entityManager = Connection.getEntityManager();
	}
	
	public Team find(int id) {
		Team team = this.entityManager.find(Team.class, id);		
		//Connection.closeConnection();
		
		return team;
	}
	
	public void insert(Team team) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(team);
		this.entityManager.getTransaction().commit();
		Connection.closeConnection();
	}
	
	public void remove(int id) {
		Team team = find(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(team);
		this.entityManager.getTransaction().commit();
		//Connection.closeConnection();
	}
	
	public void edit(int id, String name) {
		Team team = new Team();
		team.setId(id);
		team.setName(name);
	
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(team);
		this.entityManager.getTransaction().commit();
		
		Connection.closeConnection();
	}
	
	public void setDigimons(Team team) {
		removeTeamDigimon(team.getId());	
		for(Digimon d : team.getDigimons()) {
			addTeamDigimon(team.getId(), d.getId());
		}		
	}
	
	public void removeTeamDigimon(int teamId) {
		
		try {			
			Query query = this.entityManager.createQuery("DELETE FROM team_digimon WHERE team_id = :teamId");
			query.setParameter("teamId", teamId);			
			
			query.executeUpdate();			
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			//Connection.closeConnection();
		}
        
	}
	
	public void addTeamDigimon(int teamId, int digimonId) {
		
		try {			
			Query query = this.entityManager.createQuery("INSERT INTO team_digimon VALUES(:teamId, :digimonId");
			query.setParameter("teamId", teamId);			
			query.setParameter("digimonId", digimonId);			
			
			query.executeUpdate();			
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			//Connection.closeConnection();
		}
        
	}
}
