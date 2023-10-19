import { Component } from '@angular/core';
import { RegPonto } from './regPonto';
import { RegPontoService } from './reg-ponto.service';

import { NgForm } from '@angular/forms';
import { Funcionario } from '../funcionario/funcionario';

@Component({
  selector: 'app-regPonto',
  templateUrl: './reg-ponto.component.html',
  styleUrls: ['./reg-ponto.component.css']
})
export class RegPontoComponent {
  constructor(private regPontoService: RegPontoService) { }

  funcionario = {} as Funcionario;
  regPonto = {} as RegPonto;
  regPontos: RegPonto[] = [];

  ngOnInit() {
    this.getRegPontos();
  }


  saveRegPontoFunc(form: NgForm) {
    if (this.regPonto.dataPonto == '') {
      alert('Nome é obrigatório.');
    }
    else {
      this.regPonto.funcionario = this.funcionario;
      this.regPontoService.saveRegPonto(this.regPonto).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    form.resetForm();
  }

  // Chama o serviço para obtém todos os regPontos
  getRegPontos() {
    this.regPontoService.getRegPontos().subscribe((regPontos: RegPonto[]) => {
      console.log(regPontos);
      this.regPontos = regPontos;
    });
  }
}
