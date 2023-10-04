import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { CargoComponent } from './cargo/cargo.component';
import { RegPontoComponent } from './reg-ponto/reg-ponto.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpresaComponent,
    DepartamentoComponent,
    FuncionarioComponent,
    CargoComponent,
    RegPontoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
