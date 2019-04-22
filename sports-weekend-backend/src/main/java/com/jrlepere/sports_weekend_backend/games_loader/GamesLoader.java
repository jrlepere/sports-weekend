package com.jrlepere.sports_weekend_backend.games_loader;

import java.util.Map;
import java.util.Set;

import com.jrlepere.sports_weekend_backend.Game;

public interface GamesLoader {

	public Map<Integer, Set<Game>> loadGames();

}
