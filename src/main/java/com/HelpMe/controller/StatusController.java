package com.HelpMe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelpMe.entity.Status;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.IStatusService;

@RequestMapping("/status")
@RestController
@Validated

public class StatusController {

	@Autowired
	private IStatusService service;

	@GetMapping(value = "/getPaginated/{page}/{size}", produces = "application/json")
	public ResponseEntity<?> retonarPaginado(@PathVariable int page, @PathVariable int size) {
		Page<Status> listaStatus = service.getPaginated(page, size);
		return new ResponseEntity<Page<Status>>(listaStatus, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{id}", produces = "aplication/json")
	public ResponseEntity<?> obtenerById(@PathVariable int id) throws ModelNotFoundException, Exception {
		Status status = service.getById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody Status status) throws ConflictException {
		service.save(status);
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}

	@PutMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody Status status) throws ModelNotFoundException, Exception {
		service.update(status);
		return new ResponseEntity<Object>(status, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{idStatus}")
	public ResponseEntity<?> delete(@PathVariable Integer idStatus) throws ModelNotFoundException {
		service.delete(idStatus);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
