import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {CoffeeMix} from '../../model/coffee-mix';
import {ApiService} from '../../service/api-service';

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
    private coffeeMixService: ApiService) {
    this.coffeeMix = new CoffeeMix();
  }

  onSubmit() {
    console.log('submit add', this.coffeeMix)
    this.coffeeMixService.save(this.coffeeMix).subscribe(() => this.gotoCoffeeOverview());
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']).then(r => console.log(r));
  }
}
