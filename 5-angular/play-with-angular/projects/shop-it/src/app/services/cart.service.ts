import { Injectable } from '@angular/core';
import { BehaviorSubject } from "rxjs";
import CartLine from "../model/CartLine";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
  }

  cart: Array<CartLine> = []
  cart$ = new BehaviorSubject<Array<CartLine>>(this.cart)

  addItem(item: any): void {
    this.cart = this.cart.concat(item)
    this.cart$.next(this.cart) // propagating change into stream
  }

}
