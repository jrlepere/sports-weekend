package com.jrlepere.sports_weekend_data_extractor;

import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.LocallySavedCoordinateMap;
import com.jrlepere.sports_weekend_data_extractor.games_loader.espn.Espn2019NflAndCollegeGamesLoader;
import com.jrlepere.sports_weekend_data_extractor.games_saver.CSVGamesSaver;

public class App {
	public static void main(String[] args) {
		String coordinateMapFilepath = args[0];
		String outputFilepath = args[1];
		(new CSVGamesSaver(outputFilepath))
				.save((new Espn2019NflAndCollegeGamesLoader(new LocallySavedCoordinateMap(coordinateMapFilepath, "	")))
						.loadGames());
	}
}
