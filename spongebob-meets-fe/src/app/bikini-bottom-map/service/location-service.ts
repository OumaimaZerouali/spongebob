import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Location {
    name: string,
    description: string,
    owner: string,
    funFact: string,
    adress: string,
    imageUrl: string
}

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiUrl = 'http://localhost:8080/locations';

  constructor(private http: HttpClient) {}

  getLocationByName(name: string): Observable<Location> {
    const url = `${this.apiUrl}/${name}`;
    return this.http.get<Location>(url);
  }
}
