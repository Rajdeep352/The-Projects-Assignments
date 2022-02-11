import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTicket(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/ticket/${id}`);
  }

  bookTicket(ticket: object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, ticket);
  }

  updateTicket(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteTicket(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getTicketsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/ticket/all`);
  }

}
