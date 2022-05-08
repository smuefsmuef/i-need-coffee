import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CoffeeMix} from '../../model/coffee-mix';
import {CoffeeMixService} from '../../service/coffee-mix-service';


const ELEMENT_DATA: CoffeeMix[] =
  // testdata
  [{
    "id": 1,
    "name": "mix eins",
    "pricePerKg": 20,
    "roastDegree": 5,
    "beans": [],
    "ratings": []
  },
    {
      "id": 2,
      "name": "mix zwei",
      "pricePerKg": 14,
      "roastDegree": 4,
      "beans": [],
      "ratings": []
    }
  ]

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {

  coffeeMixes: CoffeeMix[] | undefined;

  displayedColumns: string[] = ['id', 'name', 'pricePerKg', 'roastDegree', 'ratings', 'link'];
  dataSource = ELEMENT_DATA; // todo add later coffeemixes from GET


  constructor(private coffeeMixService: CoffeeMixService) {

  }

  ngOnInit() {
    this.coffeeMixService.findAll().subscribe((data: CoffeeMix[] | undefined) => {
      console.log('juhuu data ist hier', data)
      this.coffeeMixes = data;
    });
  }


}
