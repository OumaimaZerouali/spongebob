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

  getCharacterByName(firstName: string, lastName: string): Observable<Character> {
    const url = `${this.apiUrl}/${firstName}/${lastName}`;
    return this.http.get<Character>(url);
  }

  updateCharacter(character: Character): Observable<void> {
    const url = `${this.apiUrl}`;
    return this.http.post<void>(url, character);
  }

  deleteCharacter(firstName: string, lastName: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${firstName}/${lastName}`);
  }
}
