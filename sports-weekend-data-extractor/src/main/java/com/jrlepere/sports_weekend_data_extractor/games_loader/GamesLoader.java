package com.jrlepere.sports_weekend_data_extractor.games_loader;

import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;

public interface GamesLoader {

	public Map<Integer, Set<Game>> loadGames();

}
