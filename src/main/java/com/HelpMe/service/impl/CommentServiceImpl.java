package com.HelpMe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.Comment;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.ICommentRepo;
import com.HelpMe.repository.ITicketRepo;
import com.HelpMe.repository.IUserRepo;
import com.HelpMe.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentRepo repo;
	
	@Autowired
	private ITicketRepo repoTicket;
	
	@Autowired
	private IUserRepo repoUser;
	
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Comment> getPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Comment> getPaginated(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Comment> getListById(Integer idT){
		
		return  repo.findAllByIdTicket(idT);
		
		
	}

	@Override
	public Comment getById(Integer idT) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Comment t) throws ConflictException {
		
		if(!repoTicket.existsById(t.getTicket().getId())){
			throw new ConflictException("Ticket no existe");
		}else if(!repoUser.existsById(t.getUser().getId())){
			throw new ConflictException("Usuario no existe");
		}else {
			repo.save(t);
		}
		
	}

	@Override
	public void update(Comment t) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		
		if(!repo.existsById(t.getId())) {
			throw new ConflictException("Comentario no existe");
		}else {
			repo.save(t);
		}
		
	}

	@Override
	public void delete(int idT) throws ModelNotFoundException, ConflictException {
		
		if(!repo.existsById(idT)){
			throw new ConflictException("Comentario no existe");
		}else {
			repo.deleteById(idT);
		}
		
	}

}
