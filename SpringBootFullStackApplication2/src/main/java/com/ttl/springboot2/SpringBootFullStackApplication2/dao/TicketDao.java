package com.ttl.springboot2.SpringBootFullStackApplication2.dao;

import org.springframework.data.repository.CrudRepository;

import com.ttl.springboot2.SpringBootFullStackApplication2.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket,Integer> {

}
