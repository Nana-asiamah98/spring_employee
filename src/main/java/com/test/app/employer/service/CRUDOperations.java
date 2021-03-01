package com.test.app.employer.service;

import java.util.List;

public interface CRUDOperations<DTO> {

	public DTO save(DTO dto);
	public void deleteById(long id);
	public DTO update(DTO dto);
	public DTO findById(long id);
	public List<DTO> getAll();
	
}
