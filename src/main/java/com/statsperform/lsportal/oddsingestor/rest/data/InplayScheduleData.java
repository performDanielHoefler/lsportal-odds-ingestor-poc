package com.statsperform.lsportal.oddsingestor.rest.data;

import java.util.List;

import lombok.Data;

@Data
public class InplayScheduleData
{
	private int fixtureId;
	private Fixture fixtureData;
	private List<Provider> providers;
}