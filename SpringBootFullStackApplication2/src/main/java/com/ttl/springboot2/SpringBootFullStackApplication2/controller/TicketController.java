package com.ttl.springboot2.SpringBootFullStackApplication2.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ttl.springboot2.SpringBootFullStackApplication2.model.Ticket;
import com.ttl.springboot2.SpringBootFullStackApplication2.service.MyService;




@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = {"GET","POST","PUT","DELETE"})
//@RequestMapping("/api/v1")
public class TicketController {

	@Autowired
	MyService service;
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedOrigins("*");
	            }
	        };
	    }

// localhost:8080/api/v1/ticket/all

	@RequestMapping(value = "/ticket/all", method = RequestMethod.GET)
	public List<Ticket> getTickets() {
		System.out.println(this.getClass().getSimpleName() + " getTickets() method invoked");

		return service.getTickets();
	}

// localhost:8080/projectname/ticket/1234 ==> 1234 @PathVariable id
	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
	public Ticket getTicketById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " getTicketById() method invoked");
		Optional<Ticket> ticket = service.getTicketById(id);

		if (!ticket.isPresent())
			throw new Exception("could not find Ticket with id " + id);

		return ticket.get();
	}

	@RequestMapping(value = "/ticket/add", method = RequestMethod.POST)
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		System.out.println(this.getClass().getSimpleName() + " bookTicket method invoked");
		return service.addNewTicket(ticket);
	}

	@RequestMapping(value = "/ticket/update/{id}", method = RequestMethod.PUT)
	public Ticket updateTicket(@PathVariable int id, @RequestBody Ticket UpTicket) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " bookTicket method invoked");

		Optional<Ticket> ticket = service.getTicketById(id);

		if (!ticket.isPresent())
			throw new Exception("could not find Ticket with id " + id);

		if (UpTicket.getName() == null || UpTicket.getName().isEmpty())
			UpTicket.setName(ticket.get().getName());
		if (UpTicket.getCategory() == null || UpTicket.getCategory().isEmpty())
			UpTicket.setCategory(ticket.get().getCategory());
		if (UpTicket.getAmount() == 0.0)
			UpTicket.setAmount(ticket.get().getAmount());

// for where clause
		UpTicket.setId(id);

		return service.updateTicket(UpTicket);

	}

	@RequestMapping(value = "/ticket/delete/{id}", method = RequestMethod.DELETE)
	public void deleteTicketById(@PathVariable int ticketid) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " deleteTicketById() method invoked");
		Optional<Ticket> ticket = service.getTicketById(ticketid);

		if (!ticket.isPresent())
			throw new Exception("could not find Ticket with id " + ticketid);

		service.deleteTicketById(ticketid);
	}

	@RequestMapping(value = "/ticket/deleteall", method = RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " deleteAll() method invoked");

		service.deleteAllTickets();
	}

}

