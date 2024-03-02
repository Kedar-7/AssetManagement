import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AssetServiceRequest } from '../models/assetservicerequest';

@Injectable({
  providedIn: 'root'
})
export class AssetservicerequestService {

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwtToken');
    //const token = this.jwtService.getStoredToken();
     return new HttpHeaders({
       'Content-Type': 'application/json',
 
       'Authorization': "Bearer "+ token
        
        
     });  
   } 
  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8080/assetServiceRequest/';

  
  insert(employeeId: number, assetId: number, body: AssetServiceRequest): Observable<AssetServiceRequest> {
    const url = this.baseURL+`addNewRequest/${assetId}/${employeeId}`;
    console.log(body);
    return this.http.post<AssetServiceRequest>(url, body);
  }
  

  getAll():Observable<AssetServiceRequest[]>{
        return this.http.get<AssetServiceRequest[]>(this.baseURL+"displayAllRequests",{headers:this.getHeaders()});
    }
    
  delete(serviceRequestId:number):Observable<string>{
    
      return  this.http.delete<string>(this.baseURL+`deleteById/${serviceRequestId}`,{headers:this.getHeaders()});
    
    }

    updateStatus(status:string,requestId:number){
      console.log(status+" "+requestId);
  return this.http.put(this.baseURL + "updateStatus/" + status + "/" + requestId, {}, {headers:this.getHeaders()});
    }

    getEmployeesByAssets(employeeId:string):Observable<AssetServiceRequest[]>{
      return this.http.get<AssetServiceRequest[]>(this.baseURL + `displayEmployeeInfo/${parseInt(employeeId)}`,{headers:this.getHeaders()})
    }

    getAssetsInfo(assetId:string):Observable<AssetServiceRequest[]>{
      return this.http.get<AssetServiceRequest[]>(this.baseURL + `displayAssetInfo/${parseInt(assetId)}`,{headers:this.getHeaders()})
    }


}
