import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddemployeeComponent } from './modules/home/components/addemployee/addemployee.component';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpResponse } from '@angular/common/http';
import { AddassetComponent } from './modules/admin/components/addasset/addasset.component';
import { EmployeelistComponent } from './modules/admin/components/employeelist/employeelist.component';
import { NavbarComponent } from './modules/admin/components/navbar/navbar.component';
import { AssetrequestComponent } from './modules/employee/components/assetrequest/assetrequest.component';
import { AssetservicerequestComponent } from './modules/employee/components/assetservicerequest/assetservicerequest.component';
import { AssetlistComponent } from './modules/admin/components/assetlist/assetlist.component';
import { LoginComponent } from './modules/home/components/login/login.component';
import { AssetdetailsComponent } from './modules/admin/components/assetdetails/assetdetails.component';
import { HomeComponent } from './modules/home/components/home/home.component';
import { AdmindashboardComponent } from './modules/admin/components/admindashboard/admindashboard.component';
import { NavhomeComponent } from './modules/home/components/navhome/navhome.component'
import { NgConfirmModule } from 'ng-confirm-box';
import { UpdateemployeeComponent } from './modules/admin/components/updateemployee/updateemployee.component';
import { authGuard } from './guards/auth.guard';
@NgModule({
  declarations: [
    AppComponent,
    AddemployeeComponent,
    AddassetComponent,
    EmployeelistComponent,
    NavbarComponent,
    AssetrequestComponent,
    AssetservicerequestComponent,
    AssetlistComponent,
    LoginComponent,
    AssetdetailsComponent,
    HomeComponent,
    AdmindashboardComponent,
    NavhomeComponent,
    UpdateemployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgConfirmModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
