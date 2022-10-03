package com.HelpMe.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Ticket;


@Repository
public interface ITicketRepo extends JpaRepository<Ticket,Integer> {

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE ticket SET(id_status) VALUES(:idStatus)  where id= :idTicket"
				,nativeQuery = true)
	void actualziarStatus(@Param("idTicket") Integer idTicket, @Param("idStatus") Integer idStatus);
	
	
	
	@Query(value=
			"SELECT ticket.id,ticket.actual_date,ticket.description,ticket.observation,ticket.qualification,ticket.answer"
			+ ",priority.name AS prioridad,status.name AS status FROM ticket "
			+ "INNER JOIN priority "
			+ "ON ticket.id_priority=priority.id "
			+ "INNER JOIN status "
			+ "ON ticket.id_status = status.id "
			+ "where ticket.id_priority= :idPriority"
			, nativeQuery=true) List<Object[]> ticketByPriority(@Param("idPriority") Integer idPriority);
			
			

		@Query(value=
				"SELECT ticket.id,ticket.actual_date,ticket.description,ticket.observation,ticket.qualification,ticket.answer"
				+ ",priority.name AS prioridad,status.name AS status FROM ticket "
				+ "INNER JOIN priority "
				+ "ON ticket.id_priority=priority.id "
				+ "INNER JOIN status "
				+ "ON ticket.id_status = status.id "
				+ "where ticket.id_status= :idStatus"
				, nativeQuery=true) List<Object[]> ticketByStatus(@Param("idStatus") Integer idStatus);
	
	
	 
	 
	
	 public List<Ticket> findAllByActualDateAfterAndActualDateBefore(Date dateInicial,Date dateFinal);
	 
	 
	 
	
}
