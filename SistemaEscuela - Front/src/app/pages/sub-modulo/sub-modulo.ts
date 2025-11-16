import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SweetAlertService } from 'src/app/service/plugins-service/sweet-alert.service';
import { SubModuloService } from 'src/app/service/sub-modulo-service/sub-modulo-service';
import { SubModuloFormModal } from './sub-modulo-form-modal/sub-modulo-form-modal';

@Component({
  selector: 'app-sub-modulo',
  imports: [ReactiveFormsModule, CommonModule, SubModuloFormModal, FormsModule],
  templateUrl: './sub-modulo.html',
  styleUrl: './sub-modulo.css',
})
export class SubModuloComponent implements OnInit {
  mostrarModal: boolean = false;
  cargandoListado: boolean = true;
  listData: any;
  itemListSeleccionado: any;
  inputSearchValue: string = '';

  constructor(
    private subModuloService: SubModuloService,
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
    this.listarSubModuloComponent();
  }

  async listarSubModuloComponent() {
    try {
      this.cargandoListado = true;
      const dataPost = { where: this.inputSearchValue };
      const response = await this.subModuloService.listSubModuloService(
        dataPost
      );
      this.listData = response;
      this.cargandoListado = false;
    } catch (error) {
      this.cargandoListado = false;
      this.sweetAlert.error();
    }
  }

  async eliminarSubModuloComponent(id_sub_modulo: string) {
    try {
      let alert = await this.sweetAlert.confirm();
      if (alert.isConfirmed) {
        const dataPost = { id_sub_modulo: id_sub_modulo };
        const response: any =
          await this.subModuloService.eliminarSubModuloService(dataPost);
        if (response.o_nres == 1) {
          this.sweetAlert.success('Registro eliminado correctamente.');
          this.listarSubModuloComponent();
        } else {
          this.sweetAlert.error('Error al eliminar: ' + response.o_msj);
        }
      }
    } catch {
      this.sweetAlert.error();
    }
  }
}
