import {Component, ContentChild, ElementRef, Input, SimpleChanges, ViewChild} from '@angular/core';
import {CartService} from "../../services/cart.service";
import CartLine from "../../model/CartLine";

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent {

  cart: Array<CartLine> = []
  @ViewChild("cc") cc!: ElementRef
  @ContentChild("ch") ch!:ElementRef

  time: string = ""
  intervalId: any = null

  constructor(private cartService: CartService) {
    console.log("CartViewComponent constructor")
    // why we need this?
    // todo onetime initialization
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log("CartViewComponent ngOnChanges")
    console.log(changes)
    // todo any effects/initialization when component receives new-input properties
  }

  ngOnInit() {
    console.log("CartViewComponent ngOnInit")
    // why we need this?
    //  todo any onetime initialization
    // this.intervalId = setInterval(() => {
    //   console.log("tick")
    //   this.time = new Date().toLocaleTimeString("en-US", {timeZone: "America/New_york"})
    // }, 1000)
    this.cartService.cart$.subscribe({
      next: (cart) => {
        this.cart = cart
      }
    })
  }

  ngOnDestroy() {
    console.log("CartViewComponent ngOnDestroy")
    // why we need this?
    // todo any onetime cleanup
    // clearInterval(this.intervalId)
  }


  ngAfterContentInit(){
    console.log("CartViewComponent ngAfterContentInit")
    this.ch.nativeElement.addEventListener("mouseenter",(e:any)=>{
      e.target.style.color = "tomato"
    })
  }

  ngAfterViewInit() {
    console.log("CartViewComponent ngAfterViewInit")
    this.cc.nativeElement.addEventListener("mouseenter",(e:any)=>{
      e.target.style.backgroundColor = "#DEF"
    })
    this.cc.nativeElement.addEventListener("mouseleave",(e:any)=>{
      e.target.style.backgroundColor = "#FFF"
    })
  }


}
