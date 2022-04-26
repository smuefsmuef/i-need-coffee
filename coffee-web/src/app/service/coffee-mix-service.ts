import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// @ts-ignore
import { Observable } from 'rxjs/Observable';
import { CoffeeMix } from '../model/coffee-mix';

@Injectable()
export class CoffeeMixService {

  private coffeMixesUrl: string;

  constructor(private http: HttpClient) {
    this.coffeMixesUrl = 'http://localhost:8080/coffeemixes';
  }

  public findAll(): Observable<CoffeeMix[]> {
    return this.http.get<CoffeeMix[]>(this.coffeMixesUrl);
  }

  public save(coffeeMix: CoffeeMix) {
    return this.http.post<CoffeeMix>(this.coffeMixesUrl, CoffeeMix);
  }
}
