import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(
    private http: HttpClient
  ) { }

  getAllDepartments() {
    return this.http.get("http://localhost:8086/department/getAllDepartment")
  }

  getDepartmentById(id: string) {
    return this.http.get("http://localhost:8086/department/" + id);
  }

  addDepartment(obj: any) {
    return this.http.post("http://localhost:8086/department/createdepartment", obj);
  }

  deleteDepartment(id: string) {
    return this.http.delete("http://localhost:8086/department/delete/" + id);
  }

  updateDepartment(id: string, obj: any) {
    return this.http.put("http://localhost:8086/department/put/" + id, obj);
  }
  
}
