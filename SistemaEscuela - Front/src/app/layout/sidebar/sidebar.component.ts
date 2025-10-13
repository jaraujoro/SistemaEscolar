import { Component, Input, Output, EventEmitter, HostListener } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

interface NavItem {
  name: string;
  icon?: string;
  path?: string;
  subItems?: NavItem[];
}

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent {
  constructor(private router: Router) {}

  @Input() isExpanded = false;
  @Input() isMobile = false; // ← Ahora viene del componente padre
  @Output() sidebarToggle = new EventEmitter<void>();
  
  openSubmenu: string | null = null;

  navItems: NavItem[] = [
    {
      name: 'Dashboard',
      icon: '📊',
      path: '/EduCenter/dashboard',
    },
    {
      name: 'Ecommerce',
      icon: '🛒',
      subItems: [
        { name: 'Products', path: '/EduCenter/usuario' },
        { name: 'Orders', path: '/EduCenter/orders' },
        { name: 'Customers', path: '/EduCenter/customers' },
      ],
    },
    {
      name: 'Calendar',
      icon: '📅',
      path: 'EduCenter/calendar',
    },
    {
      name: 'User Profile',
      icon: '👤',
      path: 'EduCenter/profile',
    },
  ];

  // Método para cerrar sidebar en móvil
  closeSidebar() {
    if (this.isMobile) {
      this.sidebarToggle.emit();
    }
  }

  // Método para clicks en items móviles
  onMobileItemClick() {
    if (this.isMobile) {
      this.closeSidebar();
    }
  }

  toggleSubmenu(name: string) {
    this.openSubmenu = this.openSubmenu === name ? null : name;
  }

  isActive(path: string): boolean {
    return this.router.url === path;
  }

  isSubItemActive(subItem: NavItem): boolean {
    if (!subItem.path) return false;
    return this.router.url === subItem.path;
  }

  isParentActive(navItem: NavItem): boolean {
    if (navItem.path) {
      return this.isActive(navItem.path);
    }
    
    if (navItem.subItems) {
      return navItem.subItems.some(subItem => this.isSubItemActive(subItem));
    }
    
    return false;
  }

  checkActiveSubmenu() {
    this.navItems.forEach(item => {
      if (item.subItems && item.subItems.some(sub => this.isSubItemActive(sub))) {
        this.openSubmenu = item.name;
      }
    });
  }

  ngOnInit() {
    this.checkActiveSubmenu();
    
    this.router.events.subscribe(() => {
      this.checkActiveSubmenu();
    });
  }
}