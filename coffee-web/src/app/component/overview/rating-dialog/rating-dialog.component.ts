import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../../../model/dialog-data";
import {ActivatedRoute, Router} from "@angular/router";
import {CoffeeMixService} from "../../../service/coffee-mix-service";
import {CoffeeMix} from "../../../model/coffee-mix";
import {Rating} from "../../../model/rating";

@Component({
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css']
})
export class RatingDialogComponent {
  rating: Rating;

  constructor(public dialogRef: MatDialogRef<RatingDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData,
              private route: ActivatedRoute,
              private router: Router,
              private coffeeMixService: CoffeeMixService) {
    this.rating = new Rating();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onSubmit() {
    console.log('submit', this.rating)
    this.coffeeMixService.addRating(this.rating).subscribe(() => this.gotoCoffeeOverview());
    this.dialogRef.close();
  }

  gotoCoffeeOverview() {
    //  this.router.navigate(['/coffeemix']);
    this.router.navigate(['']);
  }

}
