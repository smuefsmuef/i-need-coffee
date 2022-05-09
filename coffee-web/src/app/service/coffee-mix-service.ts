import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// @ts-ignore
import { Observable } from 'rxjs/Observable';
import {CoffeeMix} from '../model/coffee-mix';
import {Rating} from "../model/rating";

@Injectable()
export class CoffeeMixService {

  private coffeeMixUrl: string;

  constructor(private http: HttpClient) {
    this.coffeeMixUrl = 'http://localhost:8080/api/coffeemix';
  }

  public findAll(): Observable<CoffeeMix[]> {
    return this.http.get<CoffeeMix[]>(this.coffeeMixUrl);
  }

  public save(coffeeMix: CoffeeMix) {
    return this.http.post<CoffeeMix>(this.coffeeMixUrl, CoffeeMix);
  }

  public findCoffeeMixById(id: number): Observable<CoffeeMix> {
    console.log('find by id service works', id)
    return this.http.get<CoffeeMix>(`${this.coffeeMixUrl}/${id}`)
  }

  public addRating(rating: Rating): Observable<Rating> {
    console.log('find by id service works')
    return this.http.patch<Rating>(`${this.coffeeMixUrl}`, Rating)
  }
}
