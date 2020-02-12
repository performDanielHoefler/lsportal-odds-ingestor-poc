package com.statsperform.lsportal.oddsingestor.rest.data;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;

@Data
public class Team extends BasicResource
{
	@Getter
	private String position;

	public Team(JSONObject jsonObjTeam) throws JSONException
	{
		super(jsonObjTeam);
		this.position = jsonObjTeam.getString("Position");
	}
}