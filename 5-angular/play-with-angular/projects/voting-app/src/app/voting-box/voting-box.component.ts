import {Component} from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.css']
})
export class VotingBoxComponent {

  votingItems = [
    "React.js",
    "Angular.js",
    "Vue.js"
  ]

  votingLines: Array<any> = []

  handleVote(vote: any) {
    let {item, type} = vote;
    let votingLine: any = this.votingLines.find(line => line.item === item);
    if (votingLine) {
      if (type === "like") {
        votingLine.likes++;
      } else {
        votingLine.dislikes++;
      }
    } else {
      if (type === "like") {
        this.votingLines.push({item, likes: 1, dislikes: 0});
      } else {
        this.votingLines.push({item, likes: 0, dislikes: 1});
      }
    }
  }

}
