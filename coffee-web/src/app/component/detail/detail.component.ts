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
  selector: 'app-detail', templateUrl: './detail.component.html', styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  coffeeMix: CoffeeMix;
  editMode: boolean = false;
  dataSource: any;
  coffeeMixId: number

  // table
  displayedColumns: string[] = ['rating', 'name', 'review', 'amount', 'grind', 'createdDate'];

  constructor(private route: ActivatedRoute, private router: Router, private coffeeMixService: CoffeeMixService) {
    this.coffeeMix = new CoffeeMix();
  }

  ngOnInit(): void {
    this.route.params.subscribe(value => {
      this.coffeeMixId = value['id'];
    });

    this.coffeeMixService.findCoffeeMixById(this.coffeeMixId).subscribe((data: CoffeeMix | undefined) => {
      this.coffeeMix = data;
      this.dataSource = this.coffeeMix.ratings
    });
  }

  onSubmit() {
    console.log('submit patch', this.coffeeMix)
    this.coffeeMixService.update(this.coffeeMix, this.coffeeMixId).subscribe(() => this.gotoCoffeeOverview());
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']);
  }

}
