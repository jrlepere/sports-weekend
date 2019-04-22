package com.jrlepere.sports_weekend_data_extractor.games_loader.espn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jrlepere.sports_weekend_data_extractor.Game;
import com.jrlepere.sports_weekend_data_extractor.games_loader.coodinate_map.CoordinateMap;

public class EspnFootballWeekGamesParser {

	private String url;
	private CoordinateMap coordinateMap;
	private String sport;

	public EspnFootballWeekGamesParser(String url, String sport, CoordinateMap coordinateMap) {
		this.url = url;
		this.coordinateMap = coordinateMap;
		this.sport = sport;
	}

	public Set<Game> loadGames() {
		Set<Game> games = new HashSet<>();
		try {
			Document espnFootballDoc = Jsoup.connect(url).get();
			Element scheduleContainer = espnFootballDoc.getElementById("sched-container");
			Elements captions = scheduleContainer.getElementsByClass("table-caption");
			Elements gamesElements = scheduleContainer.getElementsByClass("responsive-table-wrap");
			for (int i = 0; i < captions.size(); i++) {
				String date = getDate(captions.get(i));
				for (Element gameTableRecord : gamesElements.get(i).select("tbody").get(0).select("tr")) {
					//System.out.println(gameTableRecord);
					Game game = new Game();
					game.setSport(sport);
					game.setDate(date);
					game.setTime(getTime(gameTableRecord));
					game.setTeam1(getTeam1(gameTableRecord));
					game.setTeam2(getTeam2(gameTableRecord));
					game.setTeam1LogoUrl(getTeam1LogoUrl(gameTableRecord));
					game.setTeam2LogoUrl(getTeam2LogoUrl(gameTableRecord));
					String location = getLocation(gameTableRecord);
					game.setLatitude(coordinateMap.getLatitude(location));
					game.setLongitude(coordinateMap.getLongitude(location));
					games.add(game);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return games;
	}

	private String getDate(Element dateCaption) throws ParseException {
		return dateCaption.text();
	}

	private String getTeam1(Element gameTableRecord) {
		return gameTableRecord.getElementsByClass("team-name").get(0).select("abbr").get(0).text();
	}

	private String getTeam2(Element gameTableRecord) {
		return gameTableRecord.getElementsByClass("team-name").get(1).select("abbr").get(0).text();
	}
	
	private String getTeam1LogoUrl(Element gameTableRecord) {
		return gameTableRecord.getElementsByClass("teams").get(0).select("img").attr("src");
	}
	
	private String getTeam2LogoUrl(Element gameTableRecord) {
		return gameTableRecord.getElementsByClass("teams").get(1).select("img").attr("src");
	}

	private String getLocation(Element gameTableRecord) {
		return gameTableRecord.getElementsByClass("schedule-location").text();
	}

	private String getTime(Element gameTableRecord) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			format.setTimeZone(TimeZone.getTimeZone("ET"));
			Date d = format.parse(gameTableRecord.select("td[data-date]").get(0).attr("data-date"));
			DateFormat outFormat = new SimpleDateFormat("h:mm a");
			return outFormat.format(d) + " PST";
		} catch (Exception e) {
			return "TBD";
		}
	}

}
