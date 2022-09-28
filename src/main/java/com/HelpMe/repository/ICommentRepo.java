package com.HelpMe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Comment;
import com.HelpMe.entity.Ticket;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Integer>{

	
	
	
	  @Query(value =
	  "SELECT * FROM comment where id_ticket =:idTicket"
	  ,nativeQuery = true) 
	  List<Comment> findAllByIdTicket(@Param("idTicket")
	  Integer idTicket);
	 
	 
	 
}
