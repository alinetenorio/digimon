package model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
  // private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String image;
	
	@OneToOne
    @JoinColumn(name="player_id", nullable=false)
	private Player player;
	
	@ManyToMany
	@JoinTable(
	        name = "team_digimon", 
	        joinColumns = { @JoinColumn(name = "team_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "digimon_id") }
	)
	private List<Digimon> digimons;
	
	public Team(String name, Player player) {
		this.name = name;
		this.player = player;
		this.digimons = new ArrayList<>();		
		this.image = "https://i.pinimg.com/564x/59/b2/43/59b243e179f083e8d6420bd4b8816498.jpg";
	}
	
	public Team() {}

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

public List<Digimon> getDigimons() {
    return digimons;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Team other = (Team) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  
}
