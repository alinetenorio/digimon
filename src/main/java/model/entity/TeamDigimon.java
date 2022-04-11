package model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "team_digimon")
public class TeamDigimon {

    @EmbeddedId
    private TeamDigimonKey id;

    @ManyToOne
    @MapsId("teamId")
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @MapsId("digimonId")
    @JoinColumn(name = "digimon_id")
    private Digimon digimon;

    @Column
    private int level;
    
    public TeamDigimon() {}
    
    public TeamDigimon(Team team, Digimon digimon, int level) {
    	this.id = new TeamDigimonKey(team.getId(), digimon.getId());
    	this.team = team;
    	this.digimon = digimon;
    	this.level = level;
    }

	public TeamDigimonKey getId() {
		return id;
	}

	public void setId(TeamDigimonKey id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Digimon getDigimon() {
		return digimon;
	}

	public void setDigimon(Digimon digimon) {
		this.digimon = digimon;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
    
}