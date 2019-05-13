import { async, ComponentFixture, TestBed, inject } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing'
import { HttpClient } from '@angular/common/http';
import { RegistrationFormComponent } from './registration-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginFormComponent } from '../login-form/login-form.component';

describe('RegistrationFormComponent', () => {
  let component: RegistrationFormComponent;
  let fixture: ComponentFixture<RegistrationFormComponent>;

  let httpClient : HttpClient;
  let httpTestingController : HttpTestingController;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports : [ReactiveFormsModule, HttpClientTestingModule],
      declarations: [ RegistrationFormComponent, LoginFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    httpClient = TestBed.get(HttpClient);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
