import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { MatSelectModule, MatFormFieldModule } from '@angular/material';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AgmCoreModule } from '@agm/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MapComponent } from './map/map.component';
import { MainComponent } from './main/main.component';

import { GoogleMapsApiKey } from './googlemaps-apikey';

@NgModule({
    declarations: [
        AppComponent,
        MapComponent,
        MainComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        MatSelectModule,
        MatFormFieldModule,
        BrowserAnimationsModule,
        AgmCoreModule.forRoot({
            apiKey: GoogleMapsApiKey.key
        })
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
