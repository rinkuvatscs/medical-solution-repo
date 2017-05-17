package com.aaspaasdoctor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="expertise")
public class Expertise {

	
	public Expertise() {
	 super();	
	}
	
	public Expertise(String expertise) {
		this.expertise = expertise ;
		this.approved = 0 ;
		
	}
	
	public Expertise(Integer expertiseId) {
		this.expertiseId = expertiseId ;
	}
	
	@Id
	@Column(name = "expertise_id")
	private Integer expertiseId;
	
	
	@Column(name ="search_tags")
	private String searchTags;
	
	private String expertise ;
	
	
	private Integer approved ;


	public Integer getExpertiseId() {
		return expertiseId;
	}


	public void setExpertiseId(Integer expertiseId) {
		this.expertiseId = expertiseId;
	}


	public String getSearchTags() {
		return searchTags;
	}


	public void setSearchTags(String searchTags) {
		this.searchTags = searchTags;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public Integer getApproved() {
		return approved;
	}


	public void setApproved(Integer approved) {
		this.approved = approved;
	}
	
}
