import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AddCoffeeMixComponent } from './add-coffee-mix.component';

describe('CoffeeMixFormComponent', () => {
  let component: AddCoffeeMixComponent;
  let fixture: ComponentFixture<AddCoffeeMixComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddCoffeeMixComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCoffeeMixComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
