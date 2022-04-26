import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeMixListComponent } from './coffee-mix-list.component';

describe('CoffeeMixListComponent', () => {
  let component: CoffeeMixListComponent;
  let fixture: ComponentFixture<CoffeeMixListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoffeeMixListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoffeeMixListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
