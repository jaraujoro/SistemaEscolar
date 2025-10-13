import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [
    RouterModule,
  ],
  templateUrl: '././page-no-found.html',
  styles: ``
})
export class PageNotFound {

  currentYear: number = new Date().getFullYear();
}
