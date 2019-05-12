import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RequestLogin } from '../dto/request-login';
import { LoginClientService } from '../client/login-client.service';
import { ResponseData } from '../dto/response-data';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm : FormGroup;
  private submitted = false;
  private loginData : RequestLogin;

  constructor(
    public loginClient : LoginClientService,
    public router: Router
  ) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      userName : new FormControl('', [Validators.required, Validators.email]),
      password : new FormControl('', Validators.required),
    })
  }
  
  login() {            
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }else {
       this.loginData = new RequestLogin();
       this.loginData.setUserName(this.loginForm.get('userName').value) 
       this.loginData.setPassword(this.loginForm.get('password').value) 

       this.loginClient.login(this.loginData).subscribe((data: ResponseData) => {
        console.log("RESPONSE DATA "+JSON.stringify(data))
        if (data.responseCode == '200') {          
          localStorage.setItem("isLoggedIn", "true");
          localStorage.setItem("userName", this.loginData.getUserName());
          this.router.navigate(["/dashboard"]);          
        }
        window.alert(data.responseMsg);
      }), error => {
        console.log("An Error Occured "+error);
      };            
    }
  }
 
  clearPass(){
    this.loginForm.get('password').setValue('');
  }

}
