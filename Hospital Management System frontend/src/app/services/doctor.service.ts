import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(
    private http: HttpClient
  ) { }

  getAllDoctors() {
    return this.http.get("http://localhost:8086/Doctor/getAll")
  }

  getDoctorById(id: string) {
    return this.http.get("http://localhost:8086/Doctor/" + id);
  }

  addDoctor(obj: any) {
    return this.http.post("http://localhost:8086/Doctor/register", obj);
  }

  deleteDoctor(id: string) {
    return this.http.delete("http://localhost:8086/Doctor/delete/" + id);
  }

  updateDoctor(id: string, obj: any) {
    return this.http.put("http://localhost:8086/Doctor/update/" + id, obj);
  }

  signIn(email: string, password: string) {
    return this.http.post("http://localhost:8086/Doctor/signIn", { email, password }).pipe(
      catchError((err: HttpErrorResponse) => {
        console.log("err in res", err);
        if (err.status === 400) {
          window.alert("Invalid Credentials")
        }
        return throwError(() => err);
      })
    );
  }

  getDoctorAppointment(email: string, password: string) {
    return this.http.post("http://localhost:8086/Doctor/getDoctorAppoinment", { email, password });
  }
}
