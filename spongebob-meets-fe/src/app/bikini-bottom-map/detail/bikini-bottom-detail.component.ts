import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LocationService, Location } from '../service/location-service';

@Component({
  selector: 'bikini-bottom-detail',
  standalone: true,
  templateUrl: './bikini-bottom-detail.component.html',
  styleUrls: ['./bikini-bottom-detail.component.scss']
})
export class BikiniBottomDetailComponent implements OnInit {
  location!: Location | null;

  constructor(
    private route: ActivatedRoute,
    private locationService: LocationService
  ) {}

  ngOnInit(): void {
    const locationName = this.route.snapshot.paramMap.get('name');
    if (locationName) {
      this.fetchLocationDetails(locationName);
    }
  }

  private fetchLocationDetails(name: string): void {
    this.locationService.getLocationByName(name).subscribe({
      next: (location) => {
        this.location = location;
      },
      error: (err) => {
        console.error('Failed to fetch location details:', err);
        this.location = null;
      }
    });
  }
}
