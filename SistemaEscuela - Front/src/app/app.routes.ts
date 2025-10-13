import { Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { LoginUsuario } from './pages/login-usuario/login-usuario';
import { PageNotFound } from './layout/page-no-found/page-no-found';
// import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component'; // Componente 404

export const routes: Routes = [
  // Redirección raíz al login
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // Login
  { path: 'login', component: LoginUsuario, title: 'Login' },

  // Todas las rutas de EduCenter
  {
    path: 'EduCenter',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, // /EduCenter → dashboard
      { path: 'dashboard', component: DashboardComponent, title: 'Menu Principal' },
      { path: 'usuario', component: UsuarioComponent, title: 'Usuario' },
    ],
  },

  // Ruta comodín para 404
  { path: '**', component: PageNotFound, title: 'Página no encontrada' },
];
