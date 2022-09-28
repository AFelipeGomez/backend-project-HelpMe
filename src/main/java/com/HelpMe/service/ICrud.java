package com.HelpMe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;



public interface ICrud <T, ID> {
	
	public List<T> getAll ();
	
	public Page<T> getPaginated(int page, int size);

	public Page<T> getPaginated(Pageable page);

	public T getById(ID idT) throws ModelNotFoundException;

	public void save(T t) throws ConflictException;

	public void update(T t) throws ArgumentRequiredException, ModelNotFoundException, ConflictException;

	public void delete(int idT) throws ModelNotFoundException, ConflictException;
	


}
