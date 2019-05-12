import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { RequestRegistration } from '../dto/request-registration';
import { ResponseData } from '../dto/response-data';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { ResponseError } from '../dto/response-error';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type' : 'application/json'
    }
  )
}

@Injectable({
  providedIn: 'root'
})
export class RegistrationClientService {

  baseUrl = "http://localhost:8081";
  registrationUrl = "/registration/register"  
  constructor(
    private http: HttpClient
  ) { }  

  register(requestRegistrationDTO: RequestRegistration): Observable<ResponseData> {      
    return this.http.post<ResponseData>(
      this.baseUrl+this.registrationUrl, 
      requestRegistrationDTO, 
      httpOptions
      ).pipe(
          retry(1),
          catchError(this.handleError)
      )          
  }

  handleError(error) {    
    let errorMessage = `Error Code: ${error.status} - ${error.error.error} \nMessage: ${error.error.message}`;
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}

