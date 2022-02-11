package com.ttl.springboot2.SpringBootFullStackApplication2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttl.springboot2.SpringBootFullStackApplication2.model.Ticket;
import com.ttl.springboot2.SpringBootFullStackApplication2.repository.TicketRepository;



@Service
public class MyServiceImpl implements MyService {

	@Autowired
	TicketRepository dao;

	@Override
	public List<Ticket> getTickets() {
// TODO Auto-generated method stub
		return dao.findAll(); // select all
	}

	@Override
	public Optional<Ticket> getTicketById(int ticketid) {
// TODO Auto-generated method stub
		return dao.findById(ticketid); // select one record based on id
	}

	@Override
	public Ticket addNewTicket(Ticket ticket) {
// TODO Auto-generated method stub
		return dao.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
// TODO Auto-generated method stub
		return dao.save(ticket);
	}

	@Override
	public void deleteTicketById(int ticketid) {
// TODO Auto-generated method stub
		dao.deleteById(ticketid);
	}

	@Override
	public void deleteAllTickets() {
		dao.deleteAll();

	}



}
