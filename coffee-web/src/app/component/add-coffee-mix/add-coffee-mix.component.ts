import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeMix } from '../../model/coffee-mix';
import { CoffeeMixService } from '../../service/coffee-mix-service';

@Component({
  selector: 'app-add-coffee-mix',
  templateUrl: './add-coffee-mix.component.html',
  styleUrls: ['./add-coffee-mix.component.css']
})
export class AddCoffeeMixComponent {

  coffeeMix: CoffeeMix;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: CoffeeMixService) {
    this.coffeeMix = new CoffeeMix();
  }

  onSubmit() {
    this.coffeeMixService.save(this.coffeeMix).subscribe(() => this.gotoCoffeeOverview());
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']).then(r => console.log(r));
  }
}
