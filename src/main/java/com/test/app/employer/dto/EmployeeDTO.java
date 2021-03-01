package com.test.app.employer.dto;


import java.time.LocalDateTime;

import com.test.app.employer.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


	private Long id;
	
	private String firstName;
	
	private String lastName;

	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String phone;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
