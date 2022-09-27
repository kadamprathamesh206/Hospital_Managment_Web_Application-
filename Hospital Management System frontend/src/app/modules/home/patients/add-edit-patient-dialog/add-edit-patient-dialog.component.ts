import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddEditDepartmentDialogComponent } from '../../departments/add-edit-department-dialog/add-edit-department-dialog.component';

@Component({
  selector: 'app-add-edit-patient-dialog',
  templateUrl: './add-edit-patient-dialog.component.html',
  styleUrls: ['./add-edit-patient-dialog.component.scss']
})
export class AddEditPatientDialogComponent implements OnInit {

  patientForm = new FormGroup({
    id: new FormControl("0", []),  
    name: new FormControl("", [Validators.required]),  
    email: new FormControl("", [Validators.required]),  
    phone_no: new FormControl("", [Validators.required]),  
    password: new FormControl("", [Validators.required]),
    confirm_password: new FormControl("", [Validators.required]),
  });

  constructor(
    public dialogRef: MatDialogRef<AddEditDepartmentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    if (this.data) {
      this.patientForm.get("id")?.patchValue(this.data.id);
      this.patientForm.get("name")?.patchValue(this.data.name);
      this.patientForm.get("email")?.patchValue(this.data.email);
      this.patientForm.get("phone_no")?.patchValue(this.data.phone_no);
      this.patientForm.get("password")?.patchValue(this.data.password);
      this.patientForm.get("confirm_password")?.patchValue(this.data.password);
    }
  }
}
