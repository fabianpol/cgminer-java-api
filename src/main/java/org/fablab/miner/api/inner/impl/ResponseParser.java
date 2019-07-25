package org.fablab.miner.api.inner.impl;

import org.fablab.miner.api.ResponseWithStatus;
import org.fablab.miner.api.Status;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResponseParser {
	
	private Gson gson;
	
	public ResponseParser() {
		this.gson = new GsonBuilder().setLenient().create();
	}

	public Status parseStatus(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray("STATUS").get(0).toString(), Status.class);
	}

	public <T> T parseResponse(String json, String arrayName, int index, Class<T> type) {
		JSONObject jsonObj = new JSONObject(json);
		T result = gson.fromJson(jsonObj.getJSONArray(arrayName).get(index).toString(), type);
		if (result instanceof ResponseWithStatus) {
			ResponseWithStatus withStatus = (ResponseWithStatus) result;
			withStatus.setStatus(parseStatus(json));
		}
		return result;
	}
	
}
