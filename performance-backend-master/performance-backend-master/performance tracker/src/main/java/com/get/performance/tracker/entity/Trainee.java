package com.get.performance.tracker.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name="Trainee.findByEmailId",query= "select  t from Trainee t where t.email=:email")
@NamedQuery(name="Trainee.findByZid",query= "select  t from Trainee t where t.zid=:zid")

@NamedQuery(name="Trainee.updateSignupForm",query="update Trainee t set t.name=:name, t.mobileNumber=:mobileNumber,t.password=:password,t.gender=:gender where t.zid=:zid")

@NamedQuery(name="Trainee.getTraineeEmail",query="select email from Trainee t where t.zid=:zid")

@NamedQuery(name="Trainee.updateTraineeStatus",query="update Trainee t set t.status=:status where t.zid=:zid")


@Entity
@Table(name = "signuptrainee")
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data public class Trainee { //implements UserDetails
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	
	@Column(name = "Zid")
	private String zid;
	
	@Column(name = "Name") 
	private String name;
	
	@Column(name = "Gender",length=10)
	private String gender;
	
	@Column(name = "Email")
	private String email; 
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "MobileNumber",length=10)
	private String mobileNumber;
	
	@Column(name="status")
	private String status;
	
	@Column(name="batchDate",length=18)
	private String batch;
	
	
	
	//
	
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		return List.of(new SimpleGrantedAuthority(getZid()));
//	}
//
//	@Override
//	public String getUsername() {
//		
//		return getZid();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		
//		return false;
//	}
//
	
	
	
	
	
}
