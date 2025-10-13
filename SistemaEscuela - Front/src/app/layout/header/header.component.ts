import { Component, EventEmitter, Output, HostListener, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  @Output() menuToggle = new EventEmitter<void>();
  @Input() isSidebarExpanded = false; // Recibir el estado del sidebar
  
  // Control del dropdown de usuario
  isUserDropdownOpen = false;

  toggleMenu() {
    this.menuToggle.emit();
  }

  toggleUserDropdown() {
    this.isUserDropdownOpen = !this.isUserDropdownOpen;
  }

  // Cerrar dropdown al hacer click fuera
  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    const target = event.target as HTMLElement;
    if (!target.closest('.relative')) {
      this.isUserDropdownOpen = false;
    }
  }

  // Cerrar dropdown al presionar Escape
  @HostListener('document:keydown.escape', ['$event'])
  onEscapePress(event: KeyboardEvent) {
    this.isUserDropdownOpen = false;
  }
}