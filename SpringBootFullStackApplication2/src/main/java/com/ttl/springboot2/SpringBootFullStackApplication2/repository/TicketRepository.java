package com.ttl.springboot2.SpringBootFullStackApplication2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ttl.springboot2.SpringBootFullStackApplication2.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
