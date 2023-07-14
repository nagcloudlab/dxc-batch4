import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import Review from "../model/Review";

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {

  constructor(private httpClient:HttpClient) { }

  getReviews(productId:number){
    return this.httpClient.get<Array<Review>>('http://localhost:8080/api/reviews?productId='+productId)
  }

}
