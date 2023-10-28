package com.erudio.com.erudio.data.vo.v1;
import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false,of= {"id"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
}
