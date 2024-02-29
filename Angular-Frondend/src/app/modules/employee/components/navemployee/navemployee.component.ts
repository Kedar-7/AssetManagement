import { Component } from '@angular/core';

@Component({
  selector: 'app-navemployee',
  templateUrl: './navemployee.component.html',
  styleUrls: ['./navemployee.component.css']
})
export class NavemployeeComponent {
  deleteToken() {
    localStorage.removeItem('jwtToken');
  }
}
