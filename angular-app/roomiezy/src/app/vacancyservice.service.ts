import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vacancy } from './component/vacancy';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VacancyserviceService {

  constructor(private httpservice: HttpClient) {}
  vacancyurl: string = 'http://localhost:8080/vacancy/';

  AddVacancy(vacancy: Vacancy,id:any): Observable<Vacancy> {
    console.log(vacancy);
    return this.httpservice
      .post<Vacancy>(this.vacancyurl+id, vacancy)
      .pipe(retry(0), catchError(this.myerrorhandler));
  }

  // Error handling
  private myerrorhandler(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error(
        'An error occurred.. either client side or network:',
        error.error
      );
    } else {
      console.error(
        `Backend returned code ${error.status}, body was: `,
        error.error
      );
    }
    return throwError(
      () => new Error('Something bad happened; please try again later.')
    );
  }
}
