package com.HelpMe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.Rol;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.IRolRepo;
import com.HelpMe.service.IRolService;

@Service
public class RolService  implements IRolService{

	@Autowired
	private IRolRepo repo;
	
	@Override
	public List<Rol> getAll() {
		return repo.findAll();
	}

	@Override
	public Page<Rol> getPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Rol> getPaginated(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol getById(Integer idT) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Rol t) throws ConflictException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Rol t) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idT) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
