import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {OverviewComponent} from './component/overview/overview.component';
import {AboutComponent} from './component/about/about.component';
import {DetailComponent} from './component/detail/detail.component';
import {PageNotFoundComponent} from './component/page-not-found/page-not-found.component';
import {AddCoffeeMixComponent} from './component/add-coffee-mix/add-coffee-mix.component';

const routes: Routes = [
  {path: '', component: OverviewComponent},
  {path: 'coffeemix/:id', component: DetailComponent},
  {path: 'about', component: AboutComponent},
  {path: 'add', component: AddCoffeeMixComponent},
  {path: '**', component: PageNotFoundComponent, pathMatch: 'full'}  // Wildcard route for a 404 page
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
