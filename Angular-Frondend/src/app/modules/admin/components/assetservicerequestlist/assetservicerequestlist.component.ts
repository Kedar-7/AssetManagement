import { Component } from '@angular/core';
import { AssetServiceRequest } from 'src/app/models/assetservicerequest';
import { AssetservicerequestService } from 'src/app/services/assetservicerequest.service';

@Component({
  selector: 'app-assetservicerequestlist',
  templateUrl: './assetservicerequestlist.component.html',
  styleUrls: ['./assetservicerequestlist.component.css']
})
export class AssetservicerequestlistComponent {

  assetServiceRequestList:AssetServiceRequest[]= [];

  constructor(private assetServiceRequestService:  AssetservicerequestService){}

  ngOnInit(){
    this.getAllAssetServiceRequests();
  }

  getAllAssetServiceRequests(){
    this.assetServiceRequestService.getAll().subscribe( 
      (list)=>{ this.assetServiceRequestList = list;  console.log(list)
      }
      
        );
  }

  deleteById(serviceRequestId:number){
    this.assetServiceRequestService.delete(serviceRequestId).subscribe( (msg)=>{ console.log("Deleted the employeee with Id"+serviceRequestId+msg);});
    this.getAllAssetServiceRequests();
     

}
}
