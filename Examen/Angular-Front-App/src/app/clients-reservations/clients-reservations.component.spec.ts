import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientsReservationsComponent } from './clients-reservations.component';

describe('ClientsReservationsComponent', () => {
  let component: ClientsReservationsComponent;
  let fixture: ComponentFixture<ClientsReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClientsReservationsComponent]
    });
    fixture = TestBed.createComponent(ClientsReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
