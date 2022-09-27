import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditAppointmentDialogComponent } from './add-edit-appointment-dialog.component';

describe('AddEditAppointmentDialogComponent', () => {
  let component: AddEditAppointmentDialogComponent;
  let fixture: ComponentFixture<AddEditAppointmentDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditAppointmentDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditAppointmentDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
