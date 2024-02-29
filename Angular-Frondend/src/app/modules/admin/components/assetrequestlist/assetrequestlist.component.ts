import { Component } from '@angular/core';
import { AssetRequest } from 'src/app/models/assetrequest';
import { AssetrequestService } from 'src/app/services/assetrequest.service';

@Component({
  selector: 'app-assetrequestlist',
  templateUrl: './assetrequestlist.component.html',
  styleUrls: ['./assetrequestlist.component.css']
})
export class AssetrequestlistComponent {
  assetRequestList:AssetRequest[]= [];

  constructor(private assetRequestService: AssetrequestService){}

  ngOnInit(){
    this.getAllAssetRequests();
  }

  // getAllAssetRequests(){
  //   this.assetRequestService.getAll().subscribe( 
  //     (list)=>{ this.assetRequestList = list;  console.log(list)
  //     }
      
  //       );
  // }

//   getAllAssetRequests() {
//     this.assetRequestService.getAll().subscribe(
//         (list) => {
//             this.assetRequestList = list.map(assetRequest => ({
//                 ...assetRequest,
//                 assetId: assetRequest.asset ? assetRequest.asset.assetId : 0,
//                 employeeId: assetRequest.employee ? assetRequest.employee.employeeId : 0
//             }));
//             console.log(this.assetRequestList);
//         }
//     );
// }

getAllAssetRequests() {
  this.assetRequestService.getAll().subscribe((data:AssetRequest[])=>{
    this.assetRequestList = data;        

  })
}



  deleteById(requestId:number){
    this.assetRequestService.delete(requestId).subscribe( (msg)=>{ console.log("Deleted the employeee with Id"+requestId+msg);});
    this.getAllAssetRequests();
      
  }

}
