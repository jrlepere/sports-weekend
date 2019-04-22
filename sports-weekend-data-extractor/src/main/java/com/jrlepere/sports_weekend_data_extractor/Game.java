package com.jrlepere.sports_weekend_data_extractor;

public class Game {

	private String sport, team1, team2, date, time, team1LogoUrl, team2LogoUrl = "";
	private double latitude, longitude = 0.0;

	public String getTime() {
		return time;
	}

	public String getTeam1LogoUrl() {
		return team1LogoUrl;
	}

	public void setTeam1LogoUrl(String team1LogoUrl) {
		this.team1LogoUrl = team1LogoUrl;
	}

	public String getTeam2LogoUrl() {
		return team2LogoUrl;
	}

	public void setTeam2LogoUrl(String team2LogoUrl) {
		this.team2LogoUrl = team2LogoUrl;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int hashCode() {
		return (sport + team1 + team2 + date + time).hashCode();
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Game))
			return false;
		Game oGame = (Game) o;
		return (sport + team1 + team2 + date + time)
				.equals((oGame.sport + oGame.team1 + oGame.team2 + oGame.date + oGame.time));
	}

}
