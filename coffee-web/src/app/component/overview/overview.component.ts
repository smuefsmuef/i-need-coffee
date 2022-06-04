import { AfterViewInit, Component, OnInit } from '@angular/core';
import { CoffeeMix } from '../../model/coffee-mix';
import { ApiService } from '../../service/api-service';
import { RatingDialogComponent } from './rating-dialog/rating-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css'],
})
export class OverviewComponent implements OnInit {
  coffeeMixes: CoffeeMix[] | undefined;

  // table
  displayedColumns: string[] = [
    'id',
    'name',
    'pricePerKg',
    'roastDegree',
    'totalRatings',
    'ratings',
    'link',
  ];

  // dialog
  name: string;
  ratings: string;

  constructor(
    private coffeeMixService: ApiService,
    public dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit() {
    this.coffeeMixService
      .findAll()
      .subscribe((data: CoffeeMix[] | undefined) => {
        this.coffeeMixes = data;
      });
  }

  openDialog(item): void {
    const dialogRef = this.dialog.open(RatingDialogComponent, {
      width: '60%',
      height: 'auto',
      data: { id: item.id, name: item.name }, // share data with dialog
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.ratings = result;
    });
  }
}
