import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { Game } from './game';

@Injectable({
    providedIn: 'root'
})
export class SportsWeekendService {

    private rootUrl = 'http://18.144.5.211';

    constructor(private httpClient: HttpClient) { }

    getGames(week: string): Observable<Set<Game>> {
        const url = `${this.rootUrl}/games?week=${week}`;
        return this.httpClient.get<Set<Game>>(url)
            .pipe(
                tap(_ => this.log('fetched games')),
                catchError(this.handleError<Set<Game>>('getGames()'))
            );
    }

    private log(message: string) {
        console.log(message);
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            this.log(`${operation} failed: ${error.message}`);
            return of(result as T);
        };
    }

}
