package com.statsperform.lsportal.oddsingestor.rest.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class FixtureResource
{
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String name;
}