import { Component } from '@angular/core';
import { Departamento } from './departamento';
import { DepartamentoService } from './departamento.service';
import { Empresa } from '../empresa/empresa';

import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})
export class DepartamentoComponent {
  constructor(private departamentoService: DepartamentoService) { }

  empresa = {} as Empresa;
  departamento = {} as Departamento;
  departamentos: Departamento[] = [];

  ngOnInit() {
    this.getDepartamentos();
  }


  saveDepartamentoFunc(form: NgForm) {
    if (this.departamento.nome == '') {
      alert('Nome é obrigatório.');
    }
    else {
      this.departamento.empresa = this.empresa;
      this.departamentoService.saveDepartamento(this.departamento).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    form.resetForm();
  }

  // Chama o serviço para obtém todos os departamentos
  getDepartamentos() {
    this.departamentoService.getDepartamentos().subscribe((departamentos: Departamento[]) => {
      console.log(departamentos);
      this.departamentos = departamentos;
    });
  }
}
