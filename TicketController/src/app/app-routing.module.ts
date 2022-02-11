
import { TicketDetailsComponent } from './ticket-details/ticket-details.component';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';

const routes: Routes = [
  { path: '', redirectTo: 'ticket', pathMatch: 'full' },
  { path: 'tickets', component: TicketListComponent },
  { path: 'add/:id ', component: BookTicketComponent },
  { path: 'update/:id', component: UpdateTicketComponent },
  { path: 'details/:id', component: TicketDetailsComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


