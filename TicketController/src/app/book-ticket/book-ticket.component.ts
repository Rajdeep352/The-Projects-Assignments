
import { TicketService } from '../ticket.service';
import { Ticket } from '../ticket';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-ticket',
  templateUrl: './book-ticket.component.html',
  styleUrls: ['./book-ticket.component.css']
})
export class BookTicketComponent implements OnInit {

 ticket: Ticket = new Ticket();
  submitted = false;

  constructor(private ticketService: TicketService,
    private router: Router) { }

  ngOnInit() {
  }

  newTicket(): void {
    this.submitted = false;
    this.ticket = new Ticket();
  }

  save() {
    this.ticketService
    .bookTicket(this.ticket).subscribe(data => {
      console.log(data)
      this.ticket = new Ticket();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/Tickets']);
  }
}
 