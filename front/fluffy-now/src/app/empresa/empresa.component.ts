import { Component, OnInit } from '@angular/core';
import { Empresa } from './empresa';
import { EmpresaService } from './empresa.service';

import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent {
  constructor(private empresaService: EmpresaService) { }

  empresa = {} as Empresa;
  empresas: Empresa[] = [];

  ngOnInit() {
    this.getEmpresas();
  }


  saveEmpresaFunc(form: NgForm) {
    if (this.empresa.nomeSocial == '') {
      alert('Nome é obrigatório.');
    }
    else {
      this.empresaService.saveEmpresa(this.empresa).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    form.resetForm();
  }

  // Chama o serviço para obtém todos os empresas
  getEmpresas() {
    this.empresaService.getEmpresas().subscribe((empresas: Empresa[]) => {
      console.log(empresas);
      this.empresas = empresas;
    });
  }
}
