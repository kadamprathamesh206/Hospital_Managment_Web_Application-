import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  isLoginPage = true;

  constructor(private router: Router) {}

  ngAfterContentChecked() {
    if (localStorage.getItem("user")) {
      this.isLoginPage = false;
    } else {
      this.isLoginPage = true;
    }
  }
  
  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
