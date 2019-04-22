package com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocallySavedCoordinateMap implements CoordinateMap {

	private Map<String, Coordinates> coordinates;

	public LocallySavedCoordinateMap(String filepath, String separater) {
		coordinates = new HashMap<>();
		Scanner coordinateMapScanner;
		try {
			coordinateMapScanner = new Scanner(new File(filepath));
			while (coordinateMapScanner.hasNextLine()) {
				String[] coordinateMapEntry = coordinateMapScanner.nextLine().split(separater);
				coordinates.put(coordinateMapEntry[0],
						new Coordinates(Float.parseFloat(coordinateMapEntry[1]), Float.parseFloat(coordinateMapEntry[2])));
			}
			coordinateMapScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public double getLatitude(String key) {
		if (!coordinates.containsKey(key)) {
			alertMissingKey(key);
			coordinates.put(key, new Coordinates());
		}
		return coordinates.get(key).latitude;
	}

	public double getLongitude(String key) {
		if (!coordinates.containsKey(key)) {
			alertMissingKey(key);
			coordinates.put(key, new Coordinates());
		}
		return coordinates.get(key).longitude;
	}

	public void alertMissingKey(String key) {
		System.out.println(key);
	}

}
