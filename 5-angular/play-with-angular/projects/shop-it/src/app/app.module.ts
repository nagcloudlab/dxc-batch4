import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductComponent } from './components/product/product.component';
import { CartBadgeComponent } from './components/cart-badge/cart-badge.component';
import { CartViewComponent } from './components/cart-view/cart-view.component';
import { HighlightDirective } from './directives/highlight.directive';
import { DiscountPipe } from './pipes/discount.pipe';
import {HttpClientModule} from "@angular/common/http";
import { ReviewComponent } from './review/review.component';
import { ReviewFormComponent } from './review-form/review-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';


const routes=[
  {path:'',component:HomeComponent},
  {path:'products',component:ProductListComponent},
  {path: 'cart',component:CartViewComponent},
  {path: '**',component:NotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductListComponent,
    ProductComponent,
    CartBadgeComponent,
    CartViewComponent,
    HighlightDirective,
    DiscountPipe,
    ReviewComponent,
    ReviewFormComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
    // contains services to make http-request
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
