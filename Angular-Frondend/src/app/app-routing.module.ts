import { NgModule, importProvidersFrom } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeelistComponent } from './modules/admin/components/employeelist/employeelist.component';
import { AddassetComponent } from './modules/admin/components/addasset/addasset.component';
import { AddemployeeComponent } from './modules/home/components/addemployee/addemployee.component';
import { AssetrequestComponent } from './modules/employee/components/assetrequest/assetrequest.component';
import { AssetservicerequestComponent } from './modules/employee/components/assetservicerequest/assetservicerequest.component';
import { LoginComponent } from './modules/home/components/login/login.component';
import { AssetdetailsComponent } from './modules/admin/components/assetdetails/assetdetails.component';
import { HomeComponent } from './modules/home/components/home/home.component';
import { AdmindashboardComponent } from './modules/admin/components/admindashboard/admindashboard.component';
import { authGuard } from './guards/auth.guard';
import { AuthguardService } from './services/authguard.service';

const routes: Routes = [
  // {path: '', component: HomeComponent},
  // {path: 'admin', component: AdmindashboardComponent },
  // {path: 'employeelist', component: EmployeelistComponent},
  // {path: 'assetlist', component: AssetdetailsComponent},
  // {path: 'addasset', component: AddassetComponent},
  // {path: 'addemployee', component: AddemployeeComponent},
  // {path: 'assetrequest', component: AssetrequestComponent},
  // {path: 'assetservicerequest', component: AssetservicerequestComponent},
  // {path: 'login', component: LoginComponent},

  {path: '',
  
  loadChildren: () => import('./modules/home/home.module').then((m)=> m.HomeModule)},

  {path: 'admin', 
  canActivate: [AuthguardService],
  loadChildren: () => import('./modules/admin/admin.module').then((m)=> m.AdminModule)},

  {path: 'employee', 
  canActivate: [AuthguardService],
  loadChildren: () => import('./modules/employee/employee.module').then((m)=> m.EmployeeModule)}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
