import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditPatientDialogComponent } from './add-edit-patient-dialog.component';

describe('AddEditPatientDialogComponent', () => {
  let component: AddEditPatientDialogComponent;
  let fixture: ComponentFixture<AddEditPatientDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditPatientDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditPatientDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
