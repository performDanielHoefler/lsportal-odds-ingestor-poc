package com.statsperform.lsportal.oddsingestor.rest.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Fixture
{
	private static final SimpleDateFormat sdfStartDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	private static final SimpleDateFormat sdfLastUpdate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
	
	@Getter @Setter
	private BasicResource sport;
	
	@Getter @Setter
	private BasicResource location;
	
	@Getter @Setter
	private BasicResource league;
	
	@Getter @Setter
	private Date startDate;
	
	@Getter @Setter
	private Date lastUpdate;
	
	@Getter @Setter
	private int status;
	
	@Getter @Setter
	private List<Team> participants = new ArrayList<>();
	
	public Fixture (JSONObject jsonObj) throws JSONException, ParseException
	{
		JSONObject objSport = jsonObj.getJSONObject("Sport");
		if (objSport!=null)
		{
			sport = new BasicResource(objSport);
		}
		
		JSONObject objLocation = jsonObj.getJSONObject("Location");
		if (objLocation!=null)
		{
			location = new BasicResource(objLocation);
		}
		
		JSONObject objLeague = jsonObj.getJSONObject("League");
		if (objLocation!=null)
		{
			league = new BasicResource(objLeague);
		}
		
		String startDateString = jsonObj.getString("StartDate");
		startDate = sdfStartDate.parse(startDateString);
		
		String lastUpdateString = jsonObj.getString("LastUpdate");
		lastUpdate = sdfLastUpdate.parse(lastUpdateString);
		
		status = jsonObj.getInt("Status");
		
		JSONArray jsonArrParticipants = jsonObj.getJSONArray("Participants");
		if (jsonArrParticipants!=null)
		{
			for (int i=0;i<jsonArrParticipants.length();i++)
			{
				JSONObject jsonObjParticipant = jsonArrParticipants.getJSONObject(i);
				Team participant = new Team(jsonObjParticipant);
				participants.add(participant);
			}
		}
	}
}