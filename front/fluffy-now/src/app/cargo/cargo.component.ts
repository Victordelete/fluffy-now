import { Component, OnInit } from '@angular/core';
import { Cargo } from './cargo';
import { CargoService } from './cargo.service';

import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cargo',
  templateUrl: './cargo.component.html',
  styleUrls: ['./cargo.component.css']
})
export class CargoComponent {

  constructor(private cargoService: CargoService) { }

  cargo = {} as Cargo;
  cargos: Cargo[] = [];

  ngOnInit() {
    this.getCargos();
  }


  saveCargoFunc(form: NgForm) {
    if (this.cargo.nome == '') {
      alert('Nome é obrigatório.');
    }
    else {
      this.cargoService.saveCargo(this.cargo).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    form.resetForm();
  }

  // Chama o serviço para obtém todos os cargos
  getCargos() {
    this.cargoService.getCargos().subscribe((cargos: Cargo[]) => {
      console.log(cargos);
      this.cargos = cargos;
    });
  }
}
