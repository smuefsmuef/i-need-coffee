import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {DialogData} from '../../../model/dialog-data';
import {ActivatedRoute, Router} from '@angular/router';
import {ApiService} from '../../../service/api-service';
import {Rating} from '../../../model/rating';

@Component({
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css'],
})
export class RatingDialogComponent {
  rating: Rating;

  constructor(
    public dialogRef: MatDialogRef<RatingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: ApiService
  ) {
    this.rating = new Rating();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onSubmit() {
    this.coffeeMixService
      .addRating(this.rating, this.data.id)
      .subscribe(() => this.gotoCoffeeOverview());
    this.dialogRef.close();
  }

  gotoCoffeeOverview() {
    this.router.navigate(['']);
  }
}
