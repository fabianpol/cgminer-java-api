package org.fablab.miner.api;

import org.fablab.miner.inner.impl.CommandService;
import org.fablab.miner.inner.impl.JSONSyntaxCorrector;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CGMiner {

	private CommandService commandService;
	private Gson gson;

	public CGMiner() {
		this.commandService = new CommandService();
		this.gson = new GsonBuilder().setLenient().create();
	}

	public Summary summary(Miner miner) {
		return parse(miner, "summary", Summary.class);
	}

	public Pools pools(Miner miner) {
		return parse(miner, "pools", Pools.class);
	}

	public Version version(Miner miner) {
		return parse(miner, "version", Version.class);
	}

	public Stats stats(Miner miner) {
		String result = JSONSyntaxCorrector.correctSyntax(query(miner, "stats"));
		return parseResponse(result, "STATS", 1, Stats.class);
	}

	private <T> T parse(Miner miner, String command, Class<T> clazz) {
		String result = query(miner, command);
		return parseResponse(result, command.toUpperCase(), clazz);
	}

	private String query(Miner miner, String command) {
		String query = createQuery(command);
		String result = commandService.process(query, miner);
		return result;
	}

	private <T> T parseResponse(String json, String arrayName, Class<T> type) {
		return parseResponse(json, arrayName, 0, type);
	}

	private <T> T parseResponse(String json, String arrayName, int index, Class<T> type) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray(arrayName).get(index).toString(), type);
	}

	private String createQuery(String command) {
		JSONObject json = new JSONObject();
		json.put("command", command);
		return json.toString();
	}

}
