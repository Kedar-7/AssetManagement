import { Component } from '@angular/core';
import { NgConfirmService } from 'ng-confirm-box';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-userslist',
  templateUrl: './userslist.component.html',
  styleUrls: ['./userslist.component.css']
})
export class UserslistComponent {
  employeeList:Employee[]= [];
  employee!:any;
  roles: string[]=[];
  select: string='';
searchName: string='';
 showTables:string='';
selectAdmin: string='';

  constructor(private employeeService: EmployeeService, private confirmService: NgConfirmService){}



getAllEmployees(){
    console.log(localStorage.getItem('token'));
    this.employeeService.getAll('token').subscribe( 
      (list)=>{ this.employeeList = list;  console.log(list)}
        );
  }



seachByName(employeeName:string){
  
    this.employeeService.serchByName(employeeName).subscribe((list)=>{
      this.employeeList = list;
      console.log(list);
      
    })
  }
  seachById(employeeId:string){

    this.employeeService.serchById(employeeId).subscribe((emp)=>{
      this.employee = emp;
      console.log(emp);
      
    })
  }






performSearch(searchName:string,select:string){

    if(select == 'employeeName'){
      
      this.seachByName(searchName);
      this.showTables='name';
    }
    else if(select == 'employeeId'){
      console.log(select);
      this.seachById(searchName);
      this.showTables='id';

      
    }

  }

  displayAll(){
    this.getAllEmployees();
    this.showTables='name';

  }




}
