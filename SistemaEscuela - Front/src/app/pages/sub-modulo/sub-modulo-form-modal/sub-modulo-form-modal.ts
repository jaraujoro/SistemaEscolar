import {
  Component,
  EventEmitter,
  Output,
  Input,
  OnChanges,
  SimpleChanges,
  OnInit,
} from '@angular/core';

import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';

import { CommonModule } from '@angular/common';

import { SweetAlertService } from 'src/app/service/plugins-service/sweet-alert.service';
import { SubModuloService } from 'src/app/service/sub-modulo-service/sub-modulo-service';

@Component({
  selector: 'app-sub-modulo-form-modal',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './sub-modulo-form-modal.html',
  styleUrl: './sub-modulo-form-modal.css',
})
export class SubModuloFormModal implements OnInit {
  formControl: FormGroup;
  listDataCboModulo: any;

  constructor(
    private formBuilder: FormBuilder,
    private subModuloService: SubModuloService,
    private sweetAlert: SweetAlertService
  ) {
    this.formControl = this.formBuilder.group({
      id_sub_modulo: [''],
      id_modulo: ['', Validators.required],
      nombre_sub_modulo: ['', Validators.required],
      nivel_sub_modulo: ['', Validators.required],
      url_sub_modulo: ['', Validators.required],
      estado_sub_modulo: ['', Validators.required],
      id_usuario: [''],
    });
  }

  @Output() cerrado = new EventEmitter<void>();
  @Input() itemListSeleccionado: any = null;
  @Output() refrescarListado = new EventEmitter<void>();

  ngOnInit() {
    this.cargarDatosEnFormulario();
    this.listarModuloCbo();
  }

  cargarDatosEnFormulario() {
    if (this.itemListSeleccionado) {
      this.formControl.patchValue({
        id_sub_modulo: this.itemListSeleccionado.id_sub_modulo,
        id_modulo: this.itemListSeleccionado.id_modulo,
        nombre_sub_modulo: this.itemListSeleccionado.nombre_sub_modulo,
        nivel_sub_modulo: this.itemListSeleccionado.nivel_sub_modulo,
        url_sub_modulo: this.itemListSeleccionado.url_sub_modulo,
        estado_sub_modulo: this.itemListSeleccionado.estado_sub_modulo,
        usuario_actualiza_modulo: '',
      });
    }
  }

  cerrarModal() {
    this.cerrado.emit();
  }

  async listarModuloCbo() {
    const response = await this.subModuloService.listarModuloCboService();
    this.listDataCboModulo = response;
  }

  onSubmitSubModulo() {
    if (this.formControl.invalid) {
      this.sweetAlert.error('Complete todos los campos...');
      return;
    }
    const dataPost = this.formControl.value;
    if(!dataPost.id_sub_modulo){
      console.log("registro");
    }else{
      console.log("update");
    }
  }
}
