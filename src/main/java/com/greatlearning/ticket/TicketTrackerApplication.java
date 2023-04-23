package com.greatlearning.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.repository.TicketRepository;

@SpringBootApplication
public class TicketTrackerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
	}
	
	@Autowired
	private TicketRepository ticketRepository; 

	@Override
	public void run(String... args) throws Exception {
		
//		Ticket ticket1 = new Ticket("ticket1", "ticket description 1", , "Confirmed");
//     	ticketRepository.save(ticket1);
	}

}
