package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public class EspnNflGamesLoader extends EspnFootballSeasonGamesLoader {

	private static final String URL_FORMAT_1 = "http://www.espn.com/%s/schedule/_/week/";
	private static final String URL_FORMAT_2 = "/year/%d/seasontype/%d";
	private static final String SPORT_IDENTIFIER = "nfl";
	private static final String SPORT = "nfl";
	private static final int WEEKS_PER_YEAR = 17;
	private static final int SEASON_TYPE = 2;

	public EspnNflGamesLoader(int year, CoordinateMap coordinateMap) {
		super(String.format(URL_FORMAT_1, SPORT_IDENTIFIER) + "%d" + String.format(URL_FORMAT_2, year, SEASON_TYPE),
				SPORT, WEEKS_PER_YEAR, coordinateMap);
	}

}
