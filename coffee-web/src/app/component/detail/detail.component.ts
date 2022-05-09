import {Component, OnInit} from '@angular/core';
import {CoffeeMix} from '../../model/coffee-mix';
import {ActivatedRoute, Router} from '@angular/router';
import {CoffeeMixService} from '../../service/coffee-mix-service';
import {Rating} from "../../model/rating";

const ELEMENT_DATA: Rating[] =// testdata
  [{
    "id": 110,
    "rating": 3,
    "name": "petra",
    "review": "der kafi ist angenehm sauer und bll...",
    "amount": 50,
    "grind": 5,
    "createdDate": "2022-05-08",
  }, {
    "id": 111,
    "rating": 5,
    "name": "jonas",
    "review": "der kafi ist angenehm sauer und bll...",
    "amount": 30,
    "grind": 2,
    "createdDate": "2022-05-08"
  }]


@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  coffeeMix: CoffeeMix;
  editMode: boolean = false;

  // table
  displayedColumns: string[] = ['rating', 'name', 'review', 'amount', 'grind', 'createdDate'];
  dataSource = ELEMENT_DATA; // ratings todo adjust

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: CoffeeMixService) {
    this.coffeeMix = new CoffeeMix();
  }

  ngOnInit(): void {
    this.coffeeMixService.findCoffeeMixById(2222); // todo get id out of route and populate data coffeemix
  }

  onSubmit() {
    console.log('submit patch', this.coffeeMix) // todo patch/put
    this.coffeeMixService.save(this.coffeeMix).subscribe(() => this.gotoCoffeeOverview());
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']);
  }

}
