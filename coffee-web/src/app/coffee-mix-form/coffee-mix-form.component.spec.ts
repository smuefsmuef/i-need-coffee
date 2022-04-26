import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeMixFormComponent } from './coffee-mix-form.component';

describe('CoffeeMixFormComponent', () => {
  let component: CoffeeMixFormComponent;
  let fixture: ComponentFixture<CoffeeMixFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoffeeMixFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoffeeMixFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
