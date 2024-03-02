import { Component } from '@angular/core';
import { NgConfirmService } from 'ng-confirm-box';
import { Asset } from 'src/app/models/asset';
import { AssetService } from 'src/app/services/asset.service';

@Component({
  selector: 'app-assetlist',
  templateUrl: './assetlist.component.html',
  styleUrls: ['./assetlist.component.css']
})
export class AssetlistComponent {
  assetList:Asset[]= [];
  asset!:any;
  showTables:string='';
  select: string='';
searchName: string='';

  constructor(private assetService: AssetService,private confirmService: NgConfirmService){}

  ngOnInit(){
  }

  getAllAssets(){
    this.assetService.getAll().subscribe( 
      (list)=>{ this.assetList = list;  console.log(list)}
      
        );
  }

  deleteById(assetId:number){
    this.assetService.delete(assetId).subscribe( (msg)=>{ console.log("Deleted the employeee with Id"+assetId+msg);});
    this.getAllAssets();
      
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