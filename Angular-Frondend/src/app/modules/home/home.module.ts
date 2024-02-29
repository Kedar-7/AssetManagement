import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { NavhomeComponent } from './components/navhome/navhome.component';
import { HomepageComponent } from './components/homepage/homepage.component';


@NgModule({
  declarations: [
  
    HomepageComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }
