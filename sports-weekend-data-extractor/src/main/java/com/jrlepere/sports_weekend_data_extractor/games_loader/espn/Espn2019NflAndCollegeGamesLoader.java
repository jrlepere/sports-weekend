package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;
import com.jrlepere.sports_weekend_data_extractor.games_loader.GamesLoader;
import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public class Espn2019NflAndCollegeGamesLoader implements GamesLoader {

	private static final int YEAR = 2019;
	private static final int NCAAF_WEEK_OFFSET = -1;
	private CoordinateMap coordinateMap;

	public Espn2019NflAndCollegeGamesLoader(CoordinateMap coordinateMap) {
		this.coordinateMap = coordinateMap;
	}

	public Map<Integer, Set<Game>> loadGames() {
		Map<Integer, Set<Game>> games = (new EspnNflGamesLoader(YEAR, coordinateMap)).loadGames();
		Map<Integer, Set<Game>> ncaafGames = (new EspnNcaafPower5GamesLoader(YEAR, coordinateMap)).loadGames();
		for (int ncaafWeek : ncaafGames.keySet()) {
			int nflAlignedWeek = ncaafWeek + NCAAF_WEEK_OFFSET;
			if (games.containsKey(nflAlignedWeek)) {
				games.get(nflAlignedWeek).addAll(ncaafGames.get(ncaafWeek));
			}
		}
		return games;
	}

}
