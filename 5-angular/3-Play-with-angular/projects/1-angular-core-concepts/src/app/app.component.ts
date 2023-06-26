import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Angular-core-concepts'

  products =[
    {
      name: "Laptop",
      price: 1000,
      isAvailable:true,
      description: "New Laptop...",
      imagePath: "images/Laptop.png"
    },
    {
      name: "Mobile",
      price: 2000,
      isAvailable:true,
      description: "New Mobile...",
      imagePath: "images/Mobile.png"
    }
  ]

}
