package com.HelpMe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.HelpMe.entity.Comment;
import com.HelpMe.entity.Ticket;
import com.HelpMe.exception.ConflictException;
import com.HelpMe.exception.ModelNotFoundException;
import com.HelpMe.service.ICommentService;
@CrossOrigin("*")
@Validated
@RequestMapping("/comment")
@RestController
public class CommentController {

	
	@Autowired
	private ICommentService service;
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody Comment comment) throws ConflictException {

		service.save(comment);

		return new ResponseEntity<Object>(comment, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getListById/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerListById(@PathVariable int id) throws ModelNotFoundException, Exception {
		List<Comment>listComment = service.getListById(id);

		return new ResponseEntity<>(listComment, HttpStatus.OK);

	}
	

	@PutMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody Comment comment) throws ModelNotFoundException, Exception {
		service.update(comment);

		return new ResponseEntity<Object>(comment, HttpStatus.OK);
	}

	// 204
	@DeleteMapping(value = "/delete/{idComment}")
	public ResponseEntity<?> delete(@PathVariable Integer idComment) throws ModelNotFoundException, ConflictException {
		System.out.print("antes de usar servixe");
		service.delete(idComment);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
