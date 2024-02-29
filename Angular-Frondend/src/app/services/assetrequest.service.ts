import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AssetRequest } from '../models/assetrequest';

@Injectable({
  providedIn: 'root'
})
export class AssetrequestService {

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwtToken');
    //const token = this.jwtService.getStoredToken();
     return new HttpHeaders({
       'Content-Type': 'application/json',
 
       'Authorization': "Bearer "+ token
        
        
     });  
   }

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8080/assetrequests/';

  insert(employeeId: number, assetId: number, body: AssetRequest): Observable<AssetRequest> {
    const url = this.baseURL+`add/${employeeId}/${assetId}`;
    console.log(body);
    return this.http.post<AssetRequest>(url, body,{headers:this.getHeaders()});
  }
  

  getAll():Observable<AssetRequest[]>{
        return this.http.get<AssetRequest[]>(this.baseURL+"displayAllRequest",{headers:this.getHeaders()  },);
    }
    
  delete(requestId:number):Observable<string>{
    
      return  this.http.delete<string>(this.baseURL+`delete/${requestId}`,{headers:this.getHeaders()});
    
    }

}
