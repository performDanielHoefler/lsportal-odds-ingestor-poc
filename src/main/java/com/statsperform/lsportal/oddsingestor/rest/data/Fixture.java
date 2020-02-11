package com.statsperform.lsportal.oddsingestor.rest.data;

import java.util.Calendar;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Fixture
{
	@Getter @Setter
	private FixtureResource sport;
	
	@Getter @Setter
	private FixtureResource location;
	
	@Getter @Setter
	private FixtureResource league;
	
	@Getter @Setter
	private Calendar startDate;
	
	@Getter @Setter
	private Calendar lastUpdate;
	
	@Getter @Setter
	private int status;
	
	@Getter @Setter
	private List<Team> participants;
}