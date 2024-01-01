import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-clients-reservations',
  templateUrl: './clients-reservations.component.html',
  styleUrls: ['./clients-reservations.component.css']
})
export class ClientsReservationsComponent {
  clientInformations: any;
  clientsReservations: any;

  constructor(private http : HttpClient,private route: ActivatedRoute) {}

  ngOnInit() {
    // Récupérer les paramètres de route
    this.route.params.subscribe(params => {
      // Vérifier si le paramètre 'data' existe dans les paramètres
      if (params['data']) {
        this.clientInformations = JSON.parse(params['data']);
        console.log(this.clientInformations['cltId'])
        this.http.get("http://localhost:9999/RESERVATION-SERVICE/reservations/idClient/"+this.clientInformations['cltId'])
          .subscribe({
            next : data => {
              this.clientsReservations = data;
              console.log(this.clientsReservations);


            },
            error : err => {
              console.log(err);
            }
          })
      }
    });
  }
}
