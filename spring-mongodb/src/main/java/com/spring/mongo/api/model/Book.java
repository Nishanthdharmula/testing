package com.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Book")
public class Book {
	
	@Transient
	public static final String sequenceName="userSequence";
	
	@Id
	private int id;
	private String depName;
	private String managerName;

	
	public Book(int id, String depName, String managerName) { 
		this.id = id;
		this.depName = depName; this.managerName = managerName;
	}

	public int getId() { return id; } public void setId(int id) { this.id = id; }
	public String getdepName() { 
		return depName; 
	} 
	public void setdepName(String depName) { 
		this.depName = depName; 
	} 
	public String getmanagerName() { return
			managerName; 
	} 
	public void setmanagerName(String managerName) {
		this.managerName = managerName; 
	}

}
