package com.greatlearning.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.ticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query("SELECT t FROM Ticket t WHERE CONCAT(t.title,'',t.description) LIKE %:keyword%")
	public List<Ticket> search(String keyword);

}
