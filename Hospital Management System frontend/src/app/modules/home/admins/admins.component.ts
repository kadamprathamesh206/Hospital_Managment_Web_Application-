import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AdminService } from 'src/app/services/admin.service';
import { AddEditAdminComponent } from './add-edit-admin/add-edit-admin.component';

@Component({
  selector: 'app-admins',
  templateUrl: './admins.component.html',
  styleUrls: ['./admins.component.scss']
})
export class AdminsComponent implements OnInit {

  adminsList: any = [];

  constructor(
    private adminsService: AdminService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.adminsService.getAllAdmins().subscribe((res: any) => {
      if (res) {
        this.adminsList = res;
      }
    });
  }

  add(): void {
    const dialogRef = this.dialog.open(AddEditAdminComponent, {
      width: '30%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      if (result) {
        this.adminsService.addAdmin(result).subscribe((res: any) => {
          console.log("addAdmin", res);
          this.adminsList.push(res);
        });
      }
    });
  }

  edit(data: any): void {
    const dialogRef = this.dialog.open(AddEditAdminComponent, {
      width: '30%',
      data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
    });
  }

  delete(id: string) {
    if (window.confirm("Are you sure ? This cannot be undone.")) {
      this.adminsService.deleteAdmin(id).subscribe((res) => {
        if (res) {
          this.getData();
          window.alert("Deleted successfully");
        }
      });
    }
  }
}
