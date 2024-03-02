import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AssetAudit } from '../models/assetaudit';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssetauditService {
  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwtToken');
    //const token = this.jwtService.getStoredToken();
     return new HttpHeaders({
       'Content-Type': 'application/json',
 
       'Authorization': "Bearer "+ token
        
        
     });  
   }

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8080/assetaudit/';

  getAll():Observable<AssetAudit[]>{
    return this.http.get<AssetAudit[]>(this.baseURL+"displayAllAudits",{headers:this.getHeaders()  },);
}
delete(assetAuditId:number):Observable<string>{
    
  return  this.http.delete<string>(this.baseURL+`deleteAudit/${assetAuditId}`,{headers:this.getHeaders()});

}

}
