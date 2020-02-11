package com.statsperform.lsportal.oddsingestor.rest.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Team extends FixtureResource
{
	public Team (int id, String name, String position)
	{
		super (id, name);
		this.position = position;
	}
	
	@Getter @Setter
	private String position;
}