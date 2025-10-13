import { Component, HostListener, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common'; // ✅ Añade esto
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [
    CommonModule, // ✅ Añade CommonModule aquí
    RouterModule, 
    HeaderComponent, 
    SidebarComponent
  ],
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css'],
})
export class LayoutComponent implements OnInit {
  
  isSidebarExpanded = false;
  isMobile = false;

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.checkScreenSize();
  }

  checkScreenSize() {
    this.isMobile = window.innerWidth < 1024; // lg breakpoint
    
    if (!this.isMobile) {
      // En desktop: sidebar siempre expandido
      this.isSidebarExpanded = true;
    } else {
      // En móvil: sidebar cerrado por defecto
      this.isSidebarExpanded = false;
    }
  }

  onMenuToggle() {
    this.isSidebarExpanded = !this.isSidebarExpanded;
  }

  ngOnInit() {
    this.checkScreenSize();
  }
}