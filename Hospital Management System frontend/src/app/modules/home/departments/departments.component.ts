import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DepartmentService } from 'src/app/services/department.service';
import { AddEditDepartmentDialogComponent } from './add-edit-department-dialog/add-edit-department-dialog.component';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.scss']
})
export class DepartmentsComponent implements OnInit {

  departmentsList: any = [];

  constructor(
    private departmentService: DepartmentService,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.departmentService.getAllDepartments().subscribe((res: any) => {
      if (res) {
        this.departmentsList = res;
      }
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(AddEditDepartmentDialogComponent, {
      width: '33%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.departmentService.addDepartment(result).subscribe((res: any) => {
          console.log("addDepartment", res);
          this.departmentsList.push(res);
        });
      }
    });
  }

  edit(data: any): void {
    const dialogRef = this.dialog.open(AddEditDepartmentDialogComponent, {
      width: '33%',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.departmentService.updateDepartment(data.id, result).subscribe((res: any) => {
          console.log("addDepartment", res);
          this.getData();
        });
      }
    });
  }

  delete(id: string) {
    this.departmentService.deleteDepartment(id).subscribe(res => {
      window.alert("Department deleted successfully")
    });
  }

}
