import { Routes } from "@angular/router";
import { RouteGuardService } from "src/app/services/route-guard.service";
import { AdminsComponent } from "./admins/admins.component";
import { AppointmentsComponent } from "./appointments/appointments.component";
import { BookAppointmentComponent } from "./book-appointment/book-appointment.component";
import { DepartmentsComponent } from "./departments/departments.component";
import { DoctorsComponent } from "./doctors/doctors.component";
import { FeedbacksComponent } from "./feedbacks/feedbacks.component";
import { HomeComponent } from "./home.component";
import { PatientsComponent } from "./patients/patients.component";
import { ProfileComponent } from "./profile/profile.component";
import { StaffsComponent } from "./staffs/staffs.component";
import { ViewFeedbacksComponent } from "./view-feedbacks/view-feedbacks.component";

export const routes: Routes = [
    {
        path: "",
        component: HomeComponent,
        children: [
            {
                path: "",
                pathMatch: "full",
                redirectTo: "departments"
            },
            {
                path: "departments",
                component: DepartmentsComponent,
                canActivate: [RouteGuardService]
            },
            {
                path: "doctors",
                component: DoctorsComponent
            },
            {
                path: "patients",
                component: PatientsComponent
            },
            {
                path: "staffs",
                component: StaffsComponent
            },
            {
                path: "view_feedbacks",
                component: ViewFeedbacksComponent
            },
            {
                path: "profile",
                component: ProfileComponent
            },
            {
                path: "book-appointment",
                component: BookAppointmentComponent
            },
            {
                path: "appointments",
                component: AppointmentsComponent
            },
            {
                path: "admins",
                component: AdminsComponent
            },
            {
                path: "feedbacks",
                component: FeedbacksComponent
            }
        ]
    }
]