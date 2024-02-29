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
    
  delete(requestId:number):Observable<string>{
    
      return  this.http.delete<string>(this.baseURL+`deleteById/${requestId}`);
    
    }
}
