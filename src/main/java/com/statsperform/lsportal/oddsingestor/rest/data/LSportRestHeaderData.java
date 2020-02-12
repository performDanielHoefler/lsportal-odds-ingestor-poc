package com.statsperform.lsportal.oddsingestor.rest.data;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.Data;
import lombok.Getter;

@Data
public class LSportRestHeaderData
{
	@Getter
	private int type;

	@Getter
	private String msgGuid;

	@Getter
	private long serverTimestamp;

	public LSportRestHeaderData(JSONObject jsonObjHeader) throws JSONException
	{
		this.type = jsonObjHeader.getInt("Type");
		this.msgGuid = jsonObjHeader.getString("MsgGuid");
		this.serverTimestamp = jsonObjHeader.getLong("ServerTimestamp");
	}
}