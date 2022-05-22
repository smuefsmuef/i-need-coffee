import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
// @ts-ignore
import {Observable} from 'rxjs/Observable';
import {CoffeeMix} from '../model/coffee-mix';
import {Rating} from "../model/rating";
import {Bean} from "../component/detail/detail.component";

@Injectable()
export class CoffeeMixService {

  private coffeeMixUrl: string;
  private beanUrl: string;

  constructor(private http: HttpClient) {
    this.coffeeMixUrl = 'http://localhost:8080/api/coffeemixes';
    this.beanUrl = 'http://localhost:8080/api/beans';
  }

  public findAll(): Observable<CoffeeMix[]> {
    return this.http.get<CoffeeMix[]>(this.coffeeMixUrl);
  }

  public save(coffeeMix: CoffeeMix) {
    return this.http.post<CoffeeMix>(this.coffeeMixUrl, coffeeMix);
  }

  public update(coffeeMix: CoffeeMix, id: number) {
    console.log('update by id service works', id)
    return this.http.put<CoffeeMix>(`${this.coffeeMixUrl}/${id}`, coffeeMix)
  }

  public findCoffeeMixById(id: number): Observable<CoffeeMix> {
    console.log('find by id service works', id)
    return this.http.get<CoffeeMix>(`${this.coffeeMixUrl}/${id}`)
  }

  public addRating(rating: Rating): Observable<Rating> {
    console.log('find by id service works')
    return this.http.put<Rating>(`${this.coffeeMixUrl}/2`, rating) // todo add id
  }

  public add(bean: Bean) {
    return this.http.post<CoffeeMix>(this.beanUrl, bean, {observe: "response"});
  }

  public findAllBeans(): Observable<Bean[]> {
    return this.http.get<Bean[]>(this.beanUrl);
  }

}
