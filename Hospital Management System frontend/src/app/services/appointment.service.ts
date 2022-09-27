import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(
    private http: HttpClient
  ) { }

  getAllAppointments() {
    return this.http.get("http://localhost:8086/appoinment/appointemtlist")
  }

  getAppointmentById(id: string) {
    return this.http.get("http://localhost:8086/appoinment/" + id);
  }

  addAppointment(obj: any) {
    return this.http.post("http://localhost:8086/appoinment/createappoinment", obj);
  }

  deleteAppointment(id: string) {
    return this.http.delete("http://localhost:8086/appoinment/delete/" + id);
  }

  updateAppointment(id: string, obj: any) {
    return this.http.put("http://localhost:8086/appoinment/update/" + id, obj);
  }

}
