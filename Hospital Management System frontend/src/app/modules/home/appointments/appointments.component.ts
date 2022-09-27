import { Component, OnInit } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.scss']
})
export class AppointmentsComponent implements OnInit {

  appoitmentsList: any = [];

  constructor(
    private doctorService: DoctorService,
    private patientService: PatientService,
  ) { }

  ngOnInit(): void {
    const user = JSON.parse(localStorage.getItem("user") || "");
    if (user.type == "2") {
      this.doctorService.getDoctorAppointment(user.email, user.password).subscribe((res: any) => {
        if (res) {
          this.appoitmentsList = res; //.filter((item: any) => item.doctor_id == user.id);
        }
      });
    } else if (user.type == "3") {
      this.patientService.getPatientAppointments(user.email, user.password).subscribe((res: any) => {
        if (res) {
          this.appoitmentsList = res; //.filter((item: any) => item.doctor_id == user.id);
        }
      });
    }
  }

}
