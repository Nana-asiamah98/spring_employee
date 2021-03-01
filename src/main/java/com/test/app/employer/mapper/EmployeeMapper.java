package com.test.app.employer.mapper;

import org.springframework.stereotype.Component;

import com.test.app.employer.dto.EmployeeDTO;
import com.test.app.employer.model.Employee;

@Component
public class EmployeeMapper {

	public Employee toEntity(EmployeeDTO dto) {
		Employee model = null;
		if(dto != null) {
			model = new Employee(
					dto.getId(),
					dto.getFirstName(),
					dto.getLastName(),
					dto.getEmail(),
					dto.getRole(),
					dto.getPhone(),
					dto.getCreatedAt(),
					dto.getCreatedAt()
					);
			return model;
		}
		return model;
	}
	
	public EmployeeDTO toDto(Employee model) {
		EmployeeDTO dto = null;
		if(model != null) {
			dto = new EmployeeDTO(
					model.getId(),
					model.getFirstName(),
					model.getLastName(),
					model.getEmail(),
					model.getRole(),
					model.getPhone(),
					model.getCreatedAt(),
					model.getCreatedAt()
					);
			return dto;
		}
		return dto;
	}
}
