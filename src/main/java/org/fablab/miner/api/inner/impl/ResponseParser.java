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

	public <T> T parseResponse(String json, String arrayName, Class<T> type) {
		return parseResponse(json, arrayName, 0, type);
	}

	public <T> T parseResponse(String json, String arrayName, int index, Class<T> type) {
		Status status = parseStatus(json);
		if (status.getStatus().equals("S")) {
			JSONObject jsonObj = new JSONObject(json);
			T result = gson.fromJson(jsonObj.getJSONArray(arrayName).get(index).toString(), type);
			return getInstanceWithStatus(status, result);
		}
		return getInstanceWithStatus(status, createInstance(type));
	}

	private <T> T createInstance(Class<T> type) {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private <T> T getInstanceWithStatus(Status status, T result) {
		if (result instanceof ResponseWithStatus) {
			ResponseWithStatus withStatus = (ResponseWithStatus) result;
			withStatus.setStatus(status);
			return result;
		}
		return result;
	}

	public Status parseStatus(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray("STATUS").get(0).toString(), Status.class);
	}
}
