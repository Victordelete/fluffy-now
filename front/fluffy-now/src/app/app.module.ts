import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatSidenavModule} from '@angular/material/sidenav';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { CargoComponent } from './cargo/cargo.component';
import { RegPontoComponent } from './reg-ponto/reg-ponto.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    EmpresaComponent,
    DepartamentoComponent,
    FuncionarioComponent,
    CargoComponent,
    RegPontoComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
