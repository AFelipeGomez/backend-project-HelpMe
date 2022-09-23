package com.HelpMe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.Status;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.IStatusRepo;
import com.HelpMe.service.IStatusService;


@Service
public class StatusServiceImpl implements IStatusService {

	@Autowired
	private IStatusRepo repo;

	@Override
	public Page<Status> getPaginated(int page, int size) {

		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Status> getPaginated(Pageable page) {
		
		return repo.findAll(page);
	}

	
	@Override
	public Status getById(Integer idStatus) throws ModelNotFoundException {
		
		Status status;
		if(repo.existsById(idStatus)) {
			status=repo.getById(idStatus);
		}else {
			throw new ModelNotFoundException("Status no encontrado");
		}
		
		return status;
	}

	@Override
	public void save(Status status) throws ConflictException {

		if (repo.existsByName(status.getName())) {
			throw new ConflictException("Status ya existe");
		} else {
			repo.save(status);
		}

	}

	@Override
	public void update(Status status) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {

		if (repo.existsById(status.getId())) {

			repo.save(status);

		} else {
			throw new ModelNotFoundException("Status no encontrado");
		}

	}

	@Override
	public void delete(int idStatus) throws ModelNotFoundException {

		if (repo.existsById(idStatus)) {
			repo.deleteById(idStatus);
		} else {
			throw new ModelNotFoundException("Status no encontrado");
		}

	}

	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
