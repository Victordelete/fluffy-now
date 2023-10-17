import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Departamento } from './departamento';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {

  url = 'http://localhost:8080'; // api local

  // injetando o HttpClient
  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // Obtem todos os departamentos
  getDepartamentos(): Observable<Departamento[]> {
    return this.httpClient.get<Departamento[]>(this.url + '/departamento/list');
  }

  //Obtem departamento por id
  getDepartamentoById(idDepartamento: any): Observable<Departamento> {
    return this.httpClient.get<Departamento>(this.url + '/getDepartamento/' + idDepartamento )
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // salva um departamento
  saveDepartamento(departamento: Departamento): Observable<Departamento> {
    return this.httpClient.post<Departamento>(this.url + '/departamento/', JSON.stringify(departamento), this.httpOptions)
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
