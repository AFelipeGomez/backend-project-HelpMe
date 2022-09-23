package com.HelpMe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.Priority;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.IPriorityRepo;
import com.HelpMe.service.IPriorityService;

@Service
public class PriorityServiceImpl implements IPriorityService {

	@Autowired
	private IPriorityRepo repo;

	@Override
	public Page<Priority> getPaginated(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Priority> getPaginated(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Priority getById(Integer idT) throws ModelNotFoundException {
		return repo.findById(idT).orElseThrow(() -> new ModelNotFoundException("Prioridad no encontrado"));
	}

	@Override
	public void save(Priority t) throws ConflictException {
		repo.save(t);
		
	}

	@Override
	public void update(Priority t) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		repo.save(t);
		
	}

	@Override
	public void delete(int idT) throws ModelNotFoundException {
		repo.deleteById(idT);
		
	}

	@Override
	public List<Priority> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
