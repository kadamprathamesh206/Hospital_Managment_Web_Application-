import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(
    private http: HttpClient
  ) { }

  getAllPatients() {
    return this.http.get("http://localhost:8086/patient/allpatient")
  }

  getPatientById(id: string) {
    return this.http.get("http://localhost:8086/patient/" + id);
  }

  addPatient(obj: any) {
    return this.http.post("http://localhost:8086/patient/register", obj);
  }

  deletePatient(id: string) {
    return this.http.delete("http://localhost:8086/patient/delete/" + id);
  }

  updatePatient(id: string, obj: any) {
    return this.http.put("http://localhost:8086/patient/update/" + id, obj);
  }

  signIn(email: string, password: string) {
    return this.http.post("http://localhost:8086/patient/signin", { email, password }).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Invalid Credentials")
        }
        return throwError(() => err);
      })
    );
  }

  getPatientAppointments(email: string, password: string) {
    return this.http.post("http://localhost:8086/patient/getappoinmentOfPatient", { email, password });
  }

}
