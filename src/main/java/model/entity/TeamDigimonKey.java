package model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamDigimonKey implements Serializable {

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "digimon_id")
    private int digimonId;

    public TeamDigimonKey() {}
    
    public TeamDigimonKey(int teamId, int digimonId) {
    	this.teamId = teamId;
    	this.digimonId = digimonId;
    }

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getDigimonId() {
		return digimonId;
	}

	public void setDigimonId(int digimonId) {
		this.digimonId = digimonId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digimonId, teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamDigimonKey other = (TeamDigimonKey) obj;
		return digimonId == other.digimonId && teamId == other.teamId;
	}
    
}