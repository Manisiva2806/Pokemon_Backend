package com.poke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Teams {
	
	@Id
	@Column(name="poke_id") 
	private int idd;
	private String poke_name;
	private String poke_img;
	private int poke_xp;
	private int id;
	
	
	public int getIdd() {
		return idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}

	public String getPoke_name() {
		return poke_name;
	}
	public void setPoke_name(String poke_name) {
		this.poke_name = poke_name;
	}
	public String getPoke_img() {
		return poke_img;
	}
	public void setPoke_img(String poke_img) {
		this.poke_img = poke_img;
	}
	public int getPoke_xp() {
		return poke_xp;
	}
	public void setPoke_xp(int poke_xp) {
		this.poke_xp = poke_xp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
