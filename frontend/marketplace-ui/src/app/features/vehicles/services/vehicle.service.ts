import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable } from "rxjs";
import { Vehicle } from "../models/vehicle.model";

@Injectable({
    providedIn: 'root'
})
export class VehicleService {
    private apiURL = '/api/v1/vehicles';

    constructor(private http: HttpClient) {}

    getVehicles(): Observable<Vehicle[]> {
        //encode user:password in base64
        const credentials = btoa('user:password');

        //basic auth headers
        const headers = new HttpHeaders().set('Authorization', `Basic ${credentials}`);

        //pass headers options in get req
        return this.http.get<Vehicle[]>(this.apiURL, { headers });
    }
}