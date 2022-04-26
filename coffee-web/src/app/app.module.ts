import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoffeeMixListComponent } from './coffee-mix-list/coffee-mix-list.component';
import { CoffeeMixFormComponent } from './coffee-mix-form/coffee-mix-form.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CoffeeMixService } from './service/coffee-mix-service';

@NgModule({
  declarations: [
    AppComponent,
    CoffeeMixListComponent,
    CoffeeMixFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [CoffeeMixService],
  bootstrap: [AppComponent]
})
export class AppModule { }
