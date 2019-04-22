import { Component, OnInit, Input } from '@angular/core';
import { Game } from '../game';

@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

    lat = 39.0;
    lng = -95.0;
    zoom = 4;
    @Input() games: Set<Game>;

    constructor() { }

    ngOnInit() {

    }

    getIconUrl(game: Game): string {
        return game.sport === 'nfl' ? 'https://maps.google.com/mapfiles/ms/icons/red.png' :
                'https://maps.google.com/mapfiles/ms/icons/blue.png';
    }

}
