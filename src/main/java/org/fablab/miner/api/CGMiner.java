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
		return process(miner, "summary", Summary.class);
	}

	public Pools pools(Miner miner) {
		return process(miner, "pools", Pools.class);
	}

	public Version version(Miner miner) {
		return process(miner, "version", Version.class);
	}

	public Stats stats(Miner miner) {
		String query = createQuery("stats");
		String result = JSONSyntaxCorrector.correctSyntax(commandService.process(query, miner));
		return parseResponse(result, "STATS".toUpperCase(), Stats.class);
	}

	private <T> T process(Miner miner, String command, Class<T> clazz) {
		String query = createQuery(command);
		String result = commandService.process(query, miner);
		return parseResponse(result, command.toUpperCase(), clazz);
	}

	private <T> T parseResponse(String json, String arrayName, Class<T> type) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray(arrayName).get(0).toString(), type);
	}

	private String createQuery(String command) {
		JSONObject json = new JSONObject();
		json.put("command", command);
		return json.toString();
	}

}
