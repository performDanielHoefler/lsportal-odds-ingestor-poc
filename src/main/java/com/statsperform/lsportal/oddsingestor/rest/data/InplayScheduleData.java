package com.statsperform.lsportal.oddsingestor.rest.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;

@Data
public class InplayScheduleData
{
	@Getter
	private LSportRestHeaderData headerData;
	
	@Getter
	private List<ScheduleFixtureData> scheduleFixtureData = new ArrayList<>();
	
	public InplayScheduleData(JSONObject jsonObject) throws JSONException, ParseException
	{
		headerData = new LSportRestHeaderData(jsonObject.getJSONObject("Header"));
		
		JSONObject bodyObj = jsonObject.getJSONObject("Body");
		if (bodyObj!=null)
		{
			JSONArray inplayEventsArr = bodyObj.getJSONArray("InPlayEvents");
			if (inplayEventsArr!=null)
			{
				for (int i=0;i<inplayEventsArr.length();i++)
				{
					JSONObject objInPlayEvent = inplayEventsArr.getJSONObject(i);
					ScheduleFixtureData fixtureData = new ScheduleFixtureData (objInPlayEvent);
					scheduleFixtureData.add (fixtureData);
				}
			}
		}
	}
}