import { Component, Injector } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AssetServiceRequest } from 'src/app/models/assetservicerequest';
import { AssetservicerequestService } from 'src/app/services/assetservicerequest.service';

@Component({
  selector: 'app-assetservicerequest',
  templateUrl: './assetservicerequest.component.html',
  styleUrls: ['./assetservicerequest.component.css']
})
export class AssetservicerequestComponent {
/*

  assetServiceRequestForm!: FormGroup;
  submitted!: boolean;


constructor(private formBuilder: FormBuilder){}

ngOnInit() {

  this.assetServiceRequestForm = this.formBuilder.group({
  dateOfRequet:['',[Validators.required]],
issueType:['',[Validators.required , Validators.minLength(5)] ],
status:['',[Validators.required ] ],
assetId:['',[Validators.required] ],
employeeId:['',[Validators.required]],
  });

}

get f(){

  return this.assetServiceRequestForm.controls;

}

onSubmit(form: FormGroup){

  this.submitted = true;

if(this.assetServiceRequestForm.invalid){

    return;

}
else{
alert('Form submission successful ');
console.log(this.f['name'].value);

}

}
*/

assetServiceRequestForm!: FormGroup;
  submitted!: boolean;


  private assetServiceRequestService: AssetservicerequestService;


constructor(private formBuilder: FormBuilder,private injector: Injector){
  this.assetServiceRequestService = this.injector.get(AssetservicerequestService);


}


ngOnInit() {

  this.assetServiceRequestForm = this.formBuilder.group({
    dateRequested:['',[Validators.required]],
    issueType:['',[Validators.required , Validators.minLength(5)] ],
    status:['',[Validators.required ] ],
    assetId:['',[Validators.required] ],
    employeeId:['',[Validators.required]],
  });

}

get f(){

  return this.assetServiceRequestForm.controls;

}

onSubmit(){

  this.submitted = true;

if(this.assetServiceRequestForm.invalid){

    return;

}
else{
alert('Form submission successful ');
console.log(this.f['dateRequested'].value);

}

}

insertAssetServiceRequest(){
  const data: AssetServiceRequest = {
    dateRequested: this.assetServiceRequestForm.value.dateRequested,
    issueType: this.assetServiceRequestForm.value.issueType,
    status: this.assetServiceRequestForm.value.status,
    assetId: this.assetServiceRequestForm.value.assetId,
    employeeId: this.assetServiceRequestForm.value.employeeId,
    serviceRequestId:0
  };
  this.assetServiceRequestService.insert(this.assetServiceRequestForm.value.employeeId, this.assetServiceRequestForm.value.assetId, data)
  .subscribe(
    (response) => {
      console.log('Asset request inserted successfully:', response);
      this.assetServiceRequestForm.reset();
    },
    (error) => {
      console.error('Error inserting asset request:', error);
    }
  );
}
onAssetServiceRequestFormSubmit() {
  this.onSubmit();
  this.insertAssetServiceRequest();
}
}
