import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private ele: ElementRef) {
    console.log(this.ele);
  }

  @HostListener("mouseenter") onMouseEnter() {
    this.ele.nativeElement.style.backgroundColor = "yellow";
  }

  @HostListener("mouseleave") onMouseLeave() {
    this.ele.nativeElement.style.backgroundColor = "";
  }

}
