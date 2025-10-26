import {
  Component,
  EventEmitter,
  Output,
  Input,
  OnChanges,
  SimpleChanges,
  OnInit,
} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModuloService } from 'src/app/service/modulo-service/modulo-service';
import { Router } from '@angular/router';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';

import { SweetAlertService } from 'src/app/service/plugins-service/sweet-alert.service';

@Component({
  selector: 'app-modulo-form-modal',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './modulo-form-modal.html',
  styleUrl: './modulo-form-modal.css',
})
export class ModuloFormModalComponent implements OnInit {
  @Output() cerrado = new EventEmitter<void>();
  @Input() itemListSeleccionado: any = null;
  @Output() refrescarListado = new EventEmitter<void>();

  formControlModulo: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private moduloService: ModuloService,
    private sweetAlert: SweetAlertService
  ) {
    this.formControlModulo = this.formBuilder.group({
      id_modulo: [''],
      nombre_modulo: ['', Validators.required],
      nivel_modulo: ['', Validators.required],
      url_modulo: ['', Validators.required],
      icono_modulo: [''],
      estado_modulo: ['', Validators.required],
      id_usuario : ['']
    });
  }

  cerrarModal() {
    this.cerrado.emit();
  }

  ngOnInit() {
    this.cargarDatosEnFormulario();
  }

  cargarDatosEnFormulario() {
    if (this.itemListSeleccionado) {
      this.formControlModulo.patchValue({
        id_modulo: this.itemListSeleccionado.id_modulo,
        nombre_modulo: this.itemListSeleccionado.nombre_modulo,
        nivel_modulo: this.itemListSeleccionado.nivel_modulo,
        url_modulo: this.itemListSeleccionado.url_modulo,
        icono_modulo: this.itemListSeleccionado.icono_modulo,
        estado_modulo: this.itemListSeleccionado.estado_modulo,
        usuario_actualiza_modulo : ''
      });
    }
  }

  onSubmitModulo() {
    if (this.formControlModulo.invalid) {
      this.sweetAlert.error('Complete todos los campos...');
      return;
    }
    const dataPost = this.formControlModulo.value;
    if (!dataPost.id_modulo) {
      this.registrarModulo(dataPost);
    } else {
      this.editarModulo(dataPost);
    }
  }

  async registrarModulo(dataPost: any) {
    try {
      const response: any = await this.moduloService.guardarModuloService(
        dataPost
      );
      if (response.o_nres == 1) {
        this.sweetAlert.success('Registro guardado correctamente.');
        this.formControlModulo.reset();
        this.cerrado.emit();
        this.refrescarListado.emit();
      } else {
        this.sweetAlert.error('Error al registrar.');
      }
    } catch (error) {
      this.sweetAlert.error();
    }
  }

  async editarModulo(dataPost: any) {
    try {
      const response: any = await this.moduloService.editarModuloService(
        dataPost
      );
      console.log(response);
      if (response.o_nres == 1) {
        this.sweetAlert.success('Registro editado correctamente.');
        this.formControlModulo.reset();
        this.cerrado.emit();
        this.refrescarListado.emit();
      } else {
        this.sweetAlert.error('Error al editar: ' + response.o_msj);
      }
    } catch (error) {
      console.log(error);
      this.sweetAlert.error();
    }
  }
}
