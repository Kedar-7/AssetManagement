import { Component } from '@angular/core';
import { NgConfirmService } from 'ng-confirm-box';
import { Asset } from 'src/app/models/asset';
import { AssetService } from 'src/app/services/asset.service';

@Component({
  selector: 'app-assetdetails',
  templateUrl: './assetdetails.component.html',
  styleUrls: ['./assetdetails.component.css']
})
export class AssetdetailsComponent {
  // assetList:Asset[]= [];

  // constructor(private assetService: AssetService){}

  // ngOnInit(){
  //   this.getAllAssets();
  // }

  // getAllAssets(){
  //   this.assetService.getAll().subscribe( 
  //     (list)=>{ this.assetList = list;  console.log(list)}
      
  //       );
  // }

  // deleteById(assetId:number){
  //   this.assetService.delete(assetId).subscribe( (msg)=>{ console.log("Deleted the employeee with Id"+assetId+msg);});
  //   this.getAllAssets();
      
  // }

  assetList:Asset[]= [];
  asset!:any;
  showTables:string='';
  select: string='';
searchName: string='';
category: string='';
status: string='';

  constructor(private assetService: AssetService,private confirmService: NgConfirmService){}

  ngOnInit(){
    this.getAllAssets();
    this.showTables='name';
  }

  getAllAssets(){
    this.assetService.getAll().subscribe( 
      (list)=>{ this.assetList = list;  console.log(list)}
      
        );
  }

  deleteById(assetId:number){
    this.confirmService.showConfirm('Are you sure you want to delete?', 
    ()=>{
      this.assetService.delete(assetId).subscribe( (msg)=>{ console.log("Deleted the asset with Id"+assetId+msg);},
      (error) => {
        console.error("Error deleting asset:", error);
      });
      this.getAllAssets();
      this.showTables='name';

        
    },
    ()=>{
      
    }
    
    
    )
      
  }

  searchByName(assetName:string){
  
    this.assetService.searchByName(assetName).subscribe((list)=>{
      this.assetList = list;
      console.log(list);
      
    })
  }

  searchById(assetId:string){

    this.assetService.searchById(assetId).subscribe((asset)=>{
      this.asset = asset;
      console.log(asset);
      
    })
  }

  updateStatus(event:any,status:string, id:number){

    this.confirmService.showConfirm('Are you sure you want to delete?', 
    ()=>{
      this.assetService.updateStatus(status, id).subscribe((asset)=>{
        this.asset = asset;
        console.log(asset);

        this.getAllAssets();
        this.showTables='name';
        
      })    
    },
    ()=>{
      
    }
    
    
    
    )
    
  
    

  }



displayByCategory(category:string){
  console.log(category);
  
  this.assetService.displayByCategory(category).subscribe((list)=>{
    this.assetList = list;
    console.log(this.assetList);
    
  })
}

performSearch(searchName:string,select:string){

  if(select == 'assetName'){
    
    this.searchByName(searchName);
    this.showTables='name';
  }
  else if(select == 'assetId'){
    console.log(select);
    this.searchById(searchName);
    this.showTables='id';

    
  }
}

displayAll(){
  this.getAllAssets();
  this.showTables='name';

}
}
