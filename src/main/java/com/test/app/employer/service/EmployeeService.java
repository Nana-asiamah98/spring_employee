package com.test.app.employer.service;

import java.util.List;
import java.util.stream.Collectors;

import com.test.app.employer.dao.EmployeeRepository;
import com.test.app.employer.dto.EmployeeDTO;
import com.test.app.employer.mapper.EmployeeMapper;
import com.test.app.employer.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements CRUDOperations<EmployeeDTO>{
	

	Logger logs = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employerRepo;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	
	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		Employee empModel = employeeMapper.toEntity(dto);
		return employeeMapper.toDto(employerRepo.save(empModel));
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		Employee empModel = employerRepo.findById(id);
		if(empModel != null) {
			logs.debug("Requested Data : ", empModel);
			employerRepo.deleteById(id);
		}
				
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) {
		logs.debug("Requested Data : ", dto);
		
		if(dto != null) {
			Employee empModel = employeeMapper.toEntity(dto);
			empModel.setId(dto.getId());
			empModel = employerRepo.save(empModel);
			return employeeMapper.toDto(empModel);

		}
		return null;
	}

	@Override
	public EmployeeDTO findById(long id) {
		// TODO Auto-generated method stub
		Employee empModel = employerRepo.findById(id);
		logs.debug("Requested Data : ", empModel);
		if(empModel != null) {
			return employeeMapper.toDto(empModel);
		}
		return null;
	}

	@Override
	public List<EmployeeDTO> getAll() {
		// TODO Auto-generated method stub
		List<Employee> listModel = employerRepo.findAll();
		return listModel.stream().map(employer -> employeeMapper.toDto(employer)).collect(Collectors.toList());
	}

}
