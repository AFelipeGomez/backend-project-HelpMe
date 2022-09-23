package com.HelpMe.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.HelpMe.entity.Ticket;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.ITicketService;
@CrossOrigin("*")
@RequestMapping("/ticket")
@RestController
@Validated
public class TicketController {
	
	@Autowired
	private ITicketService service;
	
	@GetMapping(value = "/getPaginated/{page}/{size}", produces = "application/json")
	public ResponseEntity<?> retonarPaginado(@PathVariable int page, @PathVariable int size) {
		Page<Ticket> listaTicket = service.getPaginated(page, size);
		return new ResponseEntity<Page<Ticket>>(listaTicket, HttpStatus.OK);
	}

	@GetMapping(value = "/getPaginated", produces = "application/json")
	public ResponseEntity<?> getPaginated(Pageable page) {
		Page<Ticket> listaTicket = service.getPaginated(page);
		return new ResponseEntity<Page<Ticket>>(listaTicket, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerById(@PathVariable int id) throws ModelNotFoundException, Exception {
		Ticket ticket = service.getById(id);

		return new ResponseEntity<>(ticket, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getByDates/{dateInicial}/{dateFinal}", produces = "application/json")
	public ResponseEntity<?> obtenerById(@PathVariable String dateInicial,@PathVariable String dateFinal) throws ModelNotFoundException, Exception {
		List<Ticket> listTicket = service.getDate(dateInicial, dateFinal);

		return new ResponseEntity<>(listTicket, HttpStatus.OK);

	}

	/*
	 * @GetMapping(value = "/obtenerByIdDetalle/{id}/{detalle}", produces =
	 * "application/json") public ResponseEntity<?>
	 * obtenerByIdByDetalle(@PathVariable int id, @PathVariable boolean detalle)
	 * throws ModelNotFoundException, Exception { FrecuentIncidence incidence =
	 * service.retornarPorIdDetalle(id, detalle);
	 * 
	 * return new ResponseEntity<>(incidence, HttpStatus.OK);
	 * 
	 * }
	 */

	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody Ticket ticket) throws ConflictException {

		service.save(ticket);

		return new ResponseEntity<Object>(ticket, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody Ticket ticket) throws ModelNotFoundException, Exception {
		service.update(ticket);

		return new ResponseEntity<Object>(ticket, HttpStatus.OK);
	}

	// 204
	@DeleteMapping(value = "/delete/{idIncidence}")
	public ResponseEntity<?> delete(@PathVariable Integer idTicket) throws ModelNotFoundException {
		System.out.print("antes de usar servixe");
		service.delete(idTicket);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	

}
