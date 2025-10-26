import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ModuloFormModalComponent } from './modulo-form-modal/modulo-form-modal';
import { ModuloService } from 'src/app/service/modulo-service/modulo-service';
import { SweetAlertService } from 'src/app/service/plugins-service/sweet-alert.service';
import { FormControl } from '@angular/forms';
@Component({
  selector: 'app-modulo',
  imports: [
    ReactiveFormsModule,
    CommonModule,
    ModuloFormModalComponent,
    FormsModule,
  ],
  templateUrl: './modulo.html',
  styleUrl: './modulo.css',
})
export class ModuloComponent implements OnInit {
  mostrarModal: boolean = false;
  cargandoListado: boolean = true;
  listDataModulo: any;
  itemListSeleccionado: any;
  inputSearchValue : string = "";

  constructor(
    private moduloService: ModuloService,
    private sweetAlert: SweetAlertService
  ) {}

  abrirModal(item: any) {
    this.mostrarModal = true;
    this.itemListSeleccionado = item;
  }

  cerrarModal() {
    this.mostrarModal = false;
  }

  ngOnInit(): void {
    this.listarModuloComponent();
  }

  async listarModuloComponent() {
    try {
      this.cargandoListado = true;
      const response = await this.moduloService.listarModuloService(this.inputSearchValue);
      this.listDataModulo = response;
      this.cargandoListado = false;
    } catch (error) {
      this.cargandoListado = false;
      this.sweetAlert.error();
    }
  }

  async eliminarModuloComponent(id_modulo: number) {
    try {
      const result = await this.sweetAlert.confirm();
      if (result.isConfirmed) {
        const response: any = await this.moduloService.eliminarModuloService(
          id_modulo
        );
        if (response.o_nres == 1) {
          this.sweetAlert.success('Módulo eliminado correctamente.');
          this.listarModuloComponent();
        } else {
          this.sweetAlert.error('Error al eliminar: ' + response.o_msj);
        }
      }
    } catch (error) {
      this.sweetAlert.error();
    }
  }
}
