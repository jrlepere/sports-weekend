package com.jrlepere.sports_weekend_backend;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_backend.games_loader.CSVGamesLoader;

public class GamesCollection {

	private static final String GAMES_FILEPATH = "./games.csv";
	private Map<Integer, Set<Game>> games;

	public GamesCollection() {
		games = (new CSVGamesLoader(GAMES_FILEPATH)).loadGames();
	}

	public Set<Game> getGames(int week) {
		return games.containsKey(week) ? games.get(week) : new HashSet<Game>();
	}

}
