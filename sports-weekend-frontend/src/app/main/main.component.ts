import { Component, OnInit } from '@angular/core';
import { SportsWeekendService } from '../sports-weekend.service';
import { Game } from '../game';

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

    week = '1';
    games: Set<Game>;

    constructor(private sportsWeekendService: SportsWeekendService) { }

    ngOnInit() {
        this.loadGames();
    }

    loadGames() {
        this.sportsWeekendService.getGames(this.week).subscribe(loadedGames => this.games = loadedGames);
    }

}
