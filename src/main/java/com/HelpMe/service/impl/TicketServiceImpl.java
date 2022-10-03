package com.HelpMe.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HelpMe.entity.Ticket;
import com.HelpMe.exception.ArgumentRequiredException;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.repository.ITicketRepo;
import com.HelpMe.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {

	@Autowired
	private ITicketRepo repo;

	@Override
	public Page<Ticket> getPaginated(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public Page<Ticket> getPaginated(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Ticket getById(Integer idT) throws ModelNotFoundException {
		return repo.findById(idT).orElseThrow(() -> new ModelNotFoundException("Ticket no encontrado"));
	}

	@Override
	public void save(Ticket t) throws ConflictException {
		this.repo.save(t);

	}

	@Override
	public void update(Ticket t) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		this.repo.save(t);

	}

	@Override
	public void delete(int idT) throws ModelNotFoundException {
		this.repo.deleteById(idT);

	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int asignarPriority(int severidad, int impacto) {

		int prioridad = 0;

		if (severidad == 1 && impacto == 1) {
			prioridad = 4;
		} else if ((severidad == 1 && impacto == 2) || (severidad == 3 && impacto == 3)) {
			prioridad = 4;
		} else if (severidad == 1 && impacto == 3) {
			prioridad = 3;

		} else if (severidad == 2 && impacto == 1) {
			prioridad = 4;
		} else if (severidad == 2 && impacto == 2) {
			prioridad = 3;
		} else if (severidad == 2 && impacto == 3) {
			prioridad = 2;
		} else if (severidad == 3 && impacto == 1) {
			prioridad = 3;
		} else if (severidad == 3 && impacto == 2) {
			prioridad = 2;
		} else {
			prioridad = 1;

		}
		
		return prioridad;
	}

	public List<Ticket> getDate(String dateInicial, String dateFinal){
		 SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
	        Date a= new Date();
	        Date b=new Date();
	        
            try {
            	a = parser.parse(dateInicial);
				b = parser.parse(dateFinal);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return repo.findAllByActualDateAfterAndActualDateBefore(a, b);
	}
	
	public List<Object[]> getByPriority(Integer idPriority){
		return repo.ticketByPriority(idPriority);
	}
	
	public List<Object[]> getByStatus(Integer idStatus){
		return repo.ticketByStatus(idStatus);
	}


}

