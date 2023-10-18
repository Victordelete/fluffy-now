import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { RegPonto } from './regPonto';

@Injectable({
  providedIn: 'root'
})

export class RegPontoService {

  url = 'http://localhost:8080'; // api local

  // injetando o HttpClient
  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // Obtem todos os regPontos
  getRegPontos(): Observable<RegPonto[]> {
    return this.httpClient.get<RegPonto[]>(this.url + '/regPonto/list');
  }

  //Obtem regPonto por id
  getRegPontoById(idRegPonto: any): Observable<RegPonto> {
    return this.httpClient.get<RegPonto>(this.url + '/getRegPonto/' + idRegPonto )
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // salva um regPonto
  saveRegPonto(regPonto: RegPonto): Observable<RegPonto> {
    return this.httpClient.post<RegPonto>(this.url + '/regPonto/', JSON.stringify(regPonto), this.httpOptions)
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
