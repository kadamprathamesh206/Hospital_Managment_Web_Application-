import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  patientForm = new FormGroup({
    id: new FormControl("0", []),
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required]),
    phone_no: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]),
    confirm_password: new FormControl("", [Validators.required]),
  });

  constructor(
    private patientService: PatientService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  submit() {
    this.patientService.addPatient(this.patientForm.getRawValue()).subscribe(res => {
      window.alert("Registration successfull");
      this.router.navigate(['/login']);
    });
  }
}
