package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public class EspnNcaafGamesLoader extends EspnFootballSeasonGamesLoader {

	private static final String URL_FORMAT_1 = "http://www.espn.com/%s/schedule/_/week/";
	private static final String URL_FORMAT_2 = "/year/%d/group/%d/seasontype/%d";
	private static final String SPORT_IDENTIFIER = "college-football";
	private static final String SPORT = "ncaaf";
	private static final int WEEKS_PER_YEAR = 15;
	private static final int SEASON_TYPE = 2;

	public EspnNcaafGamesLoader(int year, int group, CoordinateMap coordinateMap) {
		super(String.format(URL_FORMAT_1, SPORT_IDENTIFIER) + "%d"
				+ String.format(URL_FORMAT_2, year, group, SEASON_TYPE), SPORT, WEEKS_PER_YEAR, coordinateMap);
	}

}
