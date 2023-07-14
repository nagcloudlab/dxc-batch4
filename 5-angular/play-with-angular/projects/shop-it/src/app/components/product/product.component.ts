import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {ReviewsService} from "../../services/reviews.service";
import Review from "../../model/Review";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input("value") product: any = {};

  reviews: Review[] = [];
  currentTab: number = 1

  constructor(private cartService: CartService, private reviewsService: ReviewsService) {
  }

  handleNewReview(review: Review) {
    // Exercise
    this.reviews.push(review);
  }

  handleTabChange(event: MouseEvent, tabIndex: number) {
    this.currentTab = tabIndex
    if (this.currentTab === 3) {
      this.reviewsService.getReviews(this.product.id).subscribe(reviews => {
        this.reviews = reviews
      })
    }
  }

  handleBuy(event: MouseEvent) {
    // this.buy.emit({
    //   id: this.product.id,
    //   name: this.product.name,
    //   price: this.product.price
    // });
    this.cartService.addItem({
      id: this.product.id,
      name: this.product.name,
      price: this.product.price
    })
  }

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

}
