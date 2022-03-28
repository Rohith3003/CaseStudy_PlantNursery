package com.cs.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class EndUser{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String emailId;
	@Column(unique = true)
	private String mobileNumber;
	private String fullName;
	private boolean isAdmin;
	
	
	@CreatedDate
	@Setter(AccessLevel.PROTECTED)
    Date createdAt;
    
	
    @LastModifiedDate
    @Setter(AccessLevel.PROTECTED)
    Date modifiedAt;	
    
}
