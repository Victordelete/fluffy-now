import { Component } from '@angular/core';
import { Funcionario } from './funcionario';
import { FuncionarioService } from './funcionario.service';
import { Departamento } from '../departamento/departamento';
import { Cargo } from '../cargo/cargo';

import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent {
  constructor(private funcionarioService: FuncionarioService) { }

  departamento = {} as Departamento;
  cargo = {} as Cargo;
  funcionario = {} as Funcionario;
  funcionarios: Funcionario[] = [];

  ngOnInit() {
    this.getFuncionarios();
  }


  saveFuncionarioFunc(form: NgForm) {
    if (this.funcionario.nome == '') {
      alert('Nome é obrigatório.');
    }
    else {
      this.funcionario.departamento = this.departamento;
      this.funcionario.cargo = this.cargo;
      this.funcionarioService.saveFuncionario(this.funcionario).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    form.resetForm();
  }

  // Chama o serviço para obtém todos os funcionarios
  getFuncionarios() {
    this.funcionarioService.getFuncionarios().subscribe((funcionarios: Funcionario[]) => {
      console.log(funcionarios);
      this.funcionarios = funcionarios;
    });
  }
}
