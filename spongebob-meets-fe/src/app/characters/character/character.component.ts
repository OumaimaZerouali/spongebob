import {Component, OnInit} from '@angular/core';
import {Character, CharacterService} from "../service/character-service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './character.component.html',
  styleUrl: './character.component.scss'
})
export class CharacterComponent implements OnInit {
  characterForm: FormGroup;
  character: Character | undefined;

  constructor(
    private route: ActivatedRoute,
    private characterService: CharacterService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.characterForm = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      occupation: [''],
      motto: ['']
    });
  }

  ngOnInit(): void {
    this.loadCharacter();
  }

  loadCharacter(): void {
    const firstName = this.route.snapshot.paramMap.get('firstName') || '';
    const lastName = this.route.snapshot.paramMap.get('lastName') || '';

    this.characterService.getCharacterByName(firstName, lastName).subscribe(character => {
      this.character = character;
      this.characterForm.patchValue({
        firstName: character.firstName,
        lastName: character.lastName,
        occupation: character.occupation,
        motto: character.motto
      });
    });
  }

  updateCharacter(): void {
    if (this.character) {
      const updatedCharacter: Character = {
        ...this.character,
        ...this.characterForm.value
      };

      this.characterService.updateCharacter(updatedCharacter).subscribe(() => {
        location.reload();
      });
    }
  }

  deleteCharacter(): void {
    if (this.character) {
      this.characterService.deleteCharacter(this.character.firstName, this.character.lastName).subscribe(() => {
        alert('Character deleted successfully!');
        this.router.navigate(['/characters']);
      });
    }
  }
}
