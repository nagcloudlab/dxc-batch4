import {Component, Input} from '@angular/core';
import {CartService} from "../../services/cart.service";
import CartLine from "../../model/CartLine";

@Component({
  selector: 'app-cart-badge',
  templateUrl: './cart-badge.component.html',
  styleUrls: ['./cart-badge.component.css']
})
export class CartBadgeComponent {

  value: number = 0;

  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.cartService.cart$.subscribe({
      next: (cart: Array<CartLine>) => {
        this.value = cart.length;
      }
    })
  }

}
