import {Component, OnInit} from '@angular/core';
import {Character, CharacterService} from "./service/character-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-characters',
  standalone: true,
  imports: [],
  templateUrl: './characters.component.html',
  styleUrl: './characters.component.scss'
})
export class CharactersComponent implements OnInit{
  characters: Character[] = [];

  constructor(private characterService: CharacterService, private router: Router) {}

  ngOnInit(): void {
    this.loadCharacters();
  }

  loadCharacters(): void {
    this.characterService.getAllCharacters().subscribe(data => {
      this.characters = data;
    });
  }

  viewCharacter(character: Character) {
    this.router.navigate(['/characters', character.firstName, character.lastName]);
  }
}
