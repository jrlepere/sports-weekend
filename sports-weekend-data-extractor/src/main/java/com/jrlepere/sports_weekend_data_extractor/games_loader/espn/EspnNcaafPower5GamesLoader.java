package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;
import com.jrlepere.sports_weekend_data_extractor.games_loader.GamesLoader;
import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public class EspnNcaafPower5GamesLoader implements GamesLoader {

	private static final int[] POWER_5_GROUPS = {1, 4, 5, 9, 8};
	private int year;
	private CoordinateMap coordinateMap;
	
	public EspnNcaafPower5GamesLoader(int year, CoordinateMap coordinateMap) {
		this.year = year;
		this.coordinateMap = coordinateMap;
	}
	
	public Map<Integer, Set<Game>> loadGames() {
		Map<Integer, Set<Game>> games = new HashMap<>();
		for (int group : POWER_5_GROUPS) {
			Map<Integer, Set<Game>> gamesByGroup = (new EspnNcaafGamesLoader(year, group, coordinateMap)).loadGames();
			for (Integer week : gamesByGroup.keySet()) {
				if (!games.containsKey(week)) games.put(week, new HashSet<Game>());
				games.get(week).addAll(gamesByGroup.get(week));
			}
		}
		return games;
	}
	
}
