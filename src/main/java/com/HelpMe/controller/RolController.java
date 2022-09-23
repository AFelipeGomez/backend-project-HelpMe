package com.HelpMe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelpMe.entity.Rol;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.IRolService;

@RequestMapping("/rol")
@RestController
@Validated
public class RolController {

	@Autowired
	private IRolService service;
	
	@GetMapping(value = "/all", produces =
			  "application/json") public ResponseEntity<?>
			  obtenerByIdByDetalle()
			  throws ModelNotFoundException, Exception { 
			  List<Rol> listRol=service.getAll();	  
			  return new ResponseEntity<>(listRol, HttpStatus.OK);
			  
			  }
	
}
