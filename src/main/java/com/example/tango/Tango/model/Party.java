package com.example.tango.Tango.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonSerialize
public class Party implements Serializable{

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Party() {
		
	}
	public Party(Long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	
}
