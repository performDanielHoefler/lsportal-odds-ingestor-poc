package com.statsperform.lsportal.oddsingestor.rest.data;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BasicResource
{
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String name;
	
	public BasicResource (JSONObject jsonObj) throws JSONException
	{
		id = jsonObj.getInt("Id");
		name = jsonObj.getString("Name");
	}
}