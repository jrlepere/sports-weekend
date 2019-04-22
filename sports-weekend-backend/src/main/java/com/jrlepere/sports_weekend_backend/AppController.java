package com.jrlepere.sports_weekend_backend;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AppController {

	GamesCollection gamesCollection = new GamesCollection();

	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ResponseEntity<Set<Game>> getGames(@RequestParam(value = "week") int week) {
		return new ResponseEntity<Set<Game>>(gamesCollection.getGames(week), HttpStatus.OK);
	}

}
