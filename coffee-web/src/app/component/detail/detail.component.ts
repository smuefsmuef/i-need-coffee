import {Component, OnInit} from '@angular/core';
import {CoffeeMix} from '../../model/coffee-mix';
import {ActivatedRoute, Router} from '@angular/router';
import {CoffeeMixService} from '../../service/coffee-mix-service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  coffeeMix: CoffeeMix;
  editMode: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: CoffeeMixService) {
    this.coffeeMix = new CoffeeMix();
  }

  ngOnInit(): void {
    this.coffeeMixService.findCoffeeMixById(2222); // todod get id out of route
  }

  onSubmit() {
    console.log('submit', this.coffeeMix)
    this.coffeeMixService.save(this.coffeeMix).subscribe(() => this.gotoCoffeeOverview());
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']);
  }

}
