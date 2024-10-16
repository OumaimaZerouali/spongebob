import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {LocationService, Location} from "./service/location-service";

@Component({
  selector: 'app-bikini-bottom-map',
  standalone: true,
  imports: [],
  templateUrl: './bikini-bottom-map.component.html',
  styleUrl: './bikini-bottom-map.component.scss'
})
export class BikiniBottomMapComponent {
  constructor(
    private router: Router,
    private locationService: LocationService
  ) {}

  navigateTo(locationName: string): void {
    this.locationService.getLocationByName(locationName).subscribe({
      next: (location: Location) => {
        console.log('Location data:', location);
        this.router.navigate(['location', locationName]);
      },
      error: (err) => {
        console.error('Failed to fetch location:', err);
      }
    });
  }
}
