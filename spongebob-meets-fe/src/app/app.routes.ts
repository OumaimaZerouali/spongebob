import {Routes} from '@angular/router';
import {CharactersComponent} from "./characters/characters.component";
import {CharacterComponent} from "./characters/character/character.component";
import {BikiniBottomMapComponent} from "./bikini-bottom-map/bikini-bottom-map.component";
import {BikiniBottomDetailComponent} from "./bikini-bottom-map/detail/bikini-bottom-detail.component";
import {QuizComponent} from "./quiz/quiz.component";
import {HomeComponent} from "./home/home.component";

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'characters', component: CharactersComponent },
  { path: 'characters/:firstName/:lastName', component: CharacterComponent },
  { path: 'bikini-bottom', component: BikiniBottomMapComponent },
  { path: 'location/:name', component: BikiniBottomDetailComponent },
  { path: 'quiz', component: QuizComponent }
];
