import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Character {
  firstName: string,
  lastName: string,
  occupation: string,
  motto: string,
  imageUrl: string
}

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  private apiUrl = 'http://localhost:8080/characters';

  constructor(private http: HttpClient) {
  }

  getAllCharacters(): Observable<Character[]> {
    return this.http.get<Character[]>(this.apiUrl);
  }
}
