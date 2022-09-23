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
	
	
	
	
	/*
	 * @Query(value =
	 * "SELECT * FROM ticket where actual_date BETWEEN = :dateInicial and :dateFinal "
	 * ,nativeQuery = true) List<Ticket> selectTiccketDate(@Param("dateInicial")
	 * Date dateInicial,@Param("dateFinal") Date dateFinal);
	 */
	
	 public List<Ticket> findAllByActualDateAfterAndActualDateBefore(Date dateInicial,Date dateFinal);
	 
	 
	 
	
}
