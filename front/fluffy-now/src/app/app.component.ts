import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{
  title = 'fluffy-now';
  isExpanded = true;

  expandir() {
    console.log(this.isExpanded);
    this.isExpanded = !this.isExpanded;
  }

  onOpenedChange(e: boolean){

  }

}
