package com.erudio.com.erudio.data.vo.v2;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false,of= {"id"})
public class PersonVOV2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private Date birthday;
}
