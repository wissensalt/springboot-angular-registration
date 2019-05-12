import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ResponseData } from '../dto/response-data';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, mapTo, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginClientService {

  private baseUrl = "http://localhost:8081";
  private loginUrl = "/auth/login";
  
  constructor(
    private http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      }
    )
  }

  login(requestLoginDTO): Observable<ResponseData> {
    return this.http.post<ResponseData>(
      this.baseUrl+this.loginUrl, 
      JSON.stringify(requestLoginDTO), 
      this.httpOptions
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
