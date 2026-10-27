import { CommonModule } from "@angular/common";
import { Component, inject, OnInit } from "@angular/core";
import { VehicleService } from "../services/vehicle.service";
import { Observable } from "rxjs";
import { Vehicle } from "../models/vehicle.model";

@Component({
  selector: 'app-vehicle-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehicle-list.component.html'
})
export class VehicleListComponent implements OnInit {
    private vehicleService = inject(VehicleService);

    //observable with the async pipe
    vehicles$!: Observable<Vehicle[]>;

    ngOnInit(): void {
        this.vehicles$ = this.vehicleService.getVehicles();
    }
}