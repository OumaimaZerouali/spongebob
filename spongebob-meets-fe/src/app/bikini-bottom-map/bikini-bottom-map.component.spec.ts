import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BikiniBottomMapComponent } from './bikini-bottom-map.component';

describe('BikiniBottomMapComponent', () => {
  let component: BikiniBottomMapComponent;
  let fixture: ComponentFixture<BikiniBottomMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BikiniBottomMapComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BikiniBottomMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
