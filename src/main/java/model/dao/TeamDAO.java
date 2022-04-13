package model.dao;

import database.Connection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.entity.Digimon;
import model.entity.Team;
import model.entity.TeamDigimon;
import model.entity.TeamDigimonKey;

public class TeamDAO {
	private EntityManager entityManager;
	
	public TeamDAO() {
		this.entityManager = Connection.getEntityManager();
	}
	
	public Team find(int id) {
		Team team = this.entityManager.find(Team.class, id);		
		
		return team;
	}
	
	public Team insert(Team team) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(team);
		this.entityManager.getTransaction().commit();
		return team;
	}
	
	public void remove(int id) {
		Team team = find(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(team);
		this.entityManager.getTransaction().commit();
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
		} 
        
	}
	
	public void addTeamDigimon(Team team, Digimon digimon, int level) {
		TeamDigimon teamDigimon = new TeamDigimon(team, digimon, level);
		try {			
			try {
				this.entityManager.getTransaction().begin();
				this.entityManager.persist(teamDigimon);								
				this.entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				this.entityManager.getTransaction().rollback();
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
        
	}
	
	public TeamDigimon getTeamDigimon(int teamId, int digimonId) {
		return this.entityManager.find(TeamDigimon.class, new TeamDigimonKey(teamId, digimonId));		
	}
	
	public void nextLevel(int teamId, int digimonId) {
		TeamDigimon td = this.entityManager.find(TeamDigimon.class, new TeamDigimonKey(teamId, digimonId));	
		td.setLevel(td.getLevel()+1);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(td);
		this.entityManager.getTransaction().commit();
	}
}
