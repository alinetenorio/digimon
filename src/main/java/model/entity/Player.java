package model.entity;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "player")
public class Player {
	// private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private double points;
	
	@OnDelete( action = OnDeleteAction.CASCADE )
	@OneToOne(mappedBy="player")
	private Team team;
	
	public Player(String name, String email) {
		this.name = name;
		this.email = email;
		this.points = 0;
		this.team = null;
	}
	
	public Player(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.points = 0;
		this.team = null;
	}
	
	public Player() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(email, other.email);
	}
	
}
