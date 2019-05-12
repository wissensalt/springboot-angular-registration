import { AuthGuard } from './auth-guard';

describe('AuthGuard', () => {
  it('should create an instance', () => {
    expect(new AuthGuard()).toBeTruthy();
  });
});
