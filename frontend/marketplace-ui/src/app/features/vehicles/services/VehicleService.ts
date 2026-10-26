import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable } from "rxjs";
import { Vehicle } from "../models/Vehicle";

@Injectable({
    providedIn: 'root'
})
export class VehicleService {
    private http = inject(HttpClient);
    private apiURL = '/api/v1/vehicles';

    getVehicles(): Observable<Vehicle[]> {
        return this.http.get<Vehicle[]>(this.apiURL);
    }
}