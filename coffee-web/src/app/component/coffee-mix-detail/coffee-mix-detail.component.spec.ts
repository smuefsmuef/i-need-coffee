import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeMixDetailComponent } from './coffee-mix-detail.component';

describe('CoffeeMixDetailComponent', () => {
  let component: CoffeeMixDetailComponent;
  let fixture: ComponentFixture<CoffeeMixDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoffeeMixDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoffeeMixDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
