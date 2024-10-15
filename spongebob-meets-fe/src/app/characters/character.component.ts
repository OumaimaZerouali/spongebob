import {Component, OnInit} from '@angular/core';
import {Character, CharacterService} from "./service/character-service";

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [],
  templateUrl: './character.component.html',
  styleUrl: './character.component.scss'
})
export class CharacterComponent implements OnInit{
  characters: Character[] = [];

  constructor(private characterService: CharacterService) {}

  ngOnInit(): void {
    this.loadCharacters();
  }

  loadCharacters(): void {
    this.characterService.getAllCharacters().subscribe(data => {
      this.characters = data;
    });
  }
}
