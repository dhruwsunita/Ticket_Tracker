package com.greatlearning.ticket.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.repository.TicketRepository;
import com.greatlearning.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		Optional<Ticket> result = ticketRepository.findById(id);

		Ticket theTicket = null;

		if (result.isPresent()) {
			theTicket = result.get();
		} else {
			// ticket not found
			throw new RuntimeException("Did not find ticket id - " + id);
		}

		return theTicket;
	}
	
	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);
	}
	
	@Override
	public List<Ticket> searchTickets(String keyword) {
		if(keyword != null) {
			return ticketRepository.search(keyword);
		}else {
			return (List<Ticket>)ticketRepository.findAll();
		}
	}

}
