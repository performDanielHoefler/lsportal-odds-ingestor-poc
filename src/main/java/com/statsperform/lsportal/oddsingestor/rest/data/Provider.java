package com.statsperform.lsportal.oddsingestor.rest.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider
{
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String name;
}