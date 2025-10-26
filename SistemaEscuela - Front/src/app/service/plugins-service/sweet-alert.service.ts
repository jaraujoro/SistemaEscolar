import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root', // 🔹 Esto lo hace global automáticamente
})
export class SweetAlertService {

  loading(message: string = 'Cargando...') {
    Swal.fire({
      title: message,
      allowOutsideClick: false,
      allowEscapeKey: false,
      didOpen: () => {
        Swal.showLoading();
      },
    });
  }

  close() {
    Swal.close();
  }

  confirm(
    title: string = '¿Estás seguro?',
    text: string = 'No podrás revertir esto!'
  ): Promise<any> {
    return Swal.fire({
      title,
      text,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Aceptar',
      cancelButtonText: 'Cancelar',
    });
  }

  success(message: string, title: string = 'Ok') {
    Swal.fire({
      toast: true,
      position: 'bottom-end',
      icon: 'success',
      title: title,
      text: message,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }

  error(message: string = 'Error en la peticion : No se pudo conectar con el servidor. Intente nuevamente o más tarde.', title: string = 'Error') {
    Swal.fire({
      toast: true,
      position: 'bottom-end',
      icon: 'error',
      title: title,
      text: message,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }

  warning(title: string = '¿Estás seguro?',
    text: string = 'No podrás revertir esto!') {
    return Swal.fire({
      title,
      text,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí, continuar',
      cancelButtonText: 'Cancelar',
      background: '#fff',
      customClass: {
        popup: 'swal2-rounded',
      },
    });
  }
}
