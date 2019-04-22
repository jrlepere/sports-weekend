package com.jrlepere.sports_weekend_data_extractor.games_saver;

import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_data_extractor.Game;

public interface GamesSaver {
	public void save(Map<Integer, Set<Game>> games);
}
