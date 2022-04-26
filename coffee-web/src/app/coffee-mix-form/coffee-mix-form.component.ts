import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeMix } from '../model/coffee-mix';
import { CoffeeMixService } from '../service/coffee-mix-service';

@Component({
  selector: 'app-coffee-mix-form',
  templateUrl: './coffee-mix-form.component.html',
  styleUrls: ['./coffee-mix-form.component.css']
})
export class CoffeeMixFormComponent {

  coffeeMix: CoffeeMix;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: CoffeeMixService) {
    this.coffeeMix = new CoffeeMix();
  }

  onSubmit() {
    this.coffeeMixService.save(this.coffeeMix).subscribe(() => this.gotoCoffeeMixist());
  }

  gotoCoffeeMixist() {
    this.router.navigate(['/coffeemixes']);
  }
}
