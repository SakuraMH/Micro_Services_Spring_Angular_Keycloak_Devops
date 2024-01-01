import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourcesComponent} from "./resources/resources.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {ClientsComponent} from "./clients/clients.component";
import {ClientsReservationsComponent} from "./clients-reservations/clients-reservations.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  { path : "resources", component : ResourcesComponent,canActivate:[AuthGuard], data : { roles:['USER']}},
  { path : "reservations", component : ReservationsComponent, canActivate:[AuthGuard], data : { roles:['ADMIN','USER']}},
  { path : "clients", component : ClientsComponent, canActivate:[AuthGuard], data : { roles:['ADMIN','USER']}},
  { path : "clients-reservations", component : ClientsReservationsComponent, canActivate:[AuthGuard], data : { roles:['ADMIN','USER']}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
