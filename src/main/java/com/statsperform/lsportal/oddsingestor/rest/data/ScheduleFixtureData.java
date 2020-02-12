package com.statsperform.lsportal.oddsingestor.rest.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ScheduleFixtureData
{
	public ScheduleFixtureData (JSONObject inplayEventData) throws JSONException, ParseException
	{
		fixtureId = inplayEventData.getInt("FixtureId");
		
		JSONObject jsonObjectFixture = inplayEventData.getJSONObject("Fixture");
		fixtureData = new Fixture(jsonObjectFixture);
		
		JSONArray jsonArrProviders = inplayEventData.getJSONArray("Providers");
		if (jsonArrProviders!=null)
		{
			for (int i=0;i<jsonArrProviders.length();i++)
			{
				JSONObject objProvider = jsonArrProviders.getJSONObject(i);
				BasicResource provider = new BasicResource (objProvider);
				providers.add(provider);
			}
		}
	}
	
	@Getter @Setter
	private int fixtureId;

	@Getter @Setter
	private Fixture fixtureData;

	@Getter @Setter
	private List<BasicResource> providers = new ArrayList<>();
}
