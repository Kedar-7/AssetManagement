import { Component, ElementRef } from '@angular/core';
import { NgConfirmService } from 'ng-confirm-box';

@Component({
  selector: 'app-navemployee',
  templateUrl: './navemployee.component.html',
  styleUrls: ['./navemployee.component.css']
})
export class NavemployeeComponent {

  constructor(private elementRef: ElementRef, private confirmService:NgConfirmService) {}
  checkToken(){

    if(localStorage.getItem('jwtToken')==null){
      return true;
    }
    else return false;


  }

  deleteToken() {

    this.confirmService.showConfirm('Are you sure?',
    ()=>{
      localStorage.removeItem('jwtToken');
    },
    ()=>{

    }
    )

   
  }
}
