import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { RouterModule } from '@angular/router';
import { routes } from './home.routing';
import { DepartmentsComponent } from './departments/departments.component';
import { MaterialModule } from 'src/app/material.module';
import { DoctorsComponent } from './doctors/doctors.component';
import { PatientsComponent } from './patients/patients.component';
import { StaffsComponent } from './staffs/staffs.component';
import { ViewFeedbacksComponent } from './view-feedbacks/view-feedbacks.component';
import { ProfileComponent } from './profile/profile.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { AdminsComponent } from './admins/admins.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddEditAdminComponent } from './admins/add-edit-admin/add-edit-admin.component';
import { FeedbacksComponent } from './feedbacks/feedbacks.component';
import { AddEditAppointmentDialogComponent } from './book-appointment/add-edit-appointment-dialog/add-edit-appointment-dialog.component';
import { AddEditDepartmentDialogComponent } from './departments/add-edit-department-dialog/add-edit-department-dialog.component';
import { AddEditPatientDialogComponent } from './patients/add-edit-patient-dialog/add-edit-patient-dialog.component';
import { AddEditDoctorDialogComponent } from './doctors/add-edit-doctor-dialog/add-edit-doctor-dialog.component';

@NgModule({
  declarations: [
    HomeComponent,
    DepartmentsComponent,
    DoctorsComponent,
    PatientsComponent,
    StaffsComponent,
    ViewFeedbacksComponent,
    ProfileComponent,
    BookAppointmentComponent,
    AppointmentsComponent,
    AdminsComponent,
    AddEditAdminComponent,
    FeedbacksComponent,
    AddEditAppointmentDialogComponent,
    AddEditDepartmentDialogComponent,
    AddEditPatientDialogComponent,
    AddEditDoctorDialogComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class HomeModule { }
