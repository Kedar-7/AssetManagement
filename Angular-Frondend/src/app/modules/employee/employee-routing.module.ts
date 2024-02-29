import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from '../admin/components/admindashboard/admindashboard.component';
import { AssetrequestComponent } from './components/assetrequest/assetrequest.component';
import { AssetservicerequestComponent } from './components/assetservicerequest/assetservicerequest.component';
import { EmployeedashboardComponent } from './components/employeedashboard/employeedashboard.component';
import { EmployeehomeComponent } from './components/employeehome/employeehome.component';
import { UserslistComponent } from './components/userslist/userslist.component';


const routes: Routes = [

  { path: '', redirectTo: 'employeehome', pathMatch: 'full' },

  {path: '', component: EmployeedashboardComponent,
  children: [
    
  {path: 'assetrequest', component: AssetrequestComponent},
  {path: 'assetservicerequest', component: AssetservicerequestComponent},
  {path: 'employeehome', component: EmployeehomeComponent},
  {path: 'userslist', component: UserslistComponent}


  ]

}



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { 

}
