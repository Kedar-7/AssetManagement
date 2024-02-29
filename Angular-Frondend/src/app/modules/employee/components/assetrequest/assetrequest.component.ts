import { Component, Injector } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AssetRequest } from 'src/app/models/assetrequest';
import { AssetrequestService } from 'src/app/services/assetrequest.service';

@Component({
  selector: 'app-assetrequest',
  templateUrl: './assetrequest.component.html',
  styleUrls: ['./assetrequest.component.css']
})
export class AssetrequestComponent {
/*
  assetRequestForm!: FormGroup;
  submitted!: boolean;


constructor(private formBuilder: FormBuilder){}

ngOnInit() {

  this.assetRequestForm = this.formBuilder.group({
  dateOfRequet:['',[Validators.required]],
requestType:['',[Validators.required , Validators.minLength(5)] ],
status:['',[Validators.required ] ],
assetModel:['',[Validators.required , Validators.minLength(5)] ],
assetId:['',[Validators.required] ],
employeeId:['',[Validators.required]],
  });

}

get f(){

  return this.assetRequestForm.controls;

}

onSubmit(form: FormGroup){

  this.submitted = true;

if(this.assetRequestForm.invalid){

    return;

}
else{
alert('Form submission successful ');
console.log(this.f['name'].value);

}

}

*/
assetRequestForm!: FormGroup;
submitted!: boolean;

private assetRequestService: AssetrequestService;




constructor(private formBuilder: FormBuilder,private injector: Injector){
this.assetRequestService = this.injector.get(AssetrequestService);

}

ngOnInit() {

this.assetRequestForm = this.formBuilder.group({
  dateRequested:['',[Validators.required]],
  requestType:['',[Validators.required , Validators.minLength(3)] ],
status:['',[Validators.required ] ],
assetId:['',[Validators.required] ],
employeeId:['',[Validators.required]],
});

}

get f(){

return this.assetRequestForm.controls;

}

onSubmit(){

this.submitted = true;

if(this.assetRequestForm.invalid){

  return;

}
else{
alert('Form submission successful ');
console.log(this.f['dateRequested'].value);

}

}

insertAssetRequest(){
const data: AssetRequest = {
  dateRequested: this.assetRequestForm.value.dateRequested,
  requestType: this.assetRequestForm.value.requestType,
  status: this.assetRequestForm.value.status,
  assetId: this.assetRequestForm.value.assetId,
  employeeId: this.assetRequestForm.value.employeeId,
  requestId:0
};
this.assetRequestService.insert(this.assetRequestForm.value.employeeId, this.assetRequestForm.value.assetId, data)
.subscribe(
  (response) => {
    console.log('Asset request inserted successfully:', response);
    this.assetRequestForm.reset();
  },
  (error) => {
    console.error('Error inserting asset request:', error);
  }
);
}
onAssetRequestFormSubmit() {
this.onSubmit();
this.insertAssetRequest();
}
}
