import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent {
  clients : any;
  informationsClient : any;
  constructor(private http : HttpClient, private router : Router) {
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/RESERVATION-SERVICE/allClients")
      .subscribe({
        next : data => {
          this.clients = data;

        },
        error : err => {
          console.log(err);
        }
      })
  }
  onButtonClick(p: any) {
    console.log('Informations de la ligne:', p);
    this.informationsClient = p;
    this.router.navigate(['/clients-reservations', { data: JSON.stringify(this.informationsClient) }]);
  }
}
