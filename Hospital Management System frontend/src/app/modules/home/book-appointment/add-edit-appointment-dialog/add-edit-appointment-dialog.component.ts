import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-edit-appointment-dialog',
  templateUrl: './add-edit-appointment-dialog.component.html',
  styleUrls: ['./add-edit-appointment-dialog.component.scss']
})
export class AddEditAppointmentDialogComponent implements OnInit {

  appointmentForm = new FormGroup({
    age: new FormControl("", [Validators.required]),
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required]),
    contact: new FormControl("", [Validators.required]),
    day: new FormControl("", [Validators.required]),
    description: new FormControl("", [Validators.required]),
    doctor_id: new FormControl("", [Validators.required]),
    speciality: new FormControl("", [Validators.required]),
  });

  doctorsList: any = [];

  constructor(
    public dialogRef: MatDialogRef<AddEditAppointmentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    this.doctorsList = this.data.doctorsList;
  }

}
