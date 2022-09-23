package com.HelpMe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.FrecuentIncidence;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.IIncidenceRepo;
import com.HelpMe.service.IIncidenceService;

@Service
public class IncidenceServiceImpl implements IIncidenceService{

	@Autowired
	private IIncidenceRepo repo;
	
	@Override
	public Page<FrecuentIncidence> getPaginated(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<FrecuentIncidence> getPaginated(Pageable page) {
		return repo.findAll(page);
	}

	public FrecuentIncidence retornarPorIdDetalle(Integer idIncidence) throws ModelNotFoundException {

		FrecuentIncidence incidence = repo.findById(idIncidence).orElseThrow(() -> new ModelNotFoundException("Incidencia no encontrado"));

		return incidence;
	}

	@Override
	public FrecuentIncidence getById(Integer idIncidence) throws ModelNotFoundException {

		return repo.findById(idIncidence).orElseThrow(() -> new ModelNotFoundException("User no encontrado"));

	}

	@Override
	public void save(FrecuentIncidence incidence) throws ConflictException {
		 
		
		this.repo.save(incidence);

	}

	@Override
	public void update(FrecuentIncidence incidence) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {

		if (validarExistenciaPorId(incidence.getId())) {
			System.out.print("Entro if existe id");
			repo.save(incidence);

		} else {
			throw new ModelNotFoundException("Incidencia no encontrado");
		}

	}

	@Override
	public void delete(int idIncidence) throws ModelNotFoundException {

		System.out.print("id"+idIncidence);
		if (validarExistenciaPorId(idIncidence)) {
			System.out.print("Valido y id si existe");
			this.repo.deleteById(idIncidence);
		} else {
			throw new ModelNotFoundException("Incidencia no encontrado");
		}
	}

	private Boolean validarExistenciaPorId(int idIncidence) {

		System.out.print(idIncidence);
		return repo.existsById(idIncidence);
	}

	@Override
	public List<FrecuentIncidence> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
