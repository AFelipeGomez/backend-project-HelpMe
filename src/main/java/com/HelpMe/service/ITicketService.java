package com.HelpMe.service;

import java.util.Date;
import java.util.List;

import com.HelpMe.entity.Ticket;

public interface ITicketService extends ICrud<Ticket, Integer> {

	
	public List<Ticket> getDate(String dateInicial, String dateFinal);
}
