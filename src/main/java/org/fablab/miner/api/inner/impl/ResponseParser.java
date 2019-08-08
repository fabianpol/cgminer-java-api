package org.fablab.miner.api.inner.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.fablab.miner.api.ResponseWithStatus;
import org.fablab.miner.api.Status;
import org.json.JSONObject;

import com.google.gson.Gson;

public class ResponseParser {

	private static final Logger LOGGER = Logger.getLogger(ResponseParser.class);

	private Gson gson;

	@Inject
	public ResponseParser(Gson gson) {
		this.gson = gson;
	}

	public <T> T parseResponse(String json, String arrayName, Class<T> type) {
		return parseResponse(json, arrayName, -1, type);
	}

	public <T> T parseResponse(String json, String arrayName, int index, Class<T> type) {
		Status status = parseQueryStatus(json);
		if (status.getStatus().equals("S")) {
			JSONObject jsonObj = new JSONObject(json);
			if(index == -1) {
				T result = gson.fromJson(jsonObj.getJSONArray(arrayName).toString(), type);
				return getInstanceWithStatus(status, result);
			}else {
				T result = gson.fromJson(jsonObj.getJSONArray(arrayName).get(index).toString(), type);
				return getInstanceWithStatus(status, result);
			}
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

	public Status parseQueryStatus(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray("STATUS").get(0).toString(), Status.class);
	}

	public UpdateStatus parseUpdateStatus(String json) {
		try {
			JSONObject jsonObj = new JSONObject(json);
			return gson.fromJson(jsonObj.toString(), UpdateStatus.class);
		} catch (Exception e) {
			LOGGER.trace("Something goes wrong with update command.", e);
			return parseQueryStatus(json);
		}
	}
}
