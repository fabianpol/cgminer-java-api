package org.fablab.miner.api.inner.impl;

import javax.inject.Inject;

import org.fablab.miner.api.ResponseWithStatus;
import org.fablab.miner.api.Status;
import org.json.JSONObject;

import com.google.gson.Gson;

public class ResponseParser {

	private Gson gson;

	@Inject
	public ResponseParser(Gson gson) {
		this.gson = gson;
	}

	public Status parseStatus(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray("STATUS").get(0).toString(), Status.class);
	}

	public <T> T parseResponse(String json, String arrayName, Class<T> type) {
		return parseResponse(json, arrayName, 0, type);
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
