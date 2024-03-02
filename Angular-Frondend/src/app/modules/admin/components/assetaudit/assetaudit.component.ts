import { Component } from '@angular/core';
import { NgConfirmService } from 'ng-confirm-box';
import { AssetauditService } from 'src/app/services/assetaudit.service';
import { AssetrequestService } from 'src/app/services/assetrequest.service';

@Component({
  selector: 'app-assetaudit',
  templateUrl: './assetaudit.component.html',
  styleUrls: ['./assetaudit.component.css']
})
export class AssetauditComponent {
  requests: any[]=[];
  audits:any[]=[];


  constructor(private assetRequestService: AssetrequestService,private confirmService: NgConfirmService,private assetAudit: AssetauditService){}

  getAllAssetAudits() {
    this.assetAudit.getAll().subscribe( (data: any[]) => {
      this.audits = data;
      console.log(this.audits);
  
    })
  }

  ngOnInit(){
  }

  deleteById(assetAuditId:number){
    this.confirmService.showConfirm('Are you sure you want to delete?', 
    ()=>{
    this.assetAudit.delete(assetAuditId).subscribe( (msg)=>{ console.log("Deleted the request with Id"+assetAuditId+msg);});
    this.getAllAssetAudits();
    },
    ()=>{
        
    }
    
    
    )
  }

  getAllEmployeeInfo(){
    this.assetRequestService.employeeInfo().subscribe( (data: any[]) => {
      this.requests = data;
      console.log(this.requests);
  
    })
  }

}
