import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  adminMenu: any[] = [
    { value: "departments", viewValue: "Departments" },
    { value: "doctors", viewValue: "Doctors" },
    { value: "patients", viewValue: "Patients" },
    { value: "staffs", viewValue: "Staffs" },
    { value: "admins", viewValue: "Admins" },
    { value: "view_feedbacks", viewValue: "View Feedbacks" },
    { value: "profile", viewValue: "Profile" },
  ];
  doctorMenu: any[] = [
    { value: "appointments", viewValue: "Appointments" },
    { value: "profile", viewValue: "Profile" },
  ];
  patientMenu: any[] = [
    { value: "book-appointment", viewValue: "Book An Appointment" },
    { value: "appointments", viewValue: "Appointments" },
    { value: "feedbacks", viewValue: "Feedback" },
    { value: "profile", viewValue: "Profile" },
  ];
  user: any;
  userMenu: any[] = [];

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("user") || "");
    console.log("User", this.user);

    switch (this.user.type) {
      case "1":
        this.userMenu = this.adminMenu;
        break;
      case "2":
        this.userMenu = this.doctorMenu;
        break;
      case "3":
        this.userMenu = this.patientMenu;
        break;
    }
  }

  onMenuItemSelect(item: string) {
    console.log("onMenuItemSelect", item);
    this.router.navigate([`/home/${item}`])
  }

}
