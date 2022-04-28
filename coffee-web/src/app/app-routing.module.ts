import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoffeeMixListComponent } from './component/coffee-mix-list/coffee-mix-list.component';
import { CoffeeMixFormComponent } from './component/coffee-mix-form/coffee-mix-form.component';

const routes: Routes = [
  { path: 'coffeemixes', component: CoffeeMixListComponent },
  { path: 'addcoffeemix', component: CoffeeMixFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }