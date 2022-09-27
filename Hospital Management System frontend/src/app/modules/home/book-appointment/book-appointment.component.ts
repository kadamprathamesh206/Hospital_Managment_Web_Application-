import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AppointmentService } from 'src/app/services/appointment.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { AddEditAppointmentDialogComponent } from './add-edit-appointment-dialog/add-edit-appointment-dialog.component';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.scss']
})
export class BookAppointmentComponent implements OnInit {

  doctorsList: any = [];

  constructor(
    private doctorService: DoctorService,
    private appointmentService: AppointmentService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.doctorService.getAllDoctors().subscribe((res: any) => {
      if (res) {
        this.doctorsList = res;
      }
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(AddEditAppointmentDialogComponent, {
      width: '50%',
      data: {
        doctorsList: this.doctorsList
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.appointmentService.addAppointment(result).subscribe((res: any) => {
          console.log("addAdmin", res);
          window.alert("Appointment added successfully");
        });
      }
    });
  }

}
