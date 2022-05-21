import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CoffeeMix} from '../../model/coffee-mix';
import {CoffeeMixService} from '../../service/coffee-mix-service';
import {RatingDialogComponent} from "./rating-dialog/rating-dialog.component";
import {MatDialog} from "@angular/material/dialog";


const ELEMENT_DATA: CoffeeMix[] = // testdata
  [{
    "id": 1, "name": "mix eins", "pricePerKg": 20, "roastDegree": 5, "beans": [], "ratings": []
  }, {
    "id": 2, "name": "mix zwei", "pricePerKg": 14, "roastDegree": 4, "beans": [], "ratings": [{
      "id": 110,
      "rating": 3,
      "name": "petra",
      "review": "der kafi ist angenehm sauer und bll...",
      "amount": 50,
      "grind": 5,
      "createdDate": "2022-05-08",
      "coffeeMix": "string"
    }, {
      "id": 111,
      "rating": 5,
      "name": "jonas",
      "review": "der kafi ist angenehm sauer und bll...",
      "amount": 30,
      "grind": 2,
      "createdDate": "2022-05-08",
      "coffeeMix": "string"
    }]
  }]

@Component({
  selector: 'app-overview', templateUrl: './overview.component.html', styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {

  coffeeMixes: CoffeeMix[] | undefined;

  // table
  displayedColumns: string[] = ['id', 'name', 'pricePerKg', 'roastDegree', 'ratings', 'link'];

  // dialog
  name: string;
  ratings: string;

  constructor(private coffeeMixService: CoffeeMixService, public dialog: MatDialog) {

  }

  ngOnInit() {
    this.coffeeMixService.findAll().subscribe((data: CoffeeMix[] | undefined) => {
      this.coffeeMixes = data;
    });
  }


  openDialog(item): void {
    const dialogRef = this.dialog.open(RatingDialogComponent, {
      width: '60%', height: 'auto', data: {ratings: item.ratings, name: item.name}, // share data with dialog
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log('result', result);
      this.ratings = result
    });
  }
}
