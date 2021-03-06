import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CoffeeMix } from '../../model/coffee-mix';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../service/api-service';
import { Rating } from '../../model/rating';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent } from '@angular/material/chips';
import { FormControl } from '@angular/forms';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';

export interface Bean {
  type: string;
}

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css'],
})
export class DetailComponent implements OnInit {
  coffeeMix: CoffeeMix;
  ratings: Rating;
  editMode: boolean = false;
  coffeeMixId: number;
  ratingDateFormatted: number;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  displayedColumns: string[] = [
    'name',
    'rating',
    'review',
    'amount',
    'grind',
    'createdDate',
  ];
  beanCtrl = new FormControl();
  allBeans: Bean[];
  beans: Bean[];

  @ViewChild('beanInput') beanInput: ElementRef<HTMLInputElement>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeMixService: ApiService
  ) {
    this.coffeeMix = new CoffeeMix();
  }

  ngOnInit(): void {
    this.route.params.subscribe((value) => {
      this.coffeeMixId = value['id'];
    });

    this.coffeeMixService
      .findCoffeeMixById(this.coffeeMixId)
      .subscribe((data: CoffeeMix | undefined) => {
        this.coffeeMix = data;
      });

    this.coffeeMixService
      .findRatingByCoffeeMixId(this.coffeeMixId)
      .subscribe((data: Rating | undefined) => {
        this.ratings = data;
      });

    this.coffeeMixService
      .findAllBeans()
      .subscribe((data: Bean[] | undefined) => {
        this.allBeans = data;
        console.log(this.allBeans, 'all beans');
      });
  }

  onSubmit() {
    this.coffeeMixService
      .update(this.coffeeMix, this.coffeeMixId)
      .subscribe(() => console.log('saved'));
    this.gotoCoffeeOverview();
  }

  gotoCoffeeOverview() {
    this.router.navigate(['']);
  }

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    if (value) {
      // Add a new bean
      this.coffeeMixService.add({ type: value }).subscribe((response) =>
        // Push to list - update beans
        this.coffeeMix.beans.push({ id: response.body.id, type: value })
      );
    }
    event.chipInput!.clear();
    this.beanCtrl.setValue(null);
  }

  remove(bean: Bean): void {
    const index = this.coffeeMix.beans.indexOf(bean);
    if (index >= 0) {
      this.coffeeMix.beans.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    const bean = event.option.value;
    this.coffeeMix.beans.push({id: bean.id, type: bean.type});
    this.beanInput.nativeElement.value = '';
    this.beanCtrl.setValue(null);
  }

  deleteCoffeeMixById(id) {
    this.coffeeMixService.deleteCoffeeMixById(id).subscribe((response) =>
      // console.log(response, 'delete ok')
      this.gotoCoffeeOverview()
    );
  }
}
