import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Cargo } from './cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  url = 'http://localhost:8080'; // api local

  // injetando o HttpClient
  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // Obtem todos os cargos
  getCargos(): Observable<Cargo[]> {
    return this.httpClient.get<Cargo[]>(this.url + '/cargo/list');
  }

  //Obtem cargo por id
  getCargoById(idCargo: any): Observable<Cargo> {
    return this.httpClient.get<Cargo>(this.url + '/getCargo/' + idCargo )
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // salva um cargo
  saveCargo(cargo: Cargo): Observable<Cargo> {
    return this.httpClient.post<Cargo>(this.url + '/cargo/', JSON.stringify(cargo), this.httpOptions)
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
