import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent {
  reservations : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/RESERVATION-SERVICE/reservations")
      .subscribe({
        next : data => {
          this.reservations = data;

        },
        error : err => {
          console.log(err);
        }
      })
  }
}
