package com.jrlepere.sports_weekend_data_extractor.games_saver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;
import com.opencsv.CSVWriter;

public class CSVGamesSaver implements GamesSaver {

	private String savepath;

	public CSVGamesSaver(String savepath) {
		this.savepath = savepath;
	}

	public void save(Map<Integer, Set<Game>> games) {
		try {
			CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(savepath)));
			csvWriter.writeNext(new String[] { "week", "sport", "team1", "team2", "date", "time", "team1LogoUrl",
					"team2LogoUrl", "latitude", "longitude" });
			for (int week : games.keySet()) {
				for (Game game : games.get(week)) {
					csvWriter.writeNext(new String[] { "" + week, game.getSport(), game.getTeam1(), game.getTeam2(),
							game.getDate(), game.getTime(), game.getTeam1LogoUrl(), game.getTeam2LogoUrl(),
							"" + game.getLatitude(), "" + game.getLongitude(), });
				}
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
