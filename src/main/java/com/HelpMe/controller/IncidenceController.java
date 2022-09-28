package com.HelpMe.controller;

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

import com.HelpMe.entity.FrecuentIncidence;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.IIncidenceService;
@CrossOrigin("*")
@RequestMapping("/incidence")
@RestController
@Validated
public class IncidenceController {

	@Autowired
	private IIncidenceService service;
	
	@GetMapping(value = "/getPaginated/{page}/{size}", produces = "application/json")
	public ResponseEntity<?> retonarPaginado(@PathVariable int page, @PathVariable int size) {
		Page<FrecuentIncidence> listaIncidence = service.getPaginated(page, size);
		return new ResponseEntity<Page<FrecuentIncidence>>(listaIncidence, HttpStatus.OK);
	}

	@GetMapping(value = "/getPaginated", produces = "application/json")
	public ResponseEntity<?> getPaginated(Pageable page) {
		Page<FrecuentIncidence> listaIncidence = service.getPaginated(page);
		return new ResponseEntity<Page<FrecuentIncidence>>(listaIncidence, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerById(@PathVariable int id) throws ModelNotFoundException, Exception {
		FrecuentIncidence incidence = service.getById(id);

		return new ResponseEntity<>(incidence, HttpStatus.OK);

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
	public ResponseEntity<?> save(@Valid @RequestBody FrecuentIncidence incidence) throws ConflictException {

		service.save(incidence);

		return new ResponseEntity<Object>(incidence, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody FrecuentIncidence incidence) throws ModelNotFoundException, Exception {
		service.update(incidence);

		return new ResponseEntity<Object>(incidence, HttpStatus.OK);
	}

	// 204
	@DeleteMapping(value = "/delete/{idIncidence}")
	public ResponseEntity<?> delete(@PathVariable Integer idIncidence) throws ModelNotFoundException, ConflictException {
		System.out.print("antes de usar servixe");
		service.delete(idIncidence);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
