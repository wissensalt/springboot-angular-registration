import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  userName : any;
  constructor(private router: Router) { }

  ngOnInit() {
    this.userName = localStorage.getItem("userName");
  }

  logout() {
    localStorage.removeItem("isLoggedIn");
    localStorage.removeItem("userName");
    this.router.navigate(["/login"]);
  }
}
