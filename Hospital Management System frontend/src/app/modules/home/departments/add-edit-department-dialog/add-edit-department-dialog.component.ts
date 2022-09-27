import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-edit-department-dialog',
  templateUrl: './add-edit-department-dialog.component.html',
  styleUrls: ['./add-edit-department-dialog.component.scss']
})
export class AddEditDepartmentDialogComponent implements OnInit {

  departmentForm = new FormGroup({
    id: new FormControl("0", []),  
    dep_name: new FormControl("", [Validators.required]),  
    desc: new FormControl("", [Validators.required]),  
  });

  constructor(
    public dialogRef: MatDialogRef<AddEditDepartmentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    if (this.data) {
      this.departmentForm.get("id")?.patchValue(this.data.id);
      this.departmentForm.get("dep_name")?.patchValue(this.data.dep_name);
      this.departmentForm.get("desc")?.patchValue(this.data.desc);
    }
  }

}
