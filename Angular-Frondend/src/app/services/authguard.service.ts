import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';
import { EmployeeService } from './employee.service';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate {
  constructor(private authService: AuthService, private router: Router,private employeeService:EmployeeService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
     
      this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
      return false;
    }
  }

//   if (this.authService.isLoggedIn() && this.authService.verifyRole() === 'Admin' ) {
//     this.router.navigate(['admin'], { queryParams: { returnUrl: state.url } });
//     return true;
//   } else {
   
//     // this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
//     return false;
//   }
// }

  

}
