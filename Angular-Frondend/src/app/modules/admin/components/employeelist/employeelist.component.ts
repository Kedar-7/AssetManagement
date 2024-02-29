import { Component } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service'; 
import { Employee } from '../../../../models/employee';
import { NgConfirmService } from 'ng-confirm-box';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent{


  employeeList:Employee[]= [];
  employee!:any;
  roles: string[]=[];
  select: string='';
searchName: string='';
 showTables:string='';
selectAdmin: string='';

  constructor(private employeeService: EmployeeService, private confirmService: NgConfirmService){}

  ngOnInit(){

    
  }
  
  getAllEmployees(){
    console.log(localStorage.getItem('token'));
    this.employeeService.getAll('token').subscribe( 
      (list)=>{ this.employeeList = list;  console.log(list)}
        );
  }

  deleteById(employeeId:number){
    this.confirmService.showConfirm('Are you sure you want to delete?', 
    ()=>{
      this.employeeService.delete(employeeId).subscribe( (msg)=>{ console.log("Deleted the employeee with Id"+employeeId+msg);});
      this.getAllEmployees();
        
    },
    ()=>{
      
    }
    
    )
   
  }

  onRoleChange(event: any, employeeId: number) {
    const selectedRole = event.target.value;
    console.log('Selected role:', selectedRole);
    console.log('Employee ID:', employeeId);

    this.confirmService.showConfirm('Are you sure you want to update?', 
    ()=>{
      return this.employeeService.updateRole(employeeId).subscribe();
    },
    ()=>{
      
    }   
    )
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
