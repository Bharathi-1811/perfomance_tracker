package com.get.performance.tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;


@NamedQuery(name="Admin.findByZid",query= "select  a from Admin a where a.zid=:zid")

@Entity
@Table(name="admin")
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String zid;
	
	private String name;
	
	private String password;
}
