import { TestBed, inject } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing'
import { LoginClientService } from './login-client.service';
import { HttpClient } from '@angular/common/http';
import { RegistrationClientService } from './registration-client.service';

describe('RegistrationClientService', () => {
  let httpClient : HttpClient;
  let httpTestingController : HttpTestingController;

  beforeEach(() => TestBed.configureTestingModule({
    imports : [HttpClientTestingModule]
  }));

  beforeEach(() =>{
    httpClient = TestBed.get(HttpClient);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  it('should be created', inject([RegistrationClientService], (service: LoginClientService) => {    
    expect(service).toBeTruthy();
  }));
});
