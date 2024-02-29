import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeedashboardComponent } from './components/employeedashboard/employeedashboard.component';
import { NavemployeeComponent } from './components/navemployee/navemployee.component';
import { EmployeehomeComponent } from './components/employeehome/employeehome.component';
import { UserslistComponent } from './components/userslist/userslist.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AssetrequestComponent } from './components/assetrequest/assetrequest.component';
import { AssetservicerequestComponent } from './components/assetservicerequest/assetservicerequest.component';


@NgModule({
  declarations: [
    EmployeedashboardComponent,
    NavemployeeComponent,
    EmployeehomeComponent,
    UserslistComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }
