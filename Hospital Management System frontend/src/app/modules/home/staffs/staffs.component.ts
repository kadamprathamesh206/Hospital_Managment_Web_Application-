import { Component, OnInit } from '@angular/core';
import { StaffService } from 'src/app/services/staff.service';

@Component({
  selector: 'app-staffs',
  templateUrl: './staffs.component.html',
  styleUrls: ['./staffs.component.scss']
})
export class StaffsComponent implements OnInit {

  staffsList: any = [];

  constructor(
    private staffService: StaffService,
  ) { }

  ngOnInit(): void {
    this.staffService.getAllStaffs().subscribe((res: any) => {
      if (res) {
        this.staffsList = res;
      }
    });
  }

}
