package com.greatlearning.ticket.service;

import java.util.List;

import com.greatlearning.ticket.entity.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();
	
	public void saveTicket(Ticket ticket);
	
	public Ticket getTicketById(Long id);
	
	public Ticket updateTicket(Ticket ticket);
	
	List<Ticket> searchTickets(String keyword);

	public void deleteTicketById(Long id);
}
