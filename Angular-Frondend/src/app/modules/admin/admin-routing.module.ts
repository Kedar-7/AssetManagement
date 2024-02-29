import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';
import { AddemployeeComponent } from 'src/app/modules/home/components/addemployee/addemployee.component';
import { LoginComponent } from 'src/app/modules/home/components/login/login.component';
import { AddassetComponent } from './components/addasset/addasset.component';
import { AssetdetailsComponent } from './components/assetdetails/assetdetails.component';
import { AssetrequestComponent } from '../employee/components/assetrequest/assetrequest.component';
import { AssetservicerequestComponent } from '../employee/components/assetservicerequest/assetservicerequest.component';
import { AssetrequestlistComponent } from './components/assetrequestlist/assetrequestlist.component';
import { AssetservicerequestlistComponent } from './components/assetservicerequestlist/assetservicerequestlist.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { UpdateemployeeComponent } from './components/updateemployee/updateemployee.component';
import { UpdateassetComponent } from './components/updateasset/updateasset.component';

const routes: Routes = [
  { path: '', redirectTo: 'adminhomepage', pathMatch: 'full' },

  {path: '', component: AdmindashboardComponent,
  children: [
    {path: 'employeelist', component: EmployeelistComponent},
  {path: 'assetlist', component: AssetdetailsComponent},
  {path: 'addasset', component: AddassetComponent},
  {path: 'addemployee', component: AddemployeeComponent},
  // {path: 'assetrequest', component: AssetrequestComponent},
  // {path: 'assetservicerequest', component: AssetservicerequestComponent},
  {path: 'assetrequestlist', component: AssetrequestlistComponent},
  {path: 'assetservicerequestlist', component: AssetservicerequestlistComponent},
  {path: 'update/:employeeId', component: UpdateemployeeComponent},

  {path: 'updateasset/:assetId', component: UpdateassetComponent},

  {path: 'adminhomepage', component: AdminhomeComponent}

  ]

}



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
