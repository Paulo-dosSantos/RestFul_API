package com.erudio.com.erudio.entities;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false,of= {"id"})
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name",nullable = false,length=80)
	private String firstName;
	
	@Column(name="last_name",length=80)
	private String lastName;
	
	@Column(nullable=false, length=100)
	private String address;
	
	@Column(nullable=false, length=6)//Female
	private String gender;
}
