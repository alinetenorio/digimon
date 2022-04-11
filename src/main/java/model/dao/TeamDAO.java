package model.dao;

import database.Connection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;

import model.entity.Digimon;
import model.entity.Player;
import model.entity.Team;
import model.entity.TeamDigimon;

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
	
	public Team insert(Team team) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(team);
		this.entityManager.getTransaction().commit();
		//Connection.closeConnection();
		return team;
	}
	
	public void remove(int id) {
		Team team = find(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(team);
		this.entityManager.getTransaction().commit();
		//Connection.closeConnection();
	}
	
	public Team edit(int id, String name) {
		Team team = find(id);
		team.setName(name);
	
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(team);
		this.entityManager.getTransaction().commit();
		
		return team;
	}
	
	public void removeTeamDigimon(int teamId, int digimonId) {
		
		try {			
			this.entityManager.getTransaction().begin();
			
			Query query = this.entityManager.createQuery("DELETE FROM TeamDigimon WHERE"
					+ " team_id = :teamId and digimon_id = :digimonId");
			query.setParameter("teamId", teamId);
			query.setParameter("digimonId", digimonId);
			
			query.executeUpdate();		
			
			this.entityManager.getTransaction().commit();
		} catch (NoResultException e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		} finally {
			//Connection.closeConnection();
		}
        
	}
	
	public void addTeamDigimon(Team team, Digimon digimon, int level) {
		TeamDigimon teamDigimon = new TeamDigimon(team, digimon, level);
		try {			
			try {
				this.entityManager.getTransaction().begin();
				this.entityManager.persist(teamDigimon);								
				this.entityManager.getTransaction().commit();
				//Connection.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				this.entityManager.getTransaction().rollback();
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		} finally {
			//Connection.closeConnection();
		}
        
	}
}
