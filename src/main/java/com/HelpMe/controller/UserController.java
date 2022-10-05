package com.HelpMe.controller;

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

import com.HelpMe.entity.User;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.IUserService;
@CrossOrigin("*")
@RequestMapping("/user")
@RestController
@Validated
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping(value = "/getPaginated/{page}/{size}", produces = "application/json")
	public ResponseEntity<?> getPaginated(@PathVariable int page, @PathVariable int size) {
		Page<User> listaUser = service.getPaginated(page, size);
		return new ResponseEntity<Page<User>>(listaUser, HttpStatus.OK);
	}

	@GetMapping(value = "/getPaginated", produces = "application/json")
	public ResponseEntity<?> getPaginated(Pageable page) {
		Page<User> listaUser = service.getPaginated(page);
		return new ResponseEntity<Page<User>>(listaUser, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{id}", produces = "application/json")
	public ResponseEntity<?> getById(@PathVariable int id) throws ModelNotFoundException, Exception {
		User user = service.getById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getByDocument/{document}", produces = "application/json")
	public ResponseEntity<?> getByDocument(@PathVariable String document) throws ModelNotFoundException, Exception {
		User user = service.getByDocument(document);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	/*
	 * @GetMapping(value = "/obtenerByIdDetalle/{id}/{detalle}", produces =
	 * "application/json") public ResponseEntity<?>
	 * obtenerByIdByDetalle(@PathVariable int id, @PathVariable boolean detalle)
	 * throws ModelNotFoundException, Exception { User user =
	 * service.retornarPorIdDetalle(id, detalle);
	 * 
	 * return new ResponseEntity<>(user, HttpStatus.OK);
	 * 
	 * }
	 */

	
	  @GetMapping(value = "/all", produces =
	  "application/json") public ResponseEntity<?>
	  obtenerByIdByDetalle()
	  throws ModelNotFoundException, Exception { 
	  List<User> listUser=service.getAll();	  
	  return new ResponseEntity<>(listUser, HttpStatus.OK);
	  
	  }
	 
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody User user) throws ConflictException {

		service.save(user);

		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody User user) throws ModelNotFoundException, Exception {
		service.update(user);

		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	// 204
	@DeleteMapping(value = "/delete/{idUser}")
	public ResponseEntity<?> delete(@PathVariable Integer idUser) throws ModelNotFoundException, ConflictException {
		
		service.delete(idUser);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
