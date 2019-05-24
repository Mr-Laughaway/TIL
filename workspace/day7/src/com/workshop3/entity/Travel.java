package com.workshop3.entity;

public class Travel {
	private String travelCode;
	private String cityName;
	private String flight;
	private int travelType;
	private int maxPeople;
	private int reserved;
	public static final int INDIVIDUAL = 0;
	public static final int PACKAGE = 1;
	
	public Travel(String travelCode, String cityName, String flight, int travelType, int maxPeople) {
		this.travelCode = travelCode;
		this.cityName = cityName;
		this.flight = flight;
		this.travelType = travelType;
		this.maxPeople = maxPeople;
	}

	public String getTravelCode() {
		return travelCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getFlight() {
		return flight;
	}

	public int getTravelType() {
		return travelType;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public int getReserved() {
		return reserved;
	}
	
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	
	public void printTravelInfo() {
		String s = String.format("%-10s%-10s%-10s%-10s%-10s%-10s"
				, travelCode
				, cityName
				, flight
				, travelType == INDIVIDUAL ? "개별자유여행" : "패키지여행"
				, maxPeople + "명"
				, reserved + "명"
		).replace(" ","  ");
		System.out.println(s);
	}
}
