import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CargoComponent } from './cargo/cargo.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { RegPontoComponent } from './reg-ponto/reg-ponto.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path:  "cargo",
    component: CargoComponent
  },

  {
    path: "departamento",
    component: DepartamentoComponent
  },

  {
    path: "empresa",
    component: EmpresaComponent
  },

  {
    path: "funcionario",
    component: FuncionarioComponent
  },

  {
    path: "regPonto",
    component: RegPontoComponent
  },

  {
    path: "home",
    component: HomeComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
