import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(
    private http: HttpClient
  ) { }

  getAllStaffs() {
    return this.http.get("http://localhost:8086/staff/getStaff")
  }
}
