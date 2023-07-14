import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'shop-it';
  isCartOpen:boolean=false;
  cart:Array<any>=[]

  toggleCart(){
    this.isCartOpen=!this.isCartOpen;
  }

  handleBuy(event: any) {
    //this.cart.push(event) // mutable
    this.cart=this.cart.concat(event) // immutable
  }

}
