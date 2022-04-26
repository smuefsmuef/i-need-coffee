import { Component, OnInit } from '@angular/core';
import { CoffeeMix } from '../model/coffee-mix';
import { CoffeeMixService } from '../service/coffee-mix-service';



@Component({
  selector: 'app-coffee-mix-list',
  templateUrl: './coffee-mix-list.component.html',
  styleUrls: ['./coffee-mix-list.component.css']
})
export class CoffeeMixListComponent implements OnInit {

  coffeeMixes: CoffeeMix[] | undefined;

  constructor(private coffeeMixService: CoffeeMixService) {
  }

  ngOnInit() {
    this.coffeeMixService.findAll().subscribe((data: CoffeeMix[] | undefined) => {
      this.coffeeMixes = data;
    });
  }

}
