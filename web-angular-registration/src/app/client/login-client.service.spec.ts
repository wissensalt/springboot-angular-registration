import { TestBed } from '@angular/core/testing';

import { LoginClientService } from './login-client.service';

describe('LoginClientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginClientService = TestBed.get(LoginClientService);
    expect(service).toBeTruthy();
  });
});
