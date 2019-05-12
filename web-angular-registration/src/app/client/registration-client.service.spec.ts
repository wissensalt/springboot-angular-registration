import { TestBed } from '@angular/core/testing';

import { RegistrationClientService } from './registration-client.service';

describe('RegistrationClientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegistrationClientService = TestBed.get(RegistrationClientService);
    expect(service).toBeTruthy();
  });
});
