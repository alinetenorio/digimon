package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "digimon")
public class Digimon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String image;
	
	@Column
	private String level;
	
	@ManyToMany(mappedBy = "digimons")
	private List<Team> teams;
	
	public Digimon(String name, String image, String level) {
		this.name = name;
		this.image = image;
		this.level = level;
		this.teams = new ArrayList<>();
	}
	
	public Digimon() {}

	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	  this.id = id;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public String getImage() {
	    return image;
	}
	
	public void setImage(String image) {
	    this.image = image;
	}
	
	public String getLevel() {
	    return level;
	}
	
	public void setLevel(String level) {
	    this.level = level;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, image, level, name, teams);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Digimon other = (Digimon) obj;
		return id == other.id && Objects.equals(image, other.image) && Objects.equals(level, other.level)
				&& Objects.equals(name, other.name) && Objects.equals(teams, other.teams);
	}

}
