import { TestBed, inject } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing'
import { LoginClientService } from './login-client.service';
import { HttpClient } from '@angular/common/http';

describe('LoginClientService', () => {
  let httpClient : HttpClient;
  let httpTestingController : HttpTestingController;
  beforeEach(() => TestBed.configureTestingModule({
    imports : [HttpClientTestingModule]
  }));

  beforeEach(() =>{
    httpClient = TestBed.get(HttpClient);
    httpTestingController = TestBed.get(HttpTestingController);
  });
  
  it('should be created', inject([LoginClientService], (service: LoginClientService) => {    
    expect(service).toBeTruthy();
  }));
});
