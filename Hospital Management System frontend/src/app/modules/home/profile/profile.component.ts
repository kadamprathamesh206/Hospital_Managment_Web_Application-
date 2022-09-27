import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AdminService } from 'src/app/services/admin.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  editForm = new FormGroup({
    id: new FormControl("", [Validators.required]),
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]),
    desc: new FormControl("", []),
    fees: new FormControl("", []),
    phone_no: new FormControl("", [Validators.min(10), Validators.max(10)]),
  });

  type: string = "1";

  constructor(
    // private profileService: ProfileService,
    private adminService: AdminService,
    private doctorServicce: DoctorService,
    private patientService: PatientService,
  ) { }

  ngOnInit(): void {
    const user = JSON.parse(localStorage.getItem("user") || "");
    this.type = user.type;
    switch (this.type) {
      case "1":
        this.adminService.getAdminById(user.id).subscribe((res: any) => {
          if (res) {
            this.editForm.get("id")?.patchValue(res.id);
            this.editForm.get("name")?.patchValue(res.name);
            this.editForm.get("email")?.patchValue(res.email);
            this.editForm.get("password")?.patchValue(res.password);
          }
        });
        break;

      case "2":
        this.doctorServicce.getDoctorById(user.id).subscribe((res: any) => {
          if (res) {
            this.editForm.get("id")?.patchValue(res.id);
            this.editForm.get("name")?.patchValue(res.name);
            this.editForm.get("email")?.patchValue(res.email);
            this.editForm.get("password")?.patchValue(res.password);
            this.editForm.get("desc")?.patchValue(res.desc);
            this.editForm.get("fees")?.patchValue(res.fees);
          }
        });
        break;

      case "3":
        this.patientService.getPatientById(user.id).subscribe((res: any) => {
          if (res) {
            this.editForm.get("id")?.patchValue(res.id);
            this.editForm.get("name")?.patchValue(res.name);
            this.editForm.get("email")?.patchValue(res.email);
            this.editForm.get("password")?.patchValue(res.password);
            this.editForm.get("phone_no")?.patchValue(res.phone_no);
          }
        });
        break;
    }
  }

  save() {
    if (window.confirm("Are you sure you want to update your details ?")) {
      switch (this.type) {
        case "1":
          this.adminService.updateAdmin(this.editForm.getRawValue().id, this.editForm.getRawValue()).subscribe(res => {
            if (res) {
              window.alert("Changes saved successfully");
            }
          });
          break;

        case "2":
          this.doctorServicce.updateDoctor(this.editForm.getRawValue().id, this.editForm.getRawValue()).subscribe(res => {
            if (res) {
              window.alert("Changes saved successfully");
            }
          });
          break;

        case "3":
          this.patientService.updatePatient(this.editForm.getRawValue().id, this.editForm.getRawValue()).subscribe(res => {
            if (res) {
              window.alert("Changes saved successfully");
            }
          });
          break;
      }
    }
  }
}
