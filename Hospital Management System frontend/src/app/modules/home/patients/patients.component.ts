import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PatientService } from 'src/app/services/patient.service';
import { AddEditPatientDialogComponent } from './add-edit-patient-dialog/add-edit-patient-dialog.component';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.scss']
})
export class PatientsComponent implements OnInit {

  patientsList: any = [];

  constructor(
    private patientService: PatientService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.patientService.getAllPatients().subscribe((res: any) => {
      if (res) {
        this.patientsList = res;
      }
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(AddEditPatientDialogComponent, {
      width: '50%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.patientService.addPatient(result).subscribe((res: any) => {
          console.log("addPatient", res);
          this.patientsList.push(res);
        });
      }
    });
  }

  edit(data: any): void {
    const dialogRef = this.dialog.open(AddEditPatientDialogComponent, {
      width: '50%',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.patientService.updatePatient(data.id, result).subscribe((res: any) => {
          console.log("updatePatient", res);
          this.getData();
        });
      }
    });
  }

  delete(id: string) {
    this.patientService.deletePatient(id).subscribe(res => {
      this.getData();
      window.alert("Patient deleted successfully");
    });
  }

}
