import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent {

  @Output() newReview = new EventEmitter<any>();

  reviewForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      author: ['', Validators.required],
      rating: ['', Validators.required],
      body: ['', Validators.required]
    });
  }

  handeSubmit() {
    this.newReview.emit(this.reviewForm.value);
  }

}
