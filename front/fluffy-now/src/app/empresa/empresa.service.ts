import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Empresa } from './empresa';
@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  url = 'http://localhost:8080'; // api local

  // injetando o HttpClient
  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // Obtem todos os empresas
  getEmpresas(): Observable<Empresa[]> {
    return this.httpClient.get<Empresa[]>(this.url + '/empresa/list');
  }

  //Obtem empresa por id
  getEmpresaById(idEmpresa: any): Observable<Empresa> {
    return this.httpClient.get<Empresa>(this.url + '/getEmpresa/' + idEmpresa )
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // salva um empresa
  saveEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.httpClient.post<Empresa>(this.url + '/empresa/', JSON.stringify(empresa), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // Manipulação de erros
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);

    return throwError(errorMessage);
  };
}
