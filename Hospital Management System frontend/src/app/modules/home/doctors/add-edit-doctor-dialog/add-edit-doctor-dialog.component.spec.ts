import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditDoctorDialogComponent } from './add-edit-doctor-dialog.component';

describe('AddEditDoctorDialogComponent', () => {
  let component: AddEditDoctorDialogComponent;
  let fixture: ComponentFixture<AddEditDoctorDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditDoctorDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditDoctorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
