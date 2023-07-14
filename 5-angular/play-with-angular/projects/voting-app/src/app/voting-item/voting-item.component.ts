import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.css']
})
export class VotingItemComponent {

  @Input() value = "";
  @Output() vote = new EventEmitter<any>();

  handleLike(event: MouseEvent) {
    this.vote.emit({item: this.value, type: "like"});
  }

  handleDislike(event: MouseEvent) {
    this.vote.emit({item: this.value, type: "dislike"});
  }

}
