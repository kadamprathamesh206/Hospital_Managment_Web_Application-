import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DoctorService } from 'src/app/services/doctor.service';
import { AddEditDoctorDialogComponent } from './add-edit-doctor-dialog/add-edit-doctor-dialog.component';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.scss']
})
export class DoctorsComponent implements OnInit {

  doctorsList: any = [];

  constructor(
    private doctorService: DoctorService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.doctorService.getAllDoctors().subscribe((res: any) => {
      if (res) {
        this.doctorsList = res;
      }
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(AddEditDoctorDialogComponent, {
      width: '50%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.doctorService.addDoctor(result).subscribe((res: any) => {
          console.log("addDoctor", res);
          this.doctorsList.push(res);
        });
      }
    });
  }

  edit(data: any): void {
    const dialogRef = this.dialog.open(AddEditDoctorDialogComponent, {
      width: '50%',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.doctorService.updateDoctor(data.id, result).subscribe((res: any) => {
          console.log("updateDoctor", res);
          this.getData();
        });
      }
    });
  }

  delete(id: string) {
    if (window.confirm("Are you sure you want to delete ?")) {
      this.doctorService.deleteDoctor(id).subscribe(res => {
        this.getData();
        window.alert("Doctor deleted successfully")
      });
    }
  }

}
