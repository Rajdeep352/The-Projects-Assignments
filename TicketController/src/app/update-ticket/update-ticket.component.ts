import { Component, OnInit } from '@angular/core';
import { Ticket } from '../ticket';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit {

  'id': number;
  'ticket': Ticket;
  constructor(private route: ActivatedRoute,private router: Router,
    private ticketService: TicketService) { }

  ngOnInit() {
     this.ticket= new Ticket();

    this.id = this.route.snapshot.params['id'];
    
    this.ticketService.getTicket(this.id)
      .subscribe(data => {
        console.log(data)
        this.ticket = data;
      }, error => console.log(error));
  }

  updateTicket() {
    this.ticketService.updateTicket(this.id, this.ticket)
      .subscribe(data => {
        console.log(data);
        this.ticket = new Ticket();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateTicket();    
  }

  gotoList() {
    this.router.navigate(['/tickets']);
  }
}

