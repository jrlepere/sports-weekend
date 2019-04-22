package com.jrlepere.sports_weekend_backend.games_loader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_backend.Game;
import com.opencsv.CSVReader;

public class CSVGamesLoader implements GamesLoader {

	private String filepath;
	
	public CSVGamesLoader(String filepath) {
		this.filepath = filepath;
	}
	
	public Map<Integer, Set<Game>> loadGames() {
		Map<Integer, Set<Game>> games = new HashMap<>();
		try {
			CSVReader csvReader = new CSVReader(new FileReader(new File(filepath)));
			csvReader.readNext();
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				int week = Integer.parseInt(nextRecord[0]);
				Game game = new Game();
				game.setSport(nextRecord[1]);
				game.setTeam1(nextRecord[2]);
				game.setTeam2(nextRecord[3]);
				game.setDate(nextRecord[4]);
				game.setTime(nextRecord[5]);
				game.setTeam1LogoUrl(nextRecord[6]);
				game.setTeam2LogoUrl(nextRecord[7]);
				game.setLatitude(Float.parseFloat(nextRecord[8]));
				game.setLongitude(Float.parseFloat(nextRecord[9]));
				if (!games.containsKey(week)) games.put(week, new HashSet<>());
				games.get(week).add(game);
			}
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return games;
	}

}
