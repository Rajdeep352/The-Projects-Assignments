package com.ttl.springboot2.SpringBootFullStackApplication2.service;

import java.util.List;
import java.util.Optional;

import com.ttl.springboot2.SpringBootFullStackApplication2.model.Ticket;
public interface MyService {

	
	public List<Ticket> getTickets();
	public Optional<Ticket> getTicketById(int ticketid);
	public Ticket addNewTicket(Ticket ticket);
	public Ticket updateTicket(Ticket ticket);
	public void deleteTicketById(int ticketid);
	public void deleteAllTickets();
	
}
