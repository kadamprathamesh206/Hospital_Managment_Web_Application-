import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  imgUrl = "https://saif.iitm.ac.in/saifimages/icon-login.png";

  loginForm = new FormGroup({
    type: new FormControl("1"),
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]),
  });

  constructor(
    private router: Router,
    private adminService: AdminService,
    private doctorService: DoctorService,
    private patientService: PatientService,
  ) { }

  ngOnInit(): void {
  }

  login() {
    console.log("Submit", this.loginForm.getRawValue());
    // localStorage.setItem("user", JSON.stringify(this.loginForm.getRawValue()));
    const user = this.loginForm.getRawValue();
    switch (user.type) {
      case "1":
        this.adminService.signIn(user.email, user.password).subscribe(res => {
          console.log("res", res);
          let data: any = { ...res };
          data['type'] = user.type;
          localStorage.setItem("user", JSON.stringify(data));
          this.router.navigate(['/home']);
        });
        break;
      case "2":
        this.doctorService.signIn(user.email, user.password).subscribe(res => {
          console.log("res", res);
          let data: any = { ...res };
          data['type'] = user.type;
          localStorage.setItem("user", JSON.stringify(data));
          this.router.navigate(['/home/appointments']);
        });
        break;
      case "3":
        this.patientService.getAllPatients().subscribe((res: any) => {
          if (res) {
            const patient = res.find((item: any) => item.email === user.email && item.password === user.password);
            console.log("patient", patient);
            patient['type'] = user.type;
            localStorage.setItem("user", JSON.stringify(patient));
            this.router.navigate(['/home/book-appointment']);
          }
        });
        // this.patientService.signIn(user.email, user.password).subscribe(res => {
        //   console.log("res", res);
        //   let data: any = { ...res };
        //   data['type'] = user.type;
        //   localStorage.setItem("user", JSON.stringify(data));
        //   this.router.navigate(['/home/book-appointment']);
        // });
        break;
    }

    // this.router.navigate(['/home']);
  }
}
