import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddEditDepartmentDialogComponent } from '../../departments/add-edit-department-dialog/add-edit-department-dialog.component';

@Component({
  selector: 'app-add-edit-doctor-dialog',
  templateUrl: './add-edit-doctor-dialog.component.html',
  styleUrls: ['./add-edit-doctor-dialog.component.scss']
})
export class AddEditDoctorDialogComponent implements OnInit {

  doctorForm = new FormGroup({
    id: new FormControl("0", []),  
    name: new FormControl("", [Validators.required]),  
    desc: new FormControl("", [Validators.required]),  
    email: new FormControl("", [Validators.required]),  
    fees: new FormControl("", [Validators.required]),  
    password: new FormControl("", [Validators.required]),
    confirm_password: new FormControl("", [Validators.required]),
  });

  constructor(
    public dialogRef: MatDialogRef<AddEditDepartmentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    if (this.data) {
      this.doctorForm.get("id")?.patchValue(this.data.id);
      this.doctorForm.get("name")?.patchValue(this.data.name);
      this.doctorForm.get("desc")?.patchValue(this.data.desc);
      this.doctorForm.get("email")?.patchValue(this.data.email);
      this.doctorForm.get("fees")?.patchValue(this.data.fees);
      this.doctorForm.get("password")?.patchValue(this.data.password);
      this.doctorForm.get("confirm_password")?.patchValue(this.data.password);
    }
  }

}
