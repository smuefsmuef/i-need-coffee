import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeMix } from '../../model/coffee-mix';
import { ApiService } from '../../service/api-service';

@Component({
  selector: 'app-add-coffee-mix',
  templateUrl: './add-coffee-mix.component.html',
  styleUrls: ['./add-coffee-mix.component.css'],
})
export class AddCoffeeMixComponent {
  coffeeMix: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: ApiService
  ) {
    this.coffeeMix = new CoffeeMix();
  }

  onSubmit() {
    this.coffeeMixService
      .save(this.coffeeMix)
      .subscribe((response) => this.gotoCoffeeDetail(response.body.id));
  }

  gotoCoffeeDetail(id) {
    this.router.navigate([`/coffeemix/${id}`]).then((r) => console.log(r));
  }
}
