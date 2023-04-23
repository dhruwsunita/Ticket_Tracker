package com.greatlearning.ticket.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.service.TicketService;

@Controller
@RequestMapping("/")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public String listAllTickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		return"tickets";
	}
	@GetMapping("/newTicket")
	public String createNewTicket(Model model) {
		Ticket ticket = new Ticket();
		LocalDate currentDate = LocalDate.now();
		model.addAttribute("createdOn", currentDate);
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	@GetMapping("/tickets/edit/{id}")
	public String editTicket(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}
	@PostMapping("/tickets/{id}")
	public String update(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {
		Ticket theTicket = ticketService.getTicketById(id);
		
		// get ticket from database by id
		theTicket.setId(id);
		theTicket.setTitle(theTicket.getTitle());
		theTicket.setDescription(theTicket.getDescription());
		//theTicket.setDateCreated(theTicket.getDateCreated());
		theTicket.setContent(theTicket.getContent());
		
		// save updated ticket details
	    ticketService.updateTicket(theTicket);
		return "redirect:/tickets";
	}
	@GetMapping("/tickets/view/{id}")
	public String viewTicket(@PathVariable Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view_ticket";
	}
	@GetMapping("/tickets/search")
	public String searchTicket(@Param(value = "keyword") String keyword, Model model) {
		List<Ticket> tickets = ticketService.searchTickets(keyword);
		model.addAttribute("tickets", tickets);
		model.addAttribute("keyword", keyword);
		return "tickets";
	}
	@GetMapping("/tickets/{id}")
	public String deleteTicketById(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}
	
}
