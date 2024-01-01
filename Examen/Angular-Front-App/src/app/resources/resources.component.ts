import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent {
  resources : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/RESOURCE-SERVICE/resources")
      .subscribe({
        next : data => {
          this.resources = data;

        },
        error : err => {
          console.log(err);
        }
      })
  }
}
