import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RegistrationClientService } from '../client/registration-client.service';
import { RequestRegistration } from '../dto/request-registration';
import { ResponseData } from '../dto/response-data';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  visible = false;
  day = [];
  month=[];
  year=[];
  buttonRegister= true;
  registrationForm: FormGroup;
  submitted = false;
  
  private registrationData : RequestRegistration;

  constructor(
    public registrationClient : RegistrationClientService
  ) { 
  }
  

  dayMonthContent(){
    for(let a=0;a<31;a++){
      this.day.push(a+1);
      if(a<12){
        this.month.push(a+1);
      }
    }
  }
  
  yearContent(){
    for(let a=2019;a>=1990;a--){
      this.year.push(a);
    }
  }

  enableForm(enable : boolean){
    if (enable) {      
      this.registrationForm.get('mobileNumber').enable();
      this.registrationForm.get('firstName').enable();
      this.registrationForm.get('lastName').enable();
      this.registrationForm.get('email').enable();
      this.registrationForm.get('day').enable();
      this.registrationForm.get('month').enable();
      this.registrationForm.get('year').enable();
      this.registrationForm.get('gender').enable();
      this.buttonRegister = true;
    }else {
      this.registrationForm.get('mobileNumber').disable();
      this.registrationForm.get('firstName').disable();
      this.registrationForm.get('lastName').disable();
      this.registrationForm.get('email').disable();
      this.registrationForm.get('day').disable();
      this.registrationForm.get('month').disable();
      this.registrationForm.get('year').disable();
      this.registrationForm.get('gender').disable();
      this.buttonRegister = false;
    }    
  }

  register(){    
    this.submitted = true;
    if (this.registrationForm.invalid) {      
      return;
    }else {
      this.registrationData = new RequestRegistration();
      this.registrationData.setMobileNumber(this.registrationForm.get('mobileNumber').value);
      this.registrationData.setFirstName(this.registrationForm.get('firstName').value);
      this.registrationData.setLastName(this.registrationForm.get('lastName').value);
      this.registrationData.setDob(
        this.registrationForm.get('day').value + '-' +
        this.registrationForm.get('month').value + '-' +
        this.registrationForm.get('year').value
      );
      this.registrationData.setGender(this.registrationForm.get('gender').value);
      this.registrationData.setEmail(this.registrationForm.get('email').value);

      this.registrationClient.register(this.registrationData).subscribe((data: ResponseData) => {
          console.log("RESPONSE DATA "+JSON.stringify(data))
          if (data.responseCode=='200') {
            window.alert(data.responseMsg);
            this.visible = true;
            this.enableForm(false);
          }else {
            this.enableForm(true);
          }
      }), error => {
        console.log("An Error Occured "+error);
      };            
    }
  }

  ngOnInit() {
    this.registrationForm = new FormGroup({
      mobileNumber : new FormControl('',[Validators.required, Validators.pattern('^08[0-9]{9,}$')]),
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email:new FormControl('', [Validators.required, Validators.email]),
      day: new FormControl('day'),
      month: new FormControl('month'),
      year: new FormControl('year'),
      gender: new FormControl('1')
    })

    this.dayMonthContent();
    this.yearContent();
  }

}
