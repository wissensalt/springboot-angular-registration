import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginClientService } from '../client/login-client.service';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate{

    constructor(private router: Router) { }
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if (localStorage.getItem("isLoggedIn") == 'true') {
            return true;
        }else {
            this.router.navigate(["/login"]);
            return false;
        }
    }
}
