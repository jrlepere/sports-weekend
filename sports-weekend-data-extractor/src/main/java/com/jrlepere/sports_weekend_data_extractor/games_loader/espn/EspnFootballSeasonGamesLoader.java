package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;
import com.jrlepere.sports_weekend_data_extractor.games_loader.GamesLoader;
import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public abstract class EspnFootballSeasonGamesLoader implements GamesLoader {

	private String url, sport;
	private int numWeeks;
	private CoordinateMap coordinateMap;

	public EspnFootballSeasonGamesLoader(String url, String sport, int numWeeks,
			CoordinateMap coordinateMap) {
		this.url = url;
		this.sport = sport;
		this.numWeeks = numWeeks;
		this.coordinateMap = coordinateMap;
	}

	public Map<Integer, Set<Game>> loadGames() {
		Map<Integer, Set<Game>> games = new HashMap<>();
		for (int week = 1; week <= numWeeks; week++) {
			games.put(week, (new EspnFootballWeekGamesParser(String.format(url, week), sport, coordinateMap))
					.loadGames());
		}
		return games;
	}

}
